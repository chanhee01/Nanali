package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Member findMember(Long id) {
        return memberRepository.findById(id).
            orElseThrow(() -> new IllegalArgumentException());
    }
}