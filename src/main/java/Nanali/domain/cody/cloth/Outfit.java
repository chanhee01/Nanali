package Nanali.domain.cody.cloth;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Outfit { // Outfit은 코디 사진

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    private String style; // Category 타입으로 수정 필요

    private Long temp_from;
    private Long temp_to;
    private Long uv_from;
    private Long uv_to;
    private Long rain_from;
    private Long rain_to;

    @OneToMany(mappedBy = "outfit")
    private List<LikeOutfit> outfitList;

    public Outfit() {

    }

    public Outfit(String imgName, String imgUrl, String style) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.style = style;
    }
}
