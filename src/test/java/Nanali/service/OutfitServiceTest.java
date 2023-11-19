package Nanali.service;
/*
import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.weather.OutfitWeatherRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class OutfitServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    OutfitService outfitService;

    @DisplayName("날씨에 해당하는 outfit 사진 랜덤으로 하나 추출")
    @Test
    @Transactional
    public void findOutfit() {
        Member member = new Member("loginId", "password", "nickname", "email", true, 20, Style.CASUAL);
        memberService.save(member);

        byte[] fileContent = "Test file content".getBytes();
        MultipartFile multipartFile = new MockMultipartFile("testfile.txt", "testfile.txt", "text/plain", fileContent);

        OutfitWeatherRequest outfitWeatherRequest1 = OutfitWeatherRequest.builder()
                .tempFrom(0D).tempTo(10D).uvFrom(0D).uvTo(1D).rainFrom(0D).rainTo(30D).build();
        OutfitWeatherRequest outfitWeatherRequest2 = OutfitWeatherRequest.builder()
                .tempFrom(10D).tempTo(20D).uvFrom(0D).uvTo(1D).rainFrom(0D).rainTo(50D).build();
        OutfitWeatherRequest outfitWeatherRequest3 = OutfitWeatherRequest.builder()
                .tempFrom(10D).tempTo(25D).uvFrom(0D).uvTo(2D).rainFrom(20D).rainTo(100D).build();
        OutfitWeatherRequest outfitWeatherRequest4 = OutfitWeatherRequest.builder()
                .tempFrom(10D).tempTo(20D).uvFrom(0D).uvTo(3D).rainFrom(70D).rainTo(100D).build();
        OutfitWeatherRequest outfitWeatherRequest5 = OutfitWeatherRequest.builder()
                .tempFrom(10D).tempTo(15D).uvFrom(0D).uvTo(3D).rainFrom(80D).rainTo(100D).build();
        OutfitWeatherRequest outfitWeatherRequest6 = OutfitWeatherRequest.builder()
                .tempFrom(15D).tempTo(20D).uvFrom(0D).uvTo(2D).rainFrom(0D).rainTo(50D).build();
        OutfitWeatherRequest outfitWeatherRequest7 = OutfitWeatherRequest.builder()
                .tempFrom(15D).tempTo(20D).uvFrom(0D).uvTo(2D).rainFrom(0D).rainTo(50D).build();

        Outfit outfit1 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest1);
        Outfit outfit2 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest2);
        Outfit outfit3 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest3);
        Outfit outfit4 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest4);
        Outfit outfit5 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest5);
        Outfit outfit6 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest6);
        Outfit outfit7 = outfitService.save(multipartFile, Style.CASUAL, Sex.BOTH, outfitWeatherRequest7);

        Outfit one = outfitService.findOne(outfit1.getId());

        System.out.println("one" + one.getImgName());

        Outfit style1 = outfitService.findOutfit(10D, 1D, 20D, Style.CASUAL, Sex.BOTH);

        System.out.println(style1.getImgName());

        Outfit style2 = outfitService.findOutfit(10D, 1D, 20D, Style.CASUAL, Sex.BOTH);

        System.out.println(style2.getImgName());

        Outfit style3 = outfitService.findOutfit(10D, 1D, 20D, Style.CASUAL, Sex.BOTH);

        System.out.println(style3.getImgName());
    }
}*/