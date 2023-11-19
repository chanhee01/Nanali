package Nanali.service;
/*
import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @Transactional
    public void validationNickname() {
        Member member1 = Member.builder()
                .loginId("aaaaa").
                password("bbbbb").
                nickname("ccccc").
                email("abababab@naver.com").
                sex(true).
                age(12).
                style(Style.CASUAL).build();

        Member member2 = Member.builder()
                .loginId("aaaaa2").
                password("bbbbb2").
                nickname("ccccc2").
                email("abababab2@naver.com").
                sex(false).
                age(20).
                style(Style.CASUAL).build();

        memberService.save(member1);
        memberService.save(member2);

        memberService.changeNickname(member2, "ccccc");

        Assertions.assertThat(member2.getNickname() == "ccccc2");
        System.out.println("nickname = " + member2.getNickname());

        memberService.changeNickname(member2, "ccccc3");

        Assertions.assertThat(member2.getNickname() == "ccccc3");
        System.out.println("nickname2 = " + member2.getNickname());
    }
}
*/