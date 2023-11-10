package Nanali.dtos.MyPage;

import Nanali.dtos.garment.GarmentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
