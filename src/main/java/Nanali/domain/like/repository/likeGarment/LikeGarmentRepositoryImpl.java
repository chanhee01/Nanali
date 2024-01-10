package Nanali.domain.like.repository.likeGarment;

import Nanali.domain.Member.model.Member;
import Nanali.global.base.Category;
import Nanali.domain.like.model.LikeGarment;
import Nanali.domain.like.model.LikeStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static Nanali.domain.Member.QMember.*;
import static Nanali.domain.cody.LikeClothes.QLikeGarment.*;
import static Nanali.domain.cody.cloth.QGarment.*;

public class LikeGarmentRepositoryImpl implements LikeGarmentRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public LikeGarmentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<LikeGarment> findAllLikeOuter(Member member) {
        return queryFactory
                .selectFrom(likeGarment)
                .leftJoin(likeGarment.garment, garment)
                .where(garment.category.eq(Category.valueOf("OUTER"))
                        .and(likeGarment.likeStatus.eq(LikeStatus.valueOf("LIKE")))
                        .and(likeGarment.member.eq(member)))
                .fetch();
    }

    @Override
    public List<LikeGarment> findAllLikeTop(Member member) {
        return queryFactory
                .selectFrom(likeGarment)
                .leftJoin(likeGarment.garment, garment)
                .where(garment.category.eq(Category.valueOf("TOP"))
                        .and(likeGarment.likeStatus.eq(LikeStatus.valueOf("LIKE")))
                        .and(likeGarment.member.eq(member)))
                .fetch();
    }

    @Override
    public List<LikeGarment> findAllLikePants(Member member) {
        return queryFactory
                .selectFrom(likeGarment)
                .leftJoin(likeGarment.garment, garment)
                .where(garment.category.eq(Category.valueOf("PANTS"))
                        .and(likeGarment.likeStatus.eq(LikeStatus.valueOf("LIKE")))
                        .and(likeGarment.member.eq(member)))
                .fetch();
    }

    @Override
    public List<LikeGarment> findAllLikeShoes(Member member) {
        return queryFactory
                .selectFrom(likeGarment)
                .leftJoin(likeGarment.garment, garment)
                .where(garment.category.eq(Category.valueOf("SHOES"))
                        .and(likeGarment.likeStatus.eq(LikeStatus.valueOf("LIKE")))
                        .and(likeGarment.member.eq(member)))
                .fetch();
    }

    @Override
    public LikeGarment findOneByMember(Long memberId, Long garmentId) {
        return queryFactory
                .selectFrom(likeGarment)
                .leftJoin(likeGarment.member, member)
                .leftJoin(likeGarment.garment, garment)
                .where(member.id.eq(memberId)
                .and(garment.id.eq(garmentId)))
                .fetchOne();
    }
}
