package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.dtos.detail.DetailtResponseDto;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.garment.GarmentOneResponseDto;
import Nanali.dtos.garment.GarmentRequestDto;
import Nanali.dtos.garment.InsertGarmentDto;
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
    public Nanali.dtos.garment.GarmentResponseDto Garment(@RequestBody GarmentRequestDto request) {
        List<Garment> outers = garmentService.findOuters(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> tops = garmentService.findTops(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> pants = garmentService.findPants(request.getTemp(), request.getUv(), request.getRain(), request.getSex());
        List<Garment> shoes = garmentService.findShoes(request.getTemp(), request.getUv(), request.getRain(), request.getSex());

        List<GarmentDto> outerList = outers.stream()
                .map(o -> new GarmentDto(o.getId(), o.getImgUrl())).collect(Collectors.toList());

        List<GarmentDto> topList = tops.stream()
                .map(o -> new GarmentDto(o.getId(), o.getImgUrl())).collect(Collectors.toList());

        List<GarmentDto> pantsList = pants.stream()
                .map(o -> new GarmentDto(o.getId(), o.getImgUrl())).collect(Collectors.toList());

        List<GarmentDto> shoesList = shoes.stream()
                .map(o -> new GarmentDto(o.getId(), o.getImgUrl())).collect(Collectors.toList());

        return new Nanali.dtos.garment.GarmentResponseDto(outerList, topList, pantsList, shoesList);
    }

    @PostMapping
    public void InsertGarment(@RequestPart InsertGarmentDto request,
                              @RequestPart MultipartFile garmentImg) {
        GarmentWeatherRequest weather = new GarmentWeatherRequest(request.getTempFrom(), request.getTempTo(), request.getUvFrom(),
                request.getUvTo(), request.getRainFrom(), request.getRainTo());

        garmentService.save(garmentImg, request.getCategory(), request.getSex(), weather);
    }

    @GetMapping("garment/{garmentId}")
    public GarmentOneResponseDto garmentOne (@PathVariable Long detailId) {
        Garment garment = garmentService.findById(detailId);
        String imgUrl = garment.getImgUrl();

        return new GarmentOneResponseDto(imgUrl);
    }
}
