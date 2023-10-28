package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeGarmentRepository extends JpaRepository<LikeGarment, Long> {

    List<LikeGarment> findAllByMember(Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'outer' and l.member = :member")
    List<LikeGarment> findAllOuter(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'top' and l.member = :member")
    List<LikeGarment> findAllTop(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'pants' and l.member = :member")
    List<LikeGarment> findAllPants(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l join l.garment g where g.category = 'shoes' and l.member = :member")
    List<LikeGarment> findAllShoes(@Param(value = "member") Member member);
}
