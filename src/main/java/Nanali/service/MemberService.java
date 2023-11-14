package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.dtos.login.LoginRequest;
import Nanali.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Member member) {
        Member savedId = memberRepository.save(member);
        return savedId.getId();
    }

    public boolean checkLoginIdDuplicate(String loginId) {
        return memberRepository.existsByLoginId(loginId);
    }

    public boolean checkNicknameDuplicate(String nickname) {
        return memberRepository.existsByNickname(nickname);
    }

    @Transactional
    public Member login(LoginRequest req) {
        Optional<Member> optionalMember = memberRepository.findByLoginId(req.getLoginId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!member.getPassword().equals(req.getPassword())) {
            return null;
        }

        return member;
    }

    public Member getLoginUserById(Long memberId) {
        if(memberId == null) return null;

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(optionalMember.isEmpty()) return null;

        return optionalMember.get();
    }


    public Member findById(Long id) {
        return memberRepository.findById(id).
            orElseThrow(() -> new IllegalArgumentException(String.format("failed to find member. id: %s", id)));
    }

    @Transactional
    public void changeNickname(Member member, String nickname) {
        Member findMember = findById(member.getId());
        if (validationNickname(nickname) == true) {
            findMember.changeNickname(nickname);
        }
    }

    @Transactional
    public void changeStyle(Member member, Style style) {
        Member findMember = findById(member.getId());
        findMember.changeStyle(style);
    }

    @Transactional
    public void changePassword(Member member, String password) {
        Member findMember = findById(member.getId());
        findMember.changePassword(password);
    }

    public boolean validationNickname(String nickname) {
        return memberRepository.findByNickname(nickname) != null;
    }

}
