package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.garment.GarmentRequestDto;
import Nanali.dtos.garment.GarmentResponseDto;
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
    public GarmentResponseDto Garment(@RequestBody GarmentRequestDto request) {
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

        return new GarmentResponseDto(outerList, topList, pantsList, shoesList);
    }

    @PostMapping
    public void InsertGarment(@RequestPart(value = "garment") InsertGarmentDto request,
                              @RequestPart(value = "garmentImg") MultipartFile outfitImg) {
        GarmentWeatherRequest weather = new GarmentWeatherRequest(request.getTemp_from(), request.getTemp_to(), request.getUv_from(),
                request.getUv_to(), request.getRain_from(), request.getRain_to());

        garmentService.save(outfitImg, request.getCategory(), request.getSex(), weather);
    }
}
