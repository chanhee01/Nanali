package Nanali.repository;

import Nanali.domain.cody.cloth.Garment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarmentRepository extends JpaRepository<Garment, Long> {
}
