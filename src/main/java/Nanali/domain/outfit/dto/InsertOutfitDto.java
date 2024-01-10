package Nanali.domain.outfit.dto;


import Nanali.domain.Member.model.Style;
import Nanali.global.base.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertOutfitDto {
    @NotNull
    private Style style;

    @NotNull
    private Sex sex;

    @NotNull
    @Range(min = -10, max = 20)
    private Double tempFrom;

    @NotNull
    @Range(min = -10, max = 30)
    private Double tempTo;

    @NotNull
    @Range(min = 0, max = 2)
    private Double uvFrom;

    @NotNull
    @Range(min = 0, max = 2)
    private Double uvTo;

    @NotNull
    @Range(min = 0, max = 100)
    private Double rainFrom;

    @NotNull
    @Range(min = 0, max = 100)
    private Double rainTo;
}
