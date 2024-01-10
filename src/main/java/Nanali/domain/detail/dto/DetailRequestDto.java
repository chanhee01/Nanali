package Nanali.domain.detail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailRequestDto {

    private String outfitImg;
    private DetailDto outer;
    private DetailDto top;
    private DetailDto pants;
    private DetailDto shoes;
}
