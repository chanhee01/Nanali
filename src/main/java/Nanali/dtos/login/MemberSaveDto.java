package Nanali.dtos.login;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;


@Getter
@Setter
@NoArgsConstructor
public class MemberSaveDto {
    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    @Range(min = 6, max = 10)
    private String loginId;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    @Range(min = 6, max = 12)
    private String password;

    @NotBlank(message = "비밀번호 재확인이 비어있습니다.")
    @Range(min = 6, max = 12)
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비어있습니다.")
    @Range(min = 4, max = 8)
    private String nickname;

    @NotBlank(message = "email이 비어있습니다.")
    private String email;

    @NotNull
    private Boolean sex;
    @NotNull
    private Integer age;
    @NotNull
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
