package Nanali.dtos.detail;

import Nanali.domain.cody.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertDetailDto {

    @NotBlank
    private Category category;

    @NotBlank
    private Long outfitId;
}
