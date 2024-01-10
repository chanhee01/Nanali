package Nanali.service;
/*
import Nanali.domain.Member.model.Member;
import Nanali.domain.Member.model.Style;
import Nanali.global.base.Category;
import Nanali.domain.garment.model.Garment;
import Nanali.global.base.Sex;
import Nanali.dtos.weather.GarmentWeatherRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest
public class GarmentServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    GarmentService garmentService;

    @DisplayName("카테고리별 날씨에 맞는 아이템 추출")
    @Test
    @Transactional
    public void findGarment() {
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

        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest1);
        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest2);
        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest3);
        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest4);
        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest5);
        garmentService.save(multipartFile, Category.TOP, Sex.BOTH, garmentWeatherRequest6);

        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest1);
        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest2);
        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest3);
        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest4);
        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest5);
        garmentService.save(multipartFile, Category.SHOES, Sex.BOTH, garmentWeatherRequest6);

        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest1);
        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest2);
        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest3);
        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest4);
        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest5);
        garmentService.save(multipartFile, Category.OUTER, Sex.BOTH, garmentWeatherRequest6);

        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest1);
        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest2);
        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest3);
        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest4);
        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest5);
        garmentService.save(multipartFile, Category.PANTS, Sex.BOTH, garmentWeatherRequest6);

        List<Garment> outers = garmentService.findOuters(10D, 1D, 20D, Sex.BOTH);
        List<Garment> tops = garmentService.findTops(10D, 1D, 20D, Sex.BOTH);
        List<Garment> pants = garmentService.findPants(10D, 1D, 20D, Sex.BOTH);
        List<Garment> shoes = garmentService.findShoes(10D, 1D, 20D, Sex.BOTH);

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

        List<Garment> outerList = garmentService.findOuters(20D, 1D, 20D, Sex.BOTH);
        List<Garment> topsList = garmentService.findTops(20D, 1D, 20D, Sex.BOTH);
        List<Garment> pantsList = garmentService.findPants(20D, 1D, 20D, Sex.BOTH);
        List<Garment> shoesList = garmentService.findShoes(20D, 1D, 20D, Sex.BOTH);

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
*/