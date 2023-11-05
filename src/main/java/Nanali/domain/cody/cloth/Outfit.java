package Nanali.domain.cody.cloth;

import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.BaseEntity;
import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.detail.Detail;
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

    @Enumerated(EnumType.STRING)
    private Style style;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Double temp_from;
    private Double temp_to;
    private Double uv_from;
    private Double uv_to;
    private Double rain_from;
    private Double rain_to;

    @OneToMany(mappedBy = "outfit")
    private List<LikeOutfit> outfitList;

    @OneToMany(mappedBy = "outfit")
    private List<Detail> details;

    public Outfit() {

    }

    public Outfit(String imgName, String imgUrl, Style style, Sex sex, Double temp_from, Double temp_to,
                  Double uv_from, Double uv_to, Double rain_from, Double rain_to) {
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

    public void addDetail(Detail detail) {
        details.add(detail);
    }
}
