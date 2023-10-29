package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.cloth.Garment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GarmentServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    GarmentService garmentService;

    @DisplayName("카테고리별 날씨에 맞는 아이템 추출")
    @Test
    public void findGarment() {
        Member member = new Member("loginId", "password", "nickname", "email", true, 20, "style");
        memberService.save(member);

        Garment top1 = new Garment("top1", "url1", "top", 10L, 20L, 0L, 1L, 0L, 40L);
        Garment top2 = new Garment("top2", "url2", "top", 0L, 15L, 0L, 2L, 0L, 40L);
        Garment top3 = new Garment("top3", "url3", "top", 10L, 20L, 2L, 2L, 20L, 40L);
        Garment top4 = new Garment("top4", "url4", "top", 20L, 30L, 1L, 2L, 50L, 100L);
        Garment top5 = new Garment("top5", "url5", "top", 20L, 25L, 1L, 3L, 0L, 40L);
        Garment top6 = new Garment("top6", "url6", "top", 0L, 10L, 0L, 1L, 70L, 100L);

        garmentService.save(top1);
        garmentService.save(top2);
        garmentService.save(top3);
        garmentService.save(top4);
        garmentService.save(top5);
        garmentService.save(top6);

        Garment pants1 = new Garment("pants1", "url1", "pants", 10L, 20L, 0L, 1L, 0L, 40L);
        Garment pants2 = new Garment("pants2", "url2", "pants", 0L, 15L, 0L, 2L, 0L, 40L);
        Garment pants3 = new Garment("pants3", "url3", "pants", 10L, 20L, 2L, 2L, 20L, 40L);
        Garment pants4 = new Garment("pants4", "url4", "pants", 20L, 30L, 1L, 2L, 50L, 100L);
        Garment pants5 = new Garment("pants5", "url5", "pants", 20L, 25L, 1L, 3L, 0L, 40L);
        Garment pants6 = new Garment("pants6", "url6", "pants", 0L, 10L, 0L, 1L, 70L, 100L);

        garmentService.save(pants1);
        garmentService.save(pants2);
        garmentService.save(pants3);
        garmentService.save(pants4);
        garmentService.save(pants5);
        garmentService.save(pants6);

        Garment outer1 = new Garment("outer1", "url1", "outer", 10L, 20L, 0L, 1L, 0L, 40L);
        Garment outer2 = new Garment("outer2", "url2", "outer", 0L, 15L, 0L, 2L, 0L, 40L);
        Garment outer3 = new Garment("outer3", "url3", "outer", 10L, 20L, 2L, 2L, 20L, 40L);
        Garment outer4 = new Garment("outer4", "url4", "outer", 20L, 30L, 1L, 2L, 50L, 100L);
        Garment outer5 = new Garment("outer5", "url5", "outer", 20L, 25L, 1L, 3L, 0L, 40L);
        Garment outer6 = new Garment("outer6", "url6", "outer", 0L, 10L, 0L, 1L, 70L, 100L);

        garmentService.save(outer1);
        garmentService.save(outer2);
        garmentService.save(outer3);
        garmentService.save(outer4);
        garmentService.save(outer5);
        garmentService.save(outer6);

        Garment shoes1 = new Garment("shoes1", "url1", "shoes", 10L, 20L, 0L, 1L, 0L, 40L);
        Garment shoes2 = new Garment("shoes2", "url2", "shoes", 0L, 15L, 0L, 2L, 0L, 40L);
        Garment shoes3 = new Garment("shoes3", "url3", "shoes", 10L, 20L, 2L, 2L, 20L, 40L);
        Garment shoes4 = new Garment("shoes4", "url4", "shoes", 20L, 30L, 1L, 2L, 50L, 100L);
        Garment shoes5 = new Garment("shoes5", "url5", "shoes", 20L, 25L, 1L, 3L, 0L, 40L);
        Garment shoes6 = new Garment("shoes6", "url6", "shoes", 0L, 10L, 0L, 1L, 70L, 100L);

        garmentService.save(shoes1);
        garmentService.save(shoes2);
        garmentService.save(shoes3);
        garmentService.save(shoes4);
        garmentService.save(shoes5);
        garmentService.save(shoes6);

        List<Garment> outers = garmentService.findOuters(10L, 1L, 20L);
        List<Garment> tops = garmentService.findTops(10L, 1L, 20L);
        List<Garment> pants = garmentService.findPants(10L, 1L, 20L);
        List<Garment> shoes = garmentService.findShoes(10L, 1L, 20L);

        // 1, 2번이 출력되어야 함

        for (Garment o : outers) {
            System.out.println("outer = " + o.getImgName());
        }

        for (Garment o : tops) {
            System.out.println("top = " + o.getImgName());
        }

        for (Garment o : pants) {
            System.out.println("pants = " + o.getImgName());
        }

        for (Garment o : shoes) {
            System.out.println("shoes = " + o.getImgName());
        }

        System.out.println("==========================");

        List<Garment> outerList = garmentService.findOuters(20L, 1L, 20L);
        List<Garment> topsList = garmentService.findTops(20L, 1L, 20L);
        List<Garment> pantsList = garmentService.findPants(20L, 1L, 20L);
        List<Garment> shoesList = garmentService.findShoes(20L, 1L, 20L);

        // 1, 5번이 출력되어야 함

        for (Garment o : outerList) {
            System.out.println("outer = " + o.getImgName());
        }

        for (Garment o : topsList) {
            System.out.println("top = " + o.getImgName());
        }

        for (Garment o : pantsList) {
            System.out.println("pants = " + o.getImgName());
        }

        for (Garment o : shoesList) {
            System.out.println("shoes = " + o.getImgName());
        }
    }
}
