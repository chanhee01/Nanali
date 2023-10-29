package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeGarmentRepository extends JpaRepository<LikeGarment, Long> {

    List<LikeGarment> findAllByMember(Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'outer' and l.member = :member " +
            "and l.likeStatus = 'Like'")
    List<LikeGarment> findAllLikeOuter(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'top' and l.member = :member " +
            "and l.likeStatus = 'Like'")
    List<LikeGarment> findAllLikeTop(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'pants' and l.member = :member " +
            "and l.likeStatus = 'Like'")
    List<LikeGarment> findAllLikePants(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'shoes' and l.member = :member " +
            "and l.likeStatus = 'Like'")
    List<LikeGarment> findAllLikeShoes(@Param(value = "member") Member member);
}
