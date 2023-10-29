package Nanali.domain.cody.LikeClothes;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.cloth.Outfit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class LikeOutfit {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outfit_id")
    @JsonIgnore
    private Outfit outfit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @Enumerated(EnumType.STRING)
    private LikeStatus likeStatus;

    public LikeOutfit() {

    }

    public LikeOutfit(Member member, Outfit outfit, LikeStatus likeStatus) {
        this.member = member;
        this.outfit = outfit;
        this.likeStatus = likeStatus;
    }

    public void changeLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}
