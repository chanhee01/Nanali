package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.dtos.garment.*;
import Nanali.dtos.weather.GarmentWeatherRequest;
import Nanali.service.GarmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/garment")
public class GarmentController {

    private final GarmentService garmentService;

    @GetMapping
    public GarmentResponseDto Garment(@RequestBody GarmentRequestDto request) {
        List<Garment> outers = garmentService.findOuters(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> tops = garmentService.findTops(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> pants = garmentService.findPants(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> shoes = garmentService.findShoes(request.getTemp(), request.getUv(), request.getRain(), request.getSex());


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
    public void InsertGarment(@RequestPart InsertGarmentDto request,
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

    @GetMapping("garment/{garmentId}")
    public GarmentOneResponseDto garmentOne (@PathVariable Long detailId) {
        Garment garment = garmentService.findById(detailId);
        String imgUrl = garment.getImgUrl();

        return new GarmentOneResponseDto(imgUrl);
    }
}
