package Nanali.dtos.login;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemberSaveDto {
    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String loginId;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickname;

    @NotBlank(message = "email이 비어있습니다.")
    private String email;

    private Boolean sex;
    private Integer age;
    private Style style;

    public Member toEntity() {
        return Member.builder()
                .loginId(this.loginId)
                .password(this.password)
                .nickname(this.nickname)
                .email(this.email)
                .sex(this.sex)
                .age(this.age)
                .style(this.style)
                .build();
    }
}
