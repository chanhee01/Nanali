package Nanali.dtos.garment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentResponseDto {

    private List<GarmentDto> outers;
    private List<GarmentDto> tops;
    private List<GarmentDto> pants;
    private List<GarmentDto> shoes;
}
