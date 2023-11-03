package Nanali.dtos.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentWeatherRequest {

    private Double temp_from;
    private Double temp_to;
    private Double uv_from;
    private Double uv_to;
    private Double rain_from;
    private Double rain_to;
}
