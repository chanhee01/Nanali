package Nanali.repository.likeGarment;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeGarmentRepository extends JpaRepository<LikeGarment, Long> {

    List<LikeGarment> findAllLikeOuter(Member member);

    List<LikeGarment> findAllLikeTop(Member member);

    List<LikeGarment> findAllLikePants(Member member);

    List<LikeGarment> findAllLikeShoes(Member member);

    LikeGarment findOneByMember(Long memberId, Long garmentId);
}
