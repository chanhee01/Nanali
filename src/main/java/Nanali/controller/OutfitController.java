package Nanali.controller;

import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.outfit.InsertOutfitDto;
import Nanali.dtos.outfit.OutfitRequestDto;
import Nanali.dtos.outfit.OutfitResponseDto;
import Nanali.dtos.weather.OutfitWeatherRequest;
import Nanali.service.MemberService;
import Nanali.service.OutfitService;
import Nanali.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/outfit")
public class OutfitController {

    private final OutfitService outfitService;

    private final WeatherService weatherService;

    @GetMapping
    public OutfitResponseDto Outfit(@RequestBody OutfitRequestDto request) throws Exception {
        Outfit outfit = outfitService.findOutfit(request.getTemp(), request.getUv(), request.getRain(),
                request.getStyle(), request.getSex());
        String imgUrl = outfit.getImgUrl();

        LocalDateTime time = LocalDateTime.now();
        ResponseEntity<Map<String, Map<String, Object>>> weather = weatherService.weather(time);

        return new OutfitResponseDto(imgUrl, weather);
    }

    @PostMapping
    public void InsertOutfit(@RequestPart(value = "outfit") InsertOutfitDto request,
                             @RequestPart(value= "outfitImg") MultipartFile outfitImg) {
        outfitService.save(outfitImg, request.getStyle(), request.getSex(), request.getWeather());
    }
}
