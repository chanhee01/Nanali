package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
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
    private final MemberService memberService;

    @GetMapping
    public OutfitResponseDto Outfit(@RequestBody OutfitRequestDto request) throws Exception {
        LocalDateTime time = request.getTime();
        ResponseEntity<Map<String, Map<String, Object>>> weather = weatherService.weather(time);

        Member member = memberService.findById(1L);

        Style style;
        Sex sex = Sex.BOTH;

        if (request.getStyle() == null) {
            style = member.getStyle();
        } else {
            style = request.getStyle();
        }

        if (request.getSex() == null) {
            if(member.isSex()) sex = Sex.MAN;
            else if(!member.isSex()) sex = Sex.WOMAN;
        } else {
            sex = request.getSex();
        }

        Map<String, Object> currentWeather = weatherService.getCurrentWeather(weather.getBody(), request.getTime());

        double temperature = (double) currentWeather.get("temperature");
        double precipitation = (double) currentWeather.get("precipitation");
        double uvIndex = (double) currentWeather.get("uv_index");

        System.out.println("sex :" + sex + "style :" + style);

        Outfit outfit = outfitService.findOutfit(temperature, precipitation, uvIndex, style, sex);
        String imgUrl = outfit.getImgUrl();

        return new OutfitResponseDto(outfit.getId(), imgUrl, weather);
    }

    @PostMapping
    public void InsertOutfit(@RequestPart InsertOutfitDto request,
                             @RequestPart MultipartFile outfitImg) {
        OutfitWeatherRequest weather = new OutfitWeatherRequest(request.getTempFrom(), request.getTempTo(), request.getUvFrom(),
                request.getUvTo(), request.getRainFrom(), request.getRainTo());

        outfitService.save(outfitImg, request.getStyle(), request.getSex(), weather);
    }
}
