package Nanali.repository;

import Nanali.domain.cody.LikeClothes.LikeOutfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeOutfitRepository extends JpaRepository<LikeOutfit, Long> {

    @Query("select l from LikeOutfit l where l.member.id = :id and l.likeStatus = 'LIKE'")
    List<LikeOutfit> findAllByMember(@Param(value = "id") Long id);

    void deleteById(Long id);
}
