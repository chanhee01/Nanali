package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeOutfitRepository extends JpaRepository<LikeOutfit, Long> {

    List<LikeOutfit> findAllByMemberAndLikeStatusIsLike(Member member, LikeStatus likeStatus);

    @Query("select l from LikeOutfit l join l.member m join l.outfit o where " +
            "m.id = :memberId and o.id = :outfitId")
    List<LikeOutfit> findOneByMember(@Param(value = "memberId") Long memberId,
                           @Param(value = "outfitId") Long outfitId);

    @Query("select l from LikeOutfit l join l.member m join l.outfit o where " +
            "m.id = :memberId and o.id = :outfitId")
    LikeOutfit findOneByMemberAndOutfit(@Param(value = "memberId") Long memberId,
                                     @Param(value = "outfitId") Long outfitId);

}
