package Nanali.dtos.outfit;


import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.weather.OutfitWeatherRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertOutfitDto {

    private Style style;
    private Sex sex;
    private OutfitWeatherRequest weather;
}
