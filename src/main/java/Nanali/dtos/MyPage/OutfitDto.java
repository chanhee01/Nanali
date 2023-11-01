package Nanali.dtos.MyPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitDto {

    private String nickname;
    private String email;
    private String memberImg;
    private List<String> outfits;
}
