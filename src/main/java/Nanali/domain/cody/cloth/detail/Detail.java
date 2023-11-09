package Nanali.domain.cody.cloth.detail;

import Nanali.domain.BaseEntity;
import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.Outfit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Detail extends BaseEntity { // Outfit으로 추천된 사진의 각각 개별 item
    // Detail과 분류한 이유는 무신사에서 크롤링할 때, 코디랑 개별 상품을 아예 다른 페이지에서 크롤링하기 때문에 분류함
    // Outfit과 연관관계를 맺는다고 가정을 한다면 FK에 null 값이 너무 많이 들어갈 것이라 생각되고
    // 코디 페이지에서 크롤링된 상품이랑 개별 상품 페이지에서 크롤링된 상품의 차이점도 있을 것이라 예상되어서 Detail 엔티티를 만듦

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garment_id")
    @JsonIgnore
    private Outfit outfit;

    public Detail(String imgName, String imgUrl, Category category, Outfit outfit) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.category = category;
        this.outfit = outfit;
    }
}
