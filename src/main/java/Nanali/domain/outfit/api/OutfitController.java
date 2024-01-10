package Nanali.domain.outfit.api;

import Nanali.domain.Member.model.Member;
import Nanali.domain.Member.model.Style;
import Nanali.domain.outfit.model.Outfit;
import Nanali.global.base.Sex;
import Nanali.domain.outfit.dto.InsertOutfitDto;
import Nanali.domain.outfit.dto.OutfitResponseDto;
import Nanali.global.weather.dto.OutfitWeatherRequest;
import Nanali.domain.outfit.service.OutfitService;
import Nanali.global.login.SessionConst;
import Nanali.global.weather.WeatherService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/outfit")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OutfitController {

    private final OutfitService outfitService;
    private final WeatherService weatherService;
    private final HttpSession session;

    @GetMapping
    public OutfitResponseDto Outfit(@Nullable @RequestParam Style style, @Nullable @RequestParam Sex sex,
                                    @NotNull @RequestParam LocalDateTime time) throws Exception {

        ResponseEntity<Map<String, Map<String, Double>>> weather = weatherService.weather(time);

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);


        if (style == null) {
            style = member.getStyle();
        } else {
            style = style;
        }

        if (sex == null) {
            if(member.isSex()) sex = Sex.MAN;
            else if(!member.isSex()) sex = Sex.WOMAN;
        } else {
            sex = sex;
        }

        Map<String, Double> currentWeather = weatherService.getCurrentWeather(weather.getBody(), time);

        double temperature = currentWeather.get("temperature");
        double precipitation = currentWeather.get("precipitation");
        double uvIndex = currentWeather.get("uv_index");

        Outfit outfit = outfitService.findOutfit(temperature, precipitation, uvIndex, style, sex);
        String imgUrl = outfit.getImgUrl();

        return new OutfitResponseDto(outfit.getId(), imgUrl, weather);
    }

    @PostMapping
    public Long InsertOutfit(@Valid @RequestPart InsertOutfitDto request,
                             @RequestPart MultipartFile outfitImg) {

        OutfitWeatherRequest weather = OutfitWeatherRequest.builder()
                .tempFrom(request.getTempFrom())
                .tempTo(request.getTempTo())
                .uvFrom(request.getUvFrom())
                .uvTo(request.getUvTo())
                .rainFrom(request.getRainFrom())
                .rainTo(request.getRainTo()).build();

        Outfit save = outfitService.save(outfitImg, request.getStyle(), request.getSex(), weather);
        return save.getId();
    }
}
