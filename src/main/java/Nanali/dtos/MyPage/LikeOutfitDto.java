package Nanali.dtos.MyPage;

import Nanali.dtos.outfit.OutfitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class LikeOutfitDto {

    private String nickname;
    private String email;
    private String memberImg;
    private List<OutfitDto> outfits;
}
