package Nanali.domain.Member.dto;

import Nanali.domain.garment.dto.GarmentDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LikeGarmentDto {

    private String nickname;
    private String email;
    private String memberImg;

    private List<GarmentDto> outers;
    private List<GarmentDto> tops;
    private List<GarmentDto> pants;
    private List<GarmentDto> shoes;
}
