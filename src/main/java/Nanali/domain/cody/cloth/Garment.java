package Nanali.domain.cody.cloth;

import Nanali.domain.cody.LikeClothes.LikeGarment;
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

    private String category; // Style 타입으로 수정 필요

    private Long temp_from;
    private Long temp_to;
    private Long uv_from;
    private Long uv_to;
    private Long rain_from;
    private Long rain_to;

    @OneToMany(mappedBy = "garment")
    private List<LikeGarment> garmentList;

    public Garment() {

    }

    public Garment(String imgName, String imgUrl, String category, Long temp_from, Long temp_to,
                   Long uv_from, Long uv_to, Long rain_from, Long rain_to) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.category = category;
        this.temp_from = temp_from;
        this.temp_to = temp_to;
        this.uv_from = uv_from;
        this.uv_to = uv_to;
        this.rain_from = rain_from;
        this.rain_to = rain_to;
    }
}
