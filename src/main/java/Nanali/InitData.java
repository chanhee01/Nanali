package Nanali;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    static class InitService {

        @PersistenceContext
        EntityManager em;

        @Transactional
        public void init() {
            Member member = Member.builder()
                    .loginId("aaa").
                    password("bbb").
                    nickname("ccc").
                    email("ababab@naver.com").
                    sex(true).
                    age(12).
                    style(Style.CASUAL).build();
            em.persist(member);
        }
    }
}
