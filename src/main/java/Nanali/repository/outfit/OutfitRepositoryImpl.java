package Nanali.repository.outfit;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static Nanali.domain.cody.cloth.QOutfit.*;

public class OutfitRepositoryImpl implements OutfitRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public OutfitRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Outfit> findAllOutifs(Double temp, Double uv, Double rain, Style style, Sex sex) {

        return queryFactory
                .selectFrom(outfit)
                .where(outfit.tempFrom.loe(temp).and(outfit.tempTo.goe(temp))
                        .and(outfit.uvFrom.loe(uv)).and(outfit.uvTo.goe(uv))
                        .and(outfit.rainFrom.loe(rain)).and(outfit.rainTo.goe(rain))
                        .and(outfit.style.eq(style)).and(outfit.sex.eq(sex))
                            .or(outfit.tempFrom.loe(temp).and(outfit.tempTo.goe(temp))
                            .and(outfit.uvFrom.loe(uv)).and(outfit.uvTo.goe(uv))
                            .and(outfit.rainFrom.loe(rain)).and(outfit.rainTo.goe(rain))
                            .and(outfit.style.eq(style)).and(outfit.sex.eq(Sex.valueOf("BOTH")))))
                .fetch();
    }
}
