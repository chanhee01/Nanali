package Nanali.domain.Member;

import Nanali.domain.outfit.LikeGarment;
import Nanali.domain.outfit.LikeOutfit;
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

    private String style;

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
