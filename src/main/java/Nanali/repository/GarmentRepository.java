package Nanali.repository;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GarmentRepository extends JpaRepository<Garment, Long> {

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'outer' " +
            "and g.sex = :sex or g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsOuter(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                                           @Param(value = "rain") Long rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'top' " +
            "and g.sex = :sex or g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsTop(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                                         @Param(value = "rain") Long rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'pants' " +
            "and g.sex = :sex or g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsPants(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                                           @Param(value = "rain") Long rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'shoes' " +
            "and g.sex = :sex or g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsShoes(@Param(value = "temp") Long temp, @Param(value = "uv") Long uv,
                                           @Param(value = "rain") Long rain, @Param(value = "sex") Sex sex);

}
