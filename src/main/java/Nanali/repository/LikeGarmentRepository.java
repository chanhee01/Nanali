package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeGarmentRepository extends JpaRepository<LikeGarment, Long> {

    @Query("select l from LikeGarment l join l.garment g where g.category = 'OUTER' and l.member = :member " +
            "and l.likeStatus = 'LIKE'")
    List<LikeGarment> findAllLikeOuter(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'TOP' and l.member = :member " +
            "and l.likeStatus = 'LIKE'")
    List<LikeGarment> findAllLikeTop(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'PANTS' and l.member = :member " +
            "and l.likeStatus = 'LIKE'")
    List<LikeGarment> findAllLikePants(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'SHOES' and l.member = :member " +
            "and l.likeStatus = 'LIKE'")
    List<LikeGarment> findAllLikeShoes(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.member m join l.garment g where " +
            "m.id = :memberId and g.id = :garmentId")
    LikeGarment findOneByMember(@Param(value = "memberId") Long memberId,
                                     @Param(value = "garmentId") Long garmentId);

    @Query("select l from LikeGarment l join l.member m join l.garment g where " +
            "m.id = :memberId and g.id = :garmentId")
    LikeGarment findOneByMemberAndGarment(@Param(value = "memberId") Long memberId,
                                        @Param(value = "garmentId") Long garmentId);
}
