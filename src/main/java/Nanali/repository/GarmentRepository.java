package Nanali.repository;

import Nanali.domain.cody.cloth.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GarmentRepository extends JpaRepository<Garment, Long> {

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'outer'")
    List<Garment> findAllByCategoryIsOuter(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv, @Param(value = "rain") Long rain);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'top'")
    List<Garment> findAllByCategoryIsTop(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv, @Param(value = "rain") Long rain);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'pants'")
    List<Garment> findAllByCategoryIsPants(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv, @Param(value = "rain") Long rain);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'shoes'")
    List<Garment> findAllByCategoryIsShoes(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv, @Param(value = "rain") Long rain);

}
