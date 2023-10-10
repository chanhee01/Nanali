package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.dtos.MyPage.GarmentDto;
import Nanali.dtos.MyPage.OutfitDto;
import Nanali.service.LikeGarmentService;
import Nanali.service.LikeOutfitService;
import Nanali.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myPage")
public class MyPageController {

    private final MemberService memberService;
    private final LikeGarmentService likeGarmentService;
    private final LikeOutfitService likeOutfitService;

    @GetMapping("/garment")
    public GarmentDto garment() {
        Member member = memberService.findMember(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        List<String> tops = likeGarmentService.findTops(member);
        List<String> pants = likeGarmentService.findPants(member);
        List<String> outers = likeGarmentService.findOuters(member);
        List<String> shoes = likeGarmentService.findShoes(member);

        GarmentDto garmentDto = new GarmentDto(nickname, email, tops, pants, outers, shoes);
        return garmentDto;
    }

    @GetMapping("/outfit")
    public OutfitDto outfit() {
        Member member = memberService.findMember(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        List<String> outfits = likeOutfitService.findAllByMember(member);

        OutfitDto outfitDto = new OutfitDto(nickname, email, outfits);
        return outfitDto;
    }
}
