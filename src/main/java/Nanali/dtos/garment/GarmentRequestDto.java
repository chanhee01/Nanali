package Nanali.dtos.garment;

import Nanali.domain.cody.cloth.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentRequestDto {

    private Double temp;
    private Double uv;
    private Double rain;

    private Sex sex;
}
