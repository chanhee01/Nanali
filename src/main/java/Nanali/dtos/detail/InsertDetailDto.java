package Nanali.dtos.detail;

import Nanali.domain.cody.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertDetailDto {

    private Category category;
    private Long outfitId;
}
