package Nanali.controller;

import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.detail.Detail;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.outfit.DetailRequestDto;
import Nanali.dtos.outfit.InsertOutfitDto;
import Nanali.dtos.outfit.OutfitRequestDto;
import Nanali.dtos.outfit.OutfitResponseDto;
import Nanali.dtos.weather.OutfitWeatherRequest;
import Nanali.service.DetailService;
import Nanali.service.OutfitService;
import Nanali.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/outfit")
public class OutfitController {

    private final OutfitService outfitService;

    private final WeatherService weatherService;

    private final DetailService detailService;

    @GetMapping
    public OutfitResponseDto Outfit(@RequestBody OutfitRequestDto request) throws Exception {
        LocalDateTime time = LocalDateTime.now();
        ResponseEntity<Map<String, Map<String, Object>>> weather = weatherService.weather(time);

        Map<String, Object> currentWeather = weatherService.getCurrentWeather(weather.getBody());

        double temperature = (double) currentWeather.get("temperature");
        double precipitation = (double) currentWeather.get("precipitation");
        double uvIndex = (double) currentWeather.get("uv_index");

        Outfit outfit = outfitService.findOutfit(temperature, precipitation, uvIndex,
                request.getStyle(), request.getSex());
        String imgUrl = outfit.getImgUrl();

        return new OutfitResponseDto(outfit.getId(), imgUrl, weather);
    }

    @PostMapping
    public void InsertOutfit(@RequestPart(value = "outfit") InsertOutfitDto request,
                             @RequestPart(value = "outfitImg") MultipartFile outfitImg) {
        OutfitWeatherRequest weather = new OutfitWeatherRequest(request.getTemp_from(), request.getTemp_to(), request.getUv_from(),
                request.getUv_to(), request.getRain_from(), request.getRain_to());

        System.out.println(weather);

        outfitService.save(outfitImg, request.getStyle(), request.getSex(), weather);
    }

    @GetMapping("/detail/{outfitId}")
    public DetailRequestDto details(@PathVariable("outfitId") Long id) {
        Outfit outfit = outfitService.findOne(id);

        Detail outer = detailService.findOuter(id);
        Detail top = detailService.findTop(id);
        Detail pants = detailService.findPants(id);
        Detail shoes = detailService.findShoes(id);

        GarmentDto outerDto = new GarmentDto(outer.getId(), outer.getImgUrl());
        GarmentDto topDto = new GarmentDto(top.getId(), top.getImgUrl());
        GarmentDto pantsDto = new GarmentDto(pants.getId(), pants.getImgUrl());
        GarmentDto shoesDto = new GarmentDto(shoes.getId(), shoes.getImgUrl());

        return new DetailRequestDto(outfit.getImgUrl(), outerDto, topDto, pantsDto, shoesDto);
    }
}
