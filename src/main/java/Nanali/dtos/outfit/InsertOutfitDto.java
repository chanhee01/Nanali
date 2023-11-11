package Nanali.dtos.outfit;


import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Sex;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertOutfitDto {
    @NotBlank
    private Style style;

    @NotBlank
    private Sex sex;

    @NotBlank
    @Range(min = -10, max = 20)
    private Double tempFrom;

    @NotBlank
    @Range(min = -10, max = 20)
    private Double tempTo;

    @NotBlank
    @Range(min = 0, max = 2)
    private Double uvFrom;

    @NotBlank
    @Range(min = 0, max = 2)
    private Double uvTo;

    @NotBlank
    @Range(min = 0, max = 100)
    private Double rainFrom;

    @NotBlank
    @Range(min = 0, max = 100)
    private Double rainTo;
}
