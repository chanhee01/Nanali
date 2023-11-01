package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.dtos.garment.GarmentRequestDto;
import Nanali.dtos.garment.GarmentResponseDto;
import Nanali.dtos.outfit.InsertGarmentDto;
import Nanali.service.GarmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
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

        return new GarmentResponseDto(outers, tops, pants, shoes);
    }

    @PostMapping
    public void InsertGarment(@RequestPart(value = "garment") InsertGarmentDto request,
                              @RequestPart(value= "garmentImg") MultipartFile outfitImg) {
        garmentService.save(outfitImg, request.getCategory(), request.getSex(), request.getWeather());
    }
}
