package Nanali.controller;

import Nanali.domain.cody.cloth.Outfit;
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

        outfitService.save(outfitImg, request.getStyle(), request.getSex(), weather);
    }

}
