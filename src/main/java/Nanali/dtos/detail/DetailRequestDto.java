package Nanali.dtos.detail;

import Nanali.dtos.garment.GarmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailRequestDto {

    private String outfit;
    private GarmentDto outer;
    private GarmentDto top;
    private GarmentDto pants;
    private GarmentDto shoes;
}
