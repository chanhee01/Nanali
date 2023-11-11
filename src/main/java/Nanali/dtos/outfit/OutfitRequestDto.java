package Nanali.dtos.outfit;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRequestDto {

    @Nullable
    private Style style;

    @Nullable
    private Sex sex;

    @NotNull
    private LocalDateTime time;
}
