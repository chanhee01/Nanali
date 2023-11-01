package Nanali.dtos.MyPage;

import Nanali.dtos.garment.GarmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeGarmentDto {

    String nickname;
    String email;
    String memberImg;

    List<GarmentDto> tops;
    List<GarmentDto> pants;
    List<GarmentDto> outers;
    List<GarmentDto> shoes;
}
