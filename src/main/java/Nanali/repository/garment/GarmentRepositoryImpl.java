package Nanali.repository.garment;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static Nanali.domain.cody.cloth.QGarment.*;

public class GarmentRepositoryImpl implements GarmentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public GarmentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Garment> findAllByCategoryIsOuter(Double temp, Double uv, Double rain, Sex sex) {
        return queryFactory
                .selectFrom(garment)
                .where(garment.tempFrom.loe(temp).and(garment.tempTo.goe(temp))
                        .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                        .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                        .and(garment.category.eq(Category.valueOf("OUTER"))).and(garment.sex.eq(sex))
                        .or((garment.tempFrom.loe(temp)).and((garment.tempTo.goe(temp))
                                .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                                .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                                .and(garment.category.eq(Category.valueOf("OUTER")))
                                .and(garment.sex.eq(Sex.valueOf("BOTH"))))))
                .fetch();
    }

    @Override
    public List<Garment> findAllByCategoryIsTop(Double temp, Double uv, Double rain, Sex sex) {
        return queryFactory
                .selectFrom(garment)
                .where(garment.tempFrom.loe(temp).and(garment.tempTo.goe(temp))
                        .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                        .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                        .and(garment.category.eq(Category.valueOf("TOP"))).and(garment.sex.eq(sex))
                        .or((garment.tempFrom.loe(temp)).and((garment.tempTo.goe(temp))
                                .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                                .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                                .and(garment.category.eq(Category.valueOf("TOP")))
                                .and(garment.sex.eq(Sex.valueOf("BOTH"))))))
                .fetch();
    }

    @Override
    public List<Garment> findAllByCategoryIsPants(Double temp, Double uv, Double rain, Sex sex) {
        return queryFactory
                .selectFrom(garment)
                .where(garment.tempFrom.loe(temp).and(garment.tempTo.goe(temp))
                        .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                        .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                        .and(garment.category.eq(Category.valueOf("PANTS"))).and(garment.sex.eq(sex))
                        .or((garment.tempFrom.loe(temp)).and((garment.tempTo.goe(temp))
                                .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                                .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                                .and(garment.category.eq(Category.valueOf("PANTS")))
                                .and(garment.sex.eq(Sex.valueOf("BOTH"))))))
                .fetch();
    }

    @Override
    public List<Garment> findAllByCategoryIsShoes(Double temp, Double uv, Double rain, Sex sex) {
        return queryFactory
                .selectFrom(garment)
                .where(garment.tempFrom.loe(temp).and(garment.tempTo.goe(temp))
                        .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                        .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                        .and(garment.category.eq(Category.valueOf("SHOES"))).and(garment.sex.eq(sex))
                        .or((garment.tempFrom.loe(temp)).and((garment.tempTo.goe(temp))
                                .and(garment.uvFrom.loe(uv)).and(garment.uvFrom.goe(uv))
                                .and(garment.rainFrom.loe(rain)).and(garment.rainTo.goe(rain))
                                .and(garment.category.eq(Category.valueOf("SHOES")))
                                .and(garment.sex.eq(Sex.valueOf("BOTH"))))))
                .fetch();
    }
}
