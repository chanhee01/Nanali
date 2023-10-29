package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.cloth.Outfit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class OutfitServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    OutfitService outfitService;

    @DisplayName("아직 랜덤으로 하나 추출하는건 구현 X, 해당되는 garment들의 리스트만 추출")
    @Test
    public void findOutfit() {
        Member member = new Member("loginId", "password", "nickname", "email", true, 20, "style");
        memberService.save(member);

        Outfit outfit1 = new Outfit("test1", "testUrl1", "style1", 0L, 10L, 0L, 1L, 0L, 30L);
        Outfit outfit2 = new Outfit("test2", "testUrl2", "style1", 10L, 20L, 0L, 1L, 0L, 50L);
        Outfit outfit3 = new Outfit("test3", "testUrl3", "style2", 20L, 25L, 0L, 2L, 20L, 100L);
        Outfit outfit4 = new Outfit("test4", "testUrl4", "style2", 15L, 20L, 0L, 3L, 70L, 100L);
        Outfit outfit5 = new Outfit("test5", "testUrl5", "style2", 10L, 14L, 0L, 3L, 80L, 100L);
        Outfit outfit6 = new Outfit("test6", "testUrl6", "style2", 15L, 20L, 0L, 2L, 0L, 50L);
        Outfit outfit7 = new Outfit("test7", "testUrl7", "style2", 15L, 20L, 0L, 2L, 0L, 30L);

        outfitService.save(outfit1);
        outfitService.save(outfit2);
        outfitService.save(outfit3);
        outfitService.save(outfit4);
        outfitService.save(outfit5);
        outfitService.save(outfit6);
        outfitService.save(outfit7);

        Outfit one = outfitService.findOne(outfit1.getId());

        System.out.println("one" + one.getImgName());

        List<Outfit> style1 = outfitService.findOutfit(10L, 1L, 20L, "style1");

        for (Outfit outfit : style1) {
            System.out.println(outfit);
        }
    }
}