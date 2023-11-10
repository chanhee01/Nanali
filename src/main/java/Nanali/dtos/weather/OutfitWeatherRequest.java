package Nanali.dtos.weather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutfitWeatherRequest {

    private Double tempFrom;
    private Double tempTo;
    private Double uvFrom;
    private Double uvTo;
    private Double rainFrom;
    private Double rainTo;
}
