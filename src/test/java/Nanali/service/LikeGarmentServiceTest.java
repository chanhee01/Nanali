package Nanali.service;
/*
import Nanali.domain.Member.model.Member;
import Nanali.domain.Member.model.Style;
import Nanali.global.base.Category;
import Nanali.domain.like.model.LikeGarment;
import Nanali.domain.like.model.LikeStatus;
import Nanali.domain.garment.model.Garment;
import Nanali.global.base.Sex;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.weather.GarmentWeatherRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest
public class LikeGarmentServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    LikeGarmentService likeGarmentService;

    @Autowired
    GarmentService garmentService;

    @Test
    @Transactional
    public void likeOutfitTest() {
        Member member = new Member("loginId", "password", "nickname", "email", true, 20, Style.CASUAL);
        memberService.save(member);

        byte[] fileContent = "Test file content".getBytes();
        MultipartFile multipartFile = new MockMultipartFile("testfile.txt", "testfile.txt", "text/plain", fileContent);

        GarmentWeatherRequest garmentWeatherRequest1 = GarmentWeatherRequest.builder()
                .tempFrom(0D).tempTo(10D).uvFrom(0D).uvTo(1D).rainFrom(0D).rainTo(30D).build();
        GarmentWeatherRequest garmentWeatherRequest2 = GarmentWeatherRequest.builder()
                .tempFrom(10D).tempTo(20D).uvFrom(0D).uvTo(1D).rainFrom(0D).rainTo(50D).build();
        GarmentWeatherRequest garmentWeatherRequest3 = GarmentWeatherRequest.builder()
                .tempFrom(10D).tempTo(25D).uvFrom(0D).uvTo(2D).rainFrom(20D).rainTo(100D).build();
        GarmentWeatherRequest garmentWeatherRequest4 = GarmentWeatherRequest.builder()
                .tempFrom(10D).tempTo(20D).uvFrom(0D).uvTo(3D).rainFrom(70D).rainTo(100D).build();
        GarmentWeatherRequest garmentWeatherRequest5 = GarmentWeatherRequest.builder()
                .tempFrom(10D).tempTo(15D).uvFrom(0D).uvTo(3D).rainFrom(80D).rainTo(100D).build();
        GarmentWeatherRequest garmentWeatherRequest6 = GarmentWeatherRequest.builder()
                .tempFrom(15D).tempTo(20D).uvFrom(0D).uvTo(2D).rainFrom(0D).rainTo(50D).build();

        Garment top1 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest1);
        Garment top2 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest2);
        Garment top3 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest3);
        Garment top4 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest4);
        Garment top5 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest5);
        Garment top6 = garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest6);

        Garment pants1 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest1);
        Garment pants2 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest2);
        Garment pants3 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest3);
        Garment pants4 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest4);
        Garment pants5 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest5);
        Garment pants6 = garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest6);

        Garment outer1 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest1);
        Garment outer2 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest2);
        Garment outer3 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest3);
        Garment outer4 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest4);
        Garment outer5 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest5);
        Garment outer6 = garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest6);

        Garment shoes1 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest1);
        Garment shoes2 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest2);
        Garment shoes3 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest3);
        Garment shoes4 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest4);
        Garment shoes5 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest5);
        Garment shoes6 = garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest6);

        LikeGarment LikeOuter1 = new LikeGarment(member, outer1, LikeStatus.LIKE);
        LikeGarment LikeOuter2 = new LikeGarment(member, outer2, LikeStatus.LIKE);
        LikeGarment LikeOuter3 = new LikeGarment(member, outer3, LikeStatus.LIKE);
        LikeGarment LikeOuter4 = new LikeGarment(member, outer4, LikeStatus.LIKE);
        LikeGarment LikeOuter5 = new LikeGarment(member, outer5, LikeStatus.LIKE);
        LikeGarment LikeOuter6 = new LikeGarment(member, outer6, LikeStatus.LIKE);

        likeGarmentService.save(LikeOuter1);
        likeGarmentService.save(LikeOuter2);
        likeGarmentService.save(LikeOuter3);
        likeGarmentService.save(LikeOuter4);
        likeGarmentService.save(LikeOuter5);
        likeGarmentService.save(LikeOuter6);

        LikeGarment LikeTop1 = new LikeGarment(member, top1, LikeStatus.LIKE);
        LikeGarment LikeTop2 = new LikeGarment(member, top2, LikeStatus.LIKE);
        LikeGarment LikeTop3 = new LikeGarment(member, top3, LikeStatus.LIKE);
        LikeGarment LikeTop4 = new LikeGarment(member, top4, LikeStatus.LIKE);
        LikeGarment LikeTop5 = new LikeGarment(member, top5, LikeStatus.LIKE);
        LikeGarment LikeTop6 = new LikeGarment(member, top6, LikeStatus.LIKE);

        likeGarmentService.save(LikeTop1);
        likeGarmentService.save(LikeTop2);
        likeGarmentService.save(LikeTop3);
        likeGarmentService.save(LikeTop4);
        likeGarmentService.save(LikeTop5);
        likeGarmentService.save(LikeTop6);

        LikeGarment LikePants1 = new LikeGarment(member, pants1, LikeStatus.LIKE);
        LikeGarment LikePants2 = new LikeGarment(member, pants2, LikeStatus.LIKE);
        LikeGarment LikePants3 = new LikeGarment(member, pants3, LikeStatus.LIKE);
        LikeGarment LikePants4 = new LikeGarment(member, pants4, LikeStatus.LIKE);
        LikeGarment LikePants5 = new LikeGarment(member, pants5, LikeStatus.LIKE);
        LikeGarment LikePants6 = new LikeGarment(member, pants6, LikeStatus.LIKE);

        likeGarmentService.save(LikePants1);
        likeGarmentService.save(LikePants2);
        likeGarmentService.save(LikePants3);
        likeGarmentService.save(LikePants4);
        likeGarmentService.save(LikePants5);
        likeGarmentService.save(LikePants6);

        LikeGarment LikeShoes1 = new LikeGarment(member, shoes1, LikeStatus.LIKE);
        LikeGarment LikeShoes2 = new LikeGarment(member, shoes2, LikeStatus.LIKE);
        LikeGarment LikeShoes3 = new LikeGarment(member, shoes3, LikeStatus.LIKE);
        LikeGarment LikeShoes4 = new LikeGarment(member, shoes4, LikeStatus.LIKE);
        LikeGarment LikeShoes5 = new LikeGarment(member, shoes5, LikeStatus.LIKE);
        LikeGarment LikeShoes6 = new LikeGarment(member, shoes6, LikeStatus.LIKE);

        likeGarmentService.save(LikeShoes1);
        likeGarmentService.save(LikeShoes2);
        likeGarmentService.save(LikeShoes3);
        likeGarmentService.save(LikeShoes4);
        likeGarmentService.save(LikeShoes5);
        likeGarmentService.save(LikeShoes6);

        List<GarmentDto> outersList1 = likeGarmentService.findOuters(member);
        List<GarmentDto> topsList1 = likeGarmentService.findTops(member);
        List<GarmentDto> pantsList1 = likeGarmentService.findPants(member);
        List<GarmentDto> shoesList1 = likeGarmentService.findShoes(member);


        // 1 ~ 6까지 전체 출력

        for (GarmentDto outer : outersList1) {
            System.out.println("likeOutfit = " + outer);
        }

        for (GarmentDto top : topsList1) {
            System.out.println("likeOutfit = " + top);
        }

        for (GarmentDto pants : pantsList1) {
            System.out.println("likeOutfit = " + pants);
        }

        for (GarmentDto shoes : shoesList1) {
            System.out.println("likeOutfit = " + shoes);
        }

        System.out.println("===============================");

        likeGarmentService.changeLikeGarment(outer1.getId());
        likeGarmentService.changeLikeGarment(outer2.getId());
        likeGarmentService.changeLikeGarment(outer3.getId());
        likeGarmentService.changeLikeGarment(outer4.getId());

        likeGarmentService.changeLikeGarment(top1.getId());
        likeGarmentService.changeLikeGarment(top2.getId());
        likeGarmentService.changeLikeGarment(top3.getId());
        likeGarmentService.changeLikeGarment(top4.getId());

        likeGarmentService.changeLikeGarment(pants1.getId());
        likeGarmentService.changeLikeGarment(pants2.getId());
        likeGarmentService.changeLikeGarment(pants3.getId());
        likeGarmentService.changeLikeGarment(pants4.getId());

        likeGarmentService.changeLikeGarment(shoes1.getId());
        likeGarmentService.changeLikeGarment(shoes2.getId());
        likeGarmentService.changeLikeGarment(shoes3.getId());
        likeGarmentService.changeLikeGarment(shoes4.getId());

        List<GarmentDto> outersList2 = likeGarmentService.findOuters(member);
        List<GarmentDto> topsList2 = likeGarmentService.findTops(member);
        List<GarmentDto> pantsList2 = likeGarmentService.findPants(member);
        List<GarmentDto> shoesList2 = likeGarmentService.findShoes(member);

        // 5, 6만 출력

        for (GarmentDto outer : outersList2) {
            System.out.println("likeOutfit = " + outer);
        }

        for (GarmentDto top : topsList2) {
            System.out.println("likeOutfit = " + top);
        }

        for (GarmentDto pants : pantsList2) {
            System.out.println("likeOutfit = " + pants);
        }

        for (GarmentDto shoes : shoesList2) {
            System.out.println("likeOutfit = " + shoes);
        }

        System.out.println("===============================");

        likeGarmentService.changeLikeGarment(outer1.getId());

        likeGarmentService.changeLikeGarment(top1.getId());

        likeGarmentService.changeLikeGarment(pants1.getId());

        likeGarmentService.changeLikeGarment(shoes1.getId());;

        List<GarmentDto> outersList3 = likeGarmentService.findOuters(member);
        List<GarmentDto> topsList3 = likeGarmentService.findTops(member);
        List<GarmentDto> pantsList3 = likeGarmentService.findPants(member);
        List<GarmentDto> shoesList3 = likeGarmentService.findShoes(member);

        // 1, 5 ,6만 출력

        for (GarmentDto outer : outersList3) {
            System.out.println("likeOutfit = " + outer);
        }

        for (GarmentDto top : topsList3) {
            System.out.println("likeOutfit = " + top);
        }

        for (GarmentDto pants : pantsList3) {
            System.out.println("likeOutfit = " + pants);
        }

        for (GarmentDto shoes : shoesList3) {
            System.out.println("likeOutfit = " + shoes);
        }
    }
}
*/