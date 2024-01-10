package Nanali.domain.Member.dto;

import Nanali.domain.outfit.dto.OutfitDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LikeOutfitDto {

    private String nickname;
    private String email;
    private String memberImg;
    private List<OutfitDto> outfits;
}
