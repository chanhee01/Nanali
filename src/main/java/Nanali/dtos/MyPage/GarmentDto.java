package Nanali.dtos.MyPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentDto {

    String nickname;
    String email;
    String memberImg;

    List<String> tops;
    List<String> pants;
    List<String> outers;
    List<String> shoes;
}
