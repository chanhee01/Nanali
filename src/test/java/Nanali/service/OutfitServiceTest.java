package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.weather.OutfitWeatherRequest;
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
    public void findOutfit() {
        Member member = new Member("loginId", "password", "nickname", "email", true, 20, Style.CASUAL);
        memberService.save(member);

        byte[] fileContent = "Test file content".getBytes();
        MultipartFile multipartFile = new MockMultipartFile("testfile.txt", "testfile.txt", "text/plain", fileContent);

        OutfitWeatherRequest outfitWeatherRequest1 = new OutfitWeatherRequest(0D, 10D, 0D, 1D, 0D, 30D);
        OutfitWeatherRequest outfitWeatherRequest2 = new OutfitWeatherRequest(10D, 20D, 0D, 1D, 0D, 50D);
        OutfitWeatherRequest outfitWeatherRequest3 = new OutfitWeatherRequest(10D, 25D, 0D, 2D, 20D, 100D);
        OutfitWeatherRequest outfitWeatherRequest4 = new OutfitWeatherRequest(10D, 20D, 0D, 3D, 70D, 100D);
        OutfitWeatherRequest outfitWeatherRequest5 = new OutfitWeatherRequest(10D, 14D, 0D, 3D, 80D, 100D);
        OutfitWeatherRequest outfitWeatherRequest6 = new OutfitWeatherRequest(15D, 20D, 0D, 2D, 0D, 50D);
        OutfitWeatherRequest outfitWeatherRequest7 = new OutfitWeatherRequest(15D, 20D, 0D, 2D, 0D, 30D);

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
}