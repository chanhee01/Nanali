package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.dtos.login.LoginRequest;
import Nanali.dtos.login.MemberSaveDto;
import Nanali.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private MemberService memberService;
    public Hashtable sessionList = new Hashtable();

    @PostMapping("/save")
    public void save(@Valid @RequestBody MemberSaveDto request, BindingResult bindingResult) {

        // loginId 중복 체크
        if(memberService.checkLoginIdDuplicate(request.getLoginId())) {
            bindingResult.addError(new FieldError("joinRequest", "loginId", "로그인 아이디가 중복됩니다."));
        }
        // 닉네임 중복 체크
        if(memberService.checkNicknameDuplicate(request.getNickname())) {
            bindingResult.addError(new FieldError("joinRequest", "nickname", "닉네임이 중복됩니다."));
        }
        // password와 passwordCheck가 같은지 체크
        if(!request.getPassword().equals(request.getPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "passwordCheck", "바밀번호가 일치하지 않습니다."));
        }

        if(bindingResult.hasErrors()) {
            bindingResult.reject("save has error", null);
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
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult,
                        HttpServletRequest httpServletRequest) {

        Member member = memberService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(member == null) {
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        if(bindingResult.hasErrors()) {
            bindingResult.reject("login has error", null);
        }
        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", member.getId());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        sessionList.put(session.getId(), session);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            sessionList.remove(session.getId());
            session.invalidate();
        }
    }
}
