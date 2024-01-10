package Nanali.global.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String loginId;
    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
}
