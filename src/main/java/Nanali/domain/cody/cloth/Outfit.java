package Nanali.domain.cody.cloth;

import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.BaseEntity;
import Nanali.domain.Member.Style;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Outfit extends BaseEntity { // Outfit은 코디 사진

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    private Style style; // Category 타입으로 수정 필요

    @Enumerated(EnumType.STRING)
    private Sex sex;

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

    public Outfit(String imgName, String imgUrl, Style style, Sex sex, Long temp_from, Long temp_to,
                  Long uv_from, Long uv_to, Long rain_from, Long rain_to) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.style = style;
        this.sex = sex;
        this.temp_from = temp_from;
        this.temp_to = temp_to;
        this.uv_from = uv_from;
        this.uv_to = uv_to;
        this.rain_from = rain_from;
        this.rain_to = rain_to;
    }

    // 연관관계 메서드
    public void addLikeOutfit(LikeOutfit likeOutfit) {
        outfitList.add(likeOutfit);
    }
}
