package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.garment.*;
import Nanali.dtos.weather.GarmentWeatherRequest;
import Nanali.service.GarmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/garment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GarmentController {

    private final GarmentService garmentService;

    @GetMapping
    public GarmentResponseDto Garment(@RequestParam Double temp, @RequestParam Double uv,
                                      @RequestParam Double rain, @RequestParam Sex sex) {
        List<Garment> outers = garmentService.findOuters(temp, uv, rain, sex);
        List<Garment> tops = garmentService.findTops(temp, uv, rain, sex);
        List<Garment> pants = garmentService.findPants(temp, uv, rain, sex);
        List<Garment> shoes = garmentService.findShoes(temp, uv, rain, sex);

        List<GarmentDto> outerList = outers.stream()
                .map(o -> GarmentDto.convert(o)).collect(Collectors.toList());

        List<GarmentDto> topList = tops.stream()
                .map(t -> GarmentDto.convert(t)).collect(Collectors.toList());

        List<GarmentDto> pantsList = pants.stream()
                .map(p -> GarmentDto.convert(p)).collect(Collectors.toList());

        List<GarmentDto> shoesList = shoes.stream()
                .map(s -> GarmentDto.convert(s)).collect(Collectors.toList());

        return new GarmentResponseDto(outerList, topList, pantsList, shoesList);
    }

    @PostMapping
    public void InsertGarment(@Valid @RequestPart InsertGarmentDto request,
                              @RequestPart MultipartFile garmentImg) {

        GarmentWeatherRequest weather = GarmentWeatherRequest.builder()
                .tempFrom(request.getTempFrom())
                .tempTo(request.getTempTo())
                .uvFrom(request.getUvFrom())
                .uvTo(request.getUvTo())
                .rainFrom(request.getRainFrom())
                .rainTo(request.getRainTo()).build();

        garmentService.save(garmentImg, request.getCategory(), request.getSex(), weather);
    }

    @GetMapping("/garment/{garmentId}")
    public GarmentOneResponseDto garmentOne (@PathVariable Long detailId) {
        Garment garment = garmentService.findById(detailId);
        String imgUrl = garment.getImgUrl();

        return new GarmentOneResponseDto(imgUrl);
    }
}
