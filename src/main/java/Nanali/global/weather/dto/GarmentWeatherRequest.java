package Nanali.global.weather.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GarmentWeatherRequest {

    private Double tempFrom;
    private Double tempTo;
    private Double uvFrom;
    private Double uvTo;
    private Double rainFrom;
    private Double rainTo;
}
