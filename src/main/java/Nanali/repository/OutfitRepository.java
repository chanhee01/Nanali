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

    @Query("select o from Outfit o where o.tempFrom <= :temp and o.tempTo >= :temp and o.uvFrom <= :uv " +
            "and o.uvTo >= :uv and o.rainFrom <= :rain and o.rainTo >= : rain and o.style = :style " +
            "and o.sex = :sex or o.tempFrom <= :temp and o.tempTo >= :temp and o.uvFrom <= :uv " +
            "and o.uvTo >= :uv and o.rainFrom <= :rain and o.rainTo >= : rain and o.style = :style " +
            "and o.sex = 'BOTH'")
    List<Outfit> findAllOutifs(@Param(value = "temp") Double temp, @Param(value = "uv") Double uv,
                               @Param(value = "rain") Double rain, @Param(value = "style") Style style, @Param(value = "sex") Sex sex);

    Optional<Outfit> findById(Long id);
}
