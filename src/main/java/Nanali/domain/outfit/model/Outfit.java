package Nanali.domain.outfit.model;

import Nanali.global.base.Sex;
import Nanali.domain.like.model.LikeOutfit;
import Nanali.global.base.BaseEntity;
import Nanali.domain.Member.model.Style;
import Nanali.domain.detail.model.Detail;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "outfit_index", columnList = "tempFrom, tempTo, uvFrom, uvTo, rainFrom, rainTo, style, sex,")
})
public class Outfit extends BaseEntity { // Outfit은 코디 사진

    @Id @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Style style;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Double tempFrom;
    private Double tempTo;
    private Double uvFrom;
    private Double uvTo;
    private Double rainFrom;
    private Double rainTo;

    @OneToMany(mappedBy = "outfit")
    private List<LikeOutfit> outfitList = new ArrayList<>();

    @OneToMany(mappedBy = "outfit")
    private List<Detail> details = new ArrayList<>();

    @Builder
    public Outfit(String imgName, String imgUrl, Style style, Sex sex, Double tempFrom, Double tempTo,
                  Double uvFrom, Double uvTo, Double rainFrom, Double rainTo) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.style = style;
        this.sex = sex;
        this.tempFrom = tempFrom;
        this.tempTo = tempTo;
        this.uvFrom = uvFrom;
        this.uvTo = uvTo;
        this.rainFrom = rainFrom;
        this.rainTo = rainTo;
    }

    // 연관관계 메서드
    public void addLikeOutfit(LikeOutfit likeOutfit) {
        outfitList.add(likeOutfit);
    }

    public void addDetail(Detail detail) {
        details.add(detail);
    }
}
