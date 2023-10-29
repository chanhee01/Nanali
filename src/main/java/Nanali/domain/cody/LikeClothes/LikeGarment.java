package Nanali.domain.cody.LikeClothes;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.cloth.Garment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class LikeGarment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garment_id")
    @JsonIgnore
    private Garment garment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @Enumerated(EnumType.STRING)
    private LikeStatus likeStatus;

    public LikeGarment() {

    }

    public LikeGarment(Member member, Garment garment, LikeStatus likeStatus) {
        this.member = member;
        this.garment = garment;
        this.likeStatus = likeStatus;
    }

    public void changeLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}
