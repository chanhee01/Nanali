package Nanali.domain.like.model;

import Nanali.global.base.BaseEntity;
import Nanali.domain.Member.model.Member;
import Nanali.domain.outfit.model.Outfit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LikeOutfit extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "outfit_id")
    @JsonIgnore
    private Outfit outfit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @Enumerated(EnumType.STRING)
    private LikeStatus likeStatus;

    @Builder
    public LikeOutfit(Member member, Outfit outfit, LikeStatus likeStatus) {
        this.member = member;
        this.outfit = outfit;
        this.likeStatus = likeStatus;
    }

    public void changeLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}
