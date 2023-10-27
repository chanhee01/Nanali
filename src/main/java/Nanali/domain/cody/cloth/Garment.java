package Nanali.domain.cody.cloth;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import Nanali.service.GarmentService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Garment { // Garment는 코디 안의 아이템 하나 하나를 지칭

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    private String style; // Style 타입으로 수정 필요

    @OneToMany(mappedBy = "garment")
    private List<LikeGarment> garmentList;

    public Garment() {

    }

    public Garment(String imgName, String imgUrl, String style) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.style = style;
    }
}
