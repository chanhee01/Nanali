package Nanali.dtos.garment;

import Nanali.domain.cody.cloth.Garment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarmentResponseDto {

    private List<Garment> outers;
    private List<Garment> tops;
    private List<Garment> pants;
    private List<Garment> shoes;
}
