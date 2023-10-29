package Nanali.domain.cody.cloth;

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

    public Outfit(String imgName, String imgUrl, String style, Long temp_from, Long temp_to,
                  Long uv_from, Long uv_to, Long rain_from, Long rain_to) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.style = style;
        this.temp_from = temp_from;
        this.temp_to = temp_to;
        this.uv_from = uv_from;
        this.uv_to = uv_to;
        this.rain_from = rain_from;
        this.rain_to = rain_to;
    }

}
