package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.outfit.LikeGarment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeGarmentRepository extends JpaRepository<LikeGarment, Long> {

    List<LikeGarment> findAllByMember(Member member);

    @Query("select l from LikeGarment l where l.category = 'outer' and l.member = :member")
    List<LikeGarment> findAllOuter(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l where l.category = 'top' and l.member = :member")
    List<LikeGarment> findAllTop(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l where l.category = 'pants' and l.member = :member")
    List<LikeGarment> findAllPants(@Param(value = "member") Member member);

    @Query("select l from LikeGarment l where l.category = 'shoes' and l.member = :member")
    List<LikeGarment> findAllShoes(@Param(value = "member") Member member);
}
