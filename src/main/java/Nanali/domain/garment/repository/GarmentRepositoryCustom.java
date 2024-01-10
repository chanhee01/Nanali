package Nanali.domain.garment.repository;

import Nanali.domain.garment.model.Garment;
import Nanali.global.base.Sex;

import java.util.List;

public interface GarmentRepositoryCustom {

    List<Garment> findAllByCategoryIsOuter(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsTop(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsPants(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsShoes(Double temp, Double uv, Double rain, Sex sex);
}
