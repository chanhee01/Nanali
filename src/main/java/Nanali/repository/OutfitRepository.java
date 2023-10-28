package Nanali.repository;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {

    @Query("select o from Outfit o where o.temp_from < :temp and o.temp_to > :temp and o.uv_from < :uv " +
            "and o.uv_to > :uv and o.rain_from < :rain and o.rain_to > : rain and o.style = :style")
    List<Outfit> findAllOutifs(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                               @Param(value = "rain") Long rain, @Param(value = "style")Style style);
}
