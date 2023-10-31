package Nanali.dtos.outfit;

import Nanali.domain.cody.cloth.Outfit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitResponseDto {

    private String outfitUrl;

    private ResponseEntity<Map<String, Map<String, Object>>> weather;
}
