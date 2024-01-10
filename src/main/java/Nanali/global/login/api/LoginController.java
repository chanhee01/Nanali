package Nanali.global.login.api;

import Nanali.domain.Member.model.Member;
import Nanali.global.login.dto.LoginRequest;
import Nanali.global.login.dto.MemberSaveDto;
import Nanali.global.login.dto.validationIdRequest;
import Nanali.global.login.dto.validationNicknameRequest;
import Nanali.domain.Member.service.MemberService;
import Nanali.global.login.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private final MemberService memberService;
    public Hashtable sessionList = new Hashtable();

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody MemberSaveDto request, BindingResult bindingResult) {

        // loginId 중복 체크
        if(memberService.checkLoginIdDuplicate(request.getLoginId())) {
            bindingResult.addError(new FieldError("joinRequest", "loginId", "로그인 아이디가 중복됩니다."));
            System.out.println("aaaa");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        // 닉네임 중복 체크
        if(memberService.checkNicknameDuplicate(request.getNickname())) {
            bindingResult.addError(new FieldError("joinRequest", "nickname", "닉네임이 중복됩니다."));
            System.out.println("bbbb");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        // password와 passwordCheck가 같은지 체크
        if(!request.getPassword().equals(request.getPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "passwordCheck", "바밀번호가 일치하지 않습니다."));
            System.out.println("cccc");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Member member = Member.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .sex(request.getSex())
                .age(request.getAge())
                .style(request.getStyle()).build();

        memberService.save(member);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult,
                                HttpServletRequest httpServletRequest) {

        Member member = memberService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(member == null) {
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        if(bindingResult.hasErrors()) {
            bindingResult.reject("login has error", null);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        sessionList.put(session.getId(), session);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            sessionList.remove(session.getId());
            session.invalidate();
        }
    }

    @PostMapping("/validation/id")
    public boolean validationId(@RequestBody validationIdRequest request) {
        return !memberService.checkLoginIdDuplicate(request.getLoginId());
    } // false면 이미 있는거고 true면 없는 것 (true면 회원가입 가능)

    @PostMapping("/validation/nickname")
    public boolean validationNickname(@RequestBody validationNicknameRequest request) {
        return !memberService.checkNicknameDuplicate(request.getNickname());
    } // false면 이미 있는거고 true면 없는 것 (true면 회원가입 가능)
}
