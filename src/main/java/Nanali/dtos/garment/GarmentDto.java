package Nanali.dtos.garment;

import Nanali.domain.cody.cloth.Garment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class GarmentDto {
    private Long id;
    private String imgUrl;

    public static GarmentDto convert(Garment garment) {
        return GarmentDto.builder()
                .id(garment.getId())
                .imgUrl(garment.getImgUrl()).build();
    }
}
