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

    private Long temp_from;
    private Long temp_to;
    private Long uv_from;
    private Long uv_to;
    private Long rain_from;
    private Long rain_to;

    @OneToMany(mappedBy = "garment")
    private List<LikeGarment> garmentList;

    @OneToMany(mappedBy = "garment")
    private List<Detail> details;

    public Garment() {

    }

    public Garment(String imgName, String imgUrl, Category category, Sex sex, Long temp_from, Long temp_to,
                   Long uv_from, Long uv_to, Long rain_from, Long rain_to) {
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
