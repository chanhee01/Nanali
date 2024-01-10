package Nanali.domain.outfit.repository;

import Nanali.domain.Member.model.Style;
import Nanali.domain.outfit.model.Outfit;
import Nanali.global.base.Sex;

import java.util.List;

public interface OutfitRepositoryCustom {
    List<Outfit> findAllOutifs(Double temp, Double uv, Double rain, Style style, Sex sex);
}
