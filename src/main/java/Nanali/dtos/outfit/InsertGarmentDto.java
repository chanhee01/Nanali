package Nanali.dtos.outfit;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.weather.GarmentWeatherRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertGarmentDto {

    private Category category;
    private Sex sex;
    private GarmentWeatherRequest weather;
}
