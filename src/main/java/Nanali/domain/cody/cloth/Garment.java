package Nanali.domain.cody.cloth;

import Nanali.domain.BaseEntity;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import Nanali.domain.cody.cloth.detail.Detail;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Garment extends BaseEntity { // Garment는 코디 안의 아이템 하나 하나를 지칭

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Double temp_from;
    private Double temp_to;
    private Double uv_from;
    private Double uv_to;
    private Double rain_from;
    private Double rain_to;

    @OneToMany(mappedBy = "garment")
    private List<LikeGarment> garmentList;

    public Garment() {

    }

    public Garment(String imgName, String imgUrl, Category category, Sex sex, Double temp_from, Double temp_to,
                   Double uv_from, Double uv_to, Double rain_from, Double rain_to) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.category = category;
        this.sex = sex;
        this.temp_from = temp_from;
        this.temp_to = temp_to;
        this.uv_from = uv_from;
        this.uv_to = uv_to;
        this.rain_from = rain_from;
        this.rain_to = rain_to;
    }

    // 연관관계 메서드
    public void addLikeGarment(LikeGarment likeGarment) {
        garmentList.add(likeGarment);
    }
}
