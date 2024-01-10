package Nanali.domain.outfit.repository;

import Nanali.domain.Member.model.Style;
import Nanali.domain.outfit.model.Outfit;
import Nanali.global.base.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {

    List<Outfit> findAllOutifs(Double temp, Double uv, Double rain, Style style, Sex sex);

    Optional<Outfit> findById(Long id);


}
