package Nanali.dtos.MyPage;

import Nanali.dtos.outfit.OutfitDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeOutfitDto {

    private String nickname;
    private String email;
    private String memberImg;
    private List<OutfitDto> outfits;
}
