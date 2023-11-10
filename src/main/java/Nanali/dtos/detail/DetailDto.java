package Nanali.dtos.detail;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.detail.Detail;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailDto {
    private Long id;
    private String imgUrl;

    public static DetailDto convert(Detail detail) {
        return DetailDto.builder()
                .id(detail.getId())
                .imgUrl(detail.getImgUrl()).build();
    }
}
