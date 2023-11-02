package Nanali.dtos.garment;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertGarmentDto {

    private Category category;
    private Sex sex;
    private Long temp_from;
    private Long temp_to;
    private Long uv_from;
    private Long uv_to;
    private Long rain_from;
    private Long rain_to;
}
