package Nanali.domain.Member.model;

import Nanali.domain.like.model.LikeOutfit;
import Nanali.global.base.BaseEntity;
import Nanali.domain.like.model.LikeGarment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id  @GeneratedValue
    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private String email;

    private boolean sex;

    private int age;

    @Enumerated(EnumType.STRING)
    private Style style; // Style 타입으로 수정 필요

    @OneToMany(mappedBy = "member")
    private List<LikeGarment> garmentList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<LikeOutfit> outfitList = new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private MemberImg memberImg;

    @Builder
    public Member(String loginId, String password, String nickname, String email, boolean sex, int age, Style style) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.style = style;
    }

    // 연관관계 메서드
    public void addLikeGarment(LikeGarment likeGarment) {
        garmentList.add(likeGarment);
    }

    public void addLikeOutfit(LikeOutfit likeOutfit) {
        outfitList.add(likeOutfit);
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeStyle(Style style) {
        this.style = style;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
