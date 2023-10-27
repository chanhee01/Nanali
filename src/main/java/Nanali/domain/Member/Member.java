package Nanali.domain.Member;

import Nanali.domain.cody.LikeClothes.LikeGarment;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private String email;

    private boolean sex;

    private int age;

    private String style; // Style 타입으로 수정 필요

    @OneToMany(mappedBy = "member")
    private List<LikeGarment> garmentList;

    @OneToMany(mappedBy = "member")
    private List<LikeOutfit> outfitList;

    @OneToOne(mappedBy = "member")
    private MemberImg memberImg;

    public Member() {
    }

    public Member(String loginId, String password, String nickname, String email, boolean sex, int age, String style) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.style = style;
    }
}
