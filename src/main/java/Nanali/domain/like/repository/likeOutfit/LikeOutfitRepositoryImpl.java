package Nanali.domain.like.repository.likeOutfit;

import Nanali.domain.like.model.LikeOutfit;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import static Nanali.domain.Member.QMember.*;
import static Nanali.domain.cody.LikeClothes.QLikeOutfit.*;

public class LikeOutfitRepositoryImpl implements LikeOutfitRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public LikeOutfitRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public LikeOutfit findOneByMember(Long memberId, Long outfitId) {
        return queryFactory
                .selectFrom(likeOutfit)
                .leftJoin(likeOutfit.member, member)
                .where(member.id.eq(memberId)
                       .and(likeOutfit.id.eq(outfitId)))
                .fetchOne();
    }
}
