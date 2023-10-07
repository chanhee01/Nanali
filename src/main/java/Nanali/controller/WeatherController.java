package Nanali.controller;

import Nanali.dtos.weather.WeatherRequest;
import Nanali.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Map<String, Map<String, Object>>> weather(@RequestBody WeatherRequest weatherRequest) throws IOException {
        LocalDateTime time = weatherRequest.getTime();
        ResponseEntity<Map<String, Map<String, Object>>> weather = weatherService.weather(time);
        return weather;
    }
}
