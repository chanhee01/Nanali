package Nanali.repository;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GarmentRepository extends JpaRepository<Garment, Long> {

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'OUTER' " +
            "and g.sex = :sex or g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'OUTER' " +
            "and g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsOuter(@Param(value = "temp") Double temp, @Param(value = "uv") Double uv,
                                           @Param(value = "rain") Double rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'TOP' " +
            "and g.sex = :sex or g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'TOP' " +
            "and g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsTop(@Param(value = "temp") Double temp, @Param(value = "uv") Double uv,
                                         @Param(value = "rain") Double rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'PANTS' " +
            "and g.sex = :sex or g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'PANTS' " +
            "and g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsPants(@Param(value = "temp") Double temp, @Param(value = "uv") Double uv,
                                           @Param(value = "rain") Double rain, @Param(value = "sex") Sex sex);

    @Query("select g from Garment g where g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'SHOES' " +
            "and g.sex = :sex or g.temp_from <= :temp and g.temp_to >= :temp and g.uv_from <= :uv " +
            "and g.uv_to >= :uv and g.rain_from <= :rain and g.rain_to >= : rain and g.category = 'SHOES' " +
            "and g.sex = 'BOTH'")
    List<Garment> findAllByCategoryIsShoes(@Param(value = "temp") Double temp, @Param(value = "uv") Double uv,
                                           @Param(value = "rain") Double rain, @Param(value = "sex") Sex sex);

    Optional<Garment> findById(Long id);
}
