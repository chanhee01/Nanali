package Nanali.domain.detail.dto;

import Nanali.global.base.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertDetailDto {

    @NotNull
    private Category category;

    @NotNull
    private Long outfitId;
}
