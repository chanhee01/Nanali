package Nanali.domain.garment.dto;

import Nanali.domain.garment.model.Garment;
import lombok.Builder;
import lombok.Data;

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
