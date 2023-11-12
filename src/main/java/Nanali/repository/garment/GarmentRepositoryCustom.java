package Nanali.repository.garment;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Sex;

import java.util.List;

public interface GarmentRepositoryCustom {

    List<Garment> findAllByCategoryIsOuter(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsTop(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsPants(Double temp, Double uv, Double rain, Sex sex);

    List<Garment> findAllByCategoryIsShoes(Double temp, Double uv, Double rain, Sex sex);
}
