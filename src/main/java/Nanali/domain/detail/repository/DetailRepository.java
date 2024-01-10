package Nanali.domain.detail.repository;

import Nanali.global.base.Category;
import Nanali.domain.detail.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail findByOutfitIdAndCategory(Long id, Category category);

}
