package Nanali.domain.like.repository.likeOutfit;

import Nanali.domain.like.model.LikeOutfit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeOutfitRepositoryCustom {

    LikeOutfit findOneByMember(Long memberId, Long outfitId);
}
