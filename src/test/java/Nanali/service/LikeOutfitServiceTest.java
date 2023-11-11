package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.outfit.OutfitDto;
import Nanali.dtos.weather.GarmentWeatherRequest;
import Nanali.dtos.weather.OutfitWeatherRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest
class LikeOutfitServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    LikeOutfitService likeOutfitService;

    @Autowired
    OutfitService outfitService;

    @Test
    public void likeOutfitTest() {
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

        LikeOutfit likeOutfit1 = new LikeOutfit(member, outfit1, LikeStatus.LIKE);
        LikeOutfit likeOutfit2 = new LikeOutfit(member, outfit2, LikeStatus.LIKE);
        LikeOutfit likeOutfit3 = new LikeOutfit(member, outfit3, LikeStatus.LIKE);
        LikeOutfit likeOutfit4 = new LikeOutfit(member, outfit4, LikeStatus.LIKE);
        LikeOutfit likeOutfit5 = new LikeOutfit(member, outfit5, LikeStatus.LIKE);
        LikeOutfit likeOutfit6 = new LikeOutfit(member, outfit6, LikeStatus.LIKE);
        LikeOutfit likeOutfit7 = new LikeOutfit(member, outfit7, LikeStatus.LIKE);

        likeOutfitService.save(likeOutfit1);
        likeOutfitService.save(likeOutfit2);
        likeOutfitService.save(likeOutfit3);
        likeOutfitService.save(likeOutfit4);
        likeOutfitService.save(likeOutfit5);
        likeOutfitService.save(likeOutfit6);
        likeOutfitService.save(likeOutfit7);

        List<OutfitDto> allByMember1 = likeOutfitService.findAllByMember(member);

        for (OutfitDto outfit : allByMember1) {
            System.out.println("likeOutfit = " + outfit);
        }

        System.out.println("===============================");

        likeOutfitService.changeLikeOutfit(likeOutfit1.getId());
        likeOutfitService.changeLikeOutfit(likeOutfit2.getId());
        likeOutfitService.changeLikeOutfit(likeOutfit3.getId());
        likeOutfitService.changeLikeOutfit(likeOutfit4.getId());
        likeOutfitService.changeLikeOutfit(likeOutfit5.getId());

        List<OutfitDto> allByMember2 = likeOutfitService.findAllByMember(member);


        for (OutfitDto outfit : allByMember2) {
            System.out.println("likeOutfit = " + outfit);
        }

        System.out.println("===============================");

        likeOutfitService.changeLikeOutfit(likeOutfit1.getId());
        likeOutfitService.changeLikeOutfit(likeOutfit2.getId());

        List<OutfitDto> allByMember3 = likeOutfitService.findAllByMember(member);


        for (OutfitDto outfit : allByMember3) {
            System.out.println("likeOutfit = " + outfit);
        }
    }
}