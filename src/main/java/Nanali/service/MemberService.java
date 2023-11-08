package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
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

    public Member findById(Long id) {
        return memberRepository.findById(id).
            orElseThrow(() -> new IllegalArgumentException());
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
        if (validationPassword(password) == true) {
            findMember.changePassword(password);
        }
    }

    public boolean validationNickname(String nickname) {
        List<Member> findMember = memberRepository.findAllByNickname(nickname);
        if(!findMember.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validationPassword(String password) {
        List<Member> findMember = memberRepository.findAllByPassword(password);
        if(!findMember.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
