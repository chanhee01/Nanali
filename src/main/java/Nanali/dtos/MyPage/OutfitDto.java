package Nanali.dtos.MyPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitDto {

    String nickname;
    String email;
    List<String> outfits;
}
