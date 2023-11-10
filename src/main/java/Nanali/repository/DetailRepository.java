package Nanali.repository;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.detail.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail findByOutfitIdAndCategory(Long id, Category category);

}
