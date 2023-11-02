package Nanali.repository;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {

    @Query("select o from Outfit o where o.temp_from <= :temp and o.temp_to >= :temp and o.uv_from <= :uv " +
            "and o.uv_to >= :uv and o.rain_from <= :rain and o.rain_to >= : rain and o.style = :style " +
            "and o.sex = :sex or o.temp_from <= :temp and o.temp_to >= :temp and o.uv_from <= :uv " +
            "and o.uv_to >= :uv and o.rain_from <= :rain and o.rain_to >= : rain and o.style = :style " +
            "and o.sex = 'BOTH'")
    List<Outfit> findAllOutifs(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                               @Param(value = "rain") Long rain, @Param(value = "style") Style style, @Param(value = "sex") Sex sex);
    // Style 타입으로 수정 필요

    Optional<Outfit> findById(Long id);
}
