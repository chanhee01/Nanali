package Nanali.dtos.garment;

import Nanali.domain.cody.cloth.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentRequestDto {

    @NotBlank
    @Range(min = -10, max = 30)
    private Double temp;

    @NotBlank
    @Range(min = 0, max = 2)
    private Double uv;

    @NotBlank
    @Range(min = 0, max = 100)
    private Double rain;

    @NotNull
    private Sex sex;
}
