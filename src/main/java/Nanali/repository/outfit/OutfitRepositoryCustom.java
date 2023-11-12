package Nanali.repository.outfit;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;

import java.util.List;

public interface OutfitRepositoryCustom {
    List<Outfit> findAllOutifs(Double temp, Double uv, Double rain, Style style, Sex sex);
}
