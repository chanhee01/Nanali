package Nanali.domain.weather;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Weather {

    @Id
    @GeneratedValue
    private Long Id;

    private Long range_start;

    private Long range_end;

    @Enumerated
    private WeatherType weatherType;

    @Enumerated
    private Precipitation precipitation;

    @Enumerated
    private UVIndex uvIndex;
}
