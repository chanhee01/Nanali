package Nanali.domain.like.repository.likeOutfit;

import Nanali.domain.Member.model.Member;
import Nanali.domain.like.model.LikeOutfit;
import Nanali.domain.like.model.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeOutfitRepository extends JpaRepository<LikeOutfit, Long> {

    List<LikeOutfit> findAllByMemberAndLikeStatusIsLike(Member member, LikeStatus likeStatus);

    LikeOutfit findOneByMember(Long memberId, Long outfitId);

}
