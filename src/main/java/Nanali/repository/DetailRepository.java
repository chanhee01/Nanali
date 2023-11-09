package Nanali.repository;

import Nanali.domain.cody.cloth.detail.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query("select d from Detail d join d.outfit o where o.id = :id and d.category = 'OUTER'")
    Detail findOuter(@Param(value = "id") Long id);

    @Query("select d from Detail d join d.outfit o where o.id = :id and d.category = 'TOP'")
    Detail findTop(@Param(value = "id") Long id);

    @Query("select d from Detail d join d.outfit o where o.id = :id and d.category = 'PANTS'")
    Detail findPants(@Param(value = "id") Long id);

    @Query("select d from Detail d join d.outfit o where o.id = :id and d.category = 'SHOES'")
    Detail findShoes(@Param(value = "id") Long id);
}
