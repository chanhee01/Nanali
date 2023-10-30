package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.dtos.garment.GarmentRequestDto;
import Nanali.dtos.garment.GarmentResponseDto;
import Nanali.service.GarmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/garment")
public class GarmentController {

    private final GarmentService garmentService;

    @GetMapping
    public GarmentResponseDto Garment(@RequestBody GarmentRequestDto request) {
        List<Garment> outers = garmentService.findOuters(request.getTemp(), request.getUv(), request.getRain());
        List<Garment> tops = garmentService.findTops(request.getTemp(), request.getUv(), request.getRain());
        List<Garment> pants = garmentService.findPants(request.getTemp(), request.getUv(), request.getRain());
        List<Garment> shoes = garmentService.findShoes(request.getTemp(), request.getUv(), request.getRain());

        return new GarmentResponseDto(outers, tops, pants, shoes);
    }
}
