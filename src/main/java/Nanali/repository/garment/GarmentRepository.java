package Nanali.repository.garment;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GarmentRepository extends JpaRepository<Garment, Long> {

    List<Garment> findAllByCategoryIsOuter(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsTop(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsPants(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsShoes(Double temp, Double uv, Double rain, Sex sex);

    Optional<Garment> findById(Long id);
}
