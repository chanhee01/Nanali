package Nanali.repository.likeOutfit;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeOutfitRepository extends JpaRepository<LikeOutfit, Long> {

    List<LikeOutfit> findAllByMemberAndLikeStatusIsLike(Member member, LikeStatus likeStatus);

    LikeOutfit findOneByMember(Long memberId, Long outfitId);

}
