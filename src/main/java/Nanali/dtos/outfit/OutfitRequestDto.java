package Nanali.dtos.outfit;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRequestDto {

    private Style style;

    private Sex sex;
}
