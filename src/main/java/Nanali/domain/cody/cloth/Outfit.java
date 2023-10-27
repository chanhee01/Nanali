package Nanali.domain.cody.cloth;

import Nanali.domain.cody.Category;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private String category; // Category 타입으로 수정 필요

    @OneToMany(mappedBy = "outfit")
    private List<LikeOutfit> outfitList;

    public Outfit() {

    }

    public Outfit(String imgName, String imgUrl, String category) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.category = category;
    }
}
