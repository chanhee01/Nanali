package Nanali.domain.cody.cloth;

import Nanali.domain.BaseEntity;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Garment extends BaseEntity { // Garment는 코디 안의 아이템 하나 하나를 지칭

    @Id @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Double tempFrom;
    private Double tempTo;
    private Double uvFrom;
    private Double uvTo;
    private Double rainFrom;
    private Double rainTo;

    @OneToMany(mappedBy = "garment")
    private List<LikeGarment> garmentList = new ArrayList<>();

    @Builder
    public Garment(String imgName, String imgUrl, Category category, Sex sex, Double tempFrom, Double tempTo,
                   Double uvFrom, Double uvTo, Double rainFrom, Double rainTo) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.category = category;
        this.sex = sex;
        this.tempFrom = tempFrom;
        this.tempTo = tempTo;
        this.uvFrom = uvFrom;
        this.uvTo = uvTo;
        this.rainFrom = rainFrom;
        this.rainTo = rainTo;
    }

    // 연관관계 메서드
    public void addLikeGarment(LikeGarment likeGarment) {
        garmentList.add(likeGarment);
    }
}
