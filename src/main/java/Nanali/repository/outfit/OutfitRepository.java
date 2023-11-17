package Nanali.repository.outfit;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {

    List<Outfit> findAllOutifs(Double temp, Double uv, Double rain, Style style, Sex sex);

    Optional<Outfit> findById(Long id);


}
