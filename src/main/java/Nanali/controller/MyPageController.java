package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.dtos.MyPage.GarmentDto;
import Nanali.dtos.MyPage.OutfitDto;
import Nanali.service.LikeGarmentService;
import Nanali.service.LikeOutfitService;
import Nanali.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myPage")
public class MyPageController {

    private final MemberService memberService;
    private final LikeGarmentService likeGarmentService;
    private final LikeOutfitService likeOutfitService;

    @GetMapping("/outfit")
    public OutfitDto outfit() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        String memberImg = member.getMemberImg().getImgUrl();

        List<String> outfits = likeOutfitService.findAllByMember(member);

        OutfitDto outfitDto = new OutfitDto(nickname, email, memberImg, outfits);
        return outfitDto;
    }

    @GetMapping("/garment")
    public GarmentDto garment() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        String memberImg = member.getMemberImg().getImgUrl();

        List<String> tops = likeGarmentService.findTops(member);
        List<String> pants = likeGarmentService.findPants(member);
        List<String> outers = likeGarmentService.findOuters(member);
        List<String> shoes = likeGarmentService.findShoes(member);

        GarmentDto garmentDto = new GarmentDto(nickname, email, memberImg, tops, pants, outers, shoes);
        return garmentDto;
    }

    // 로그인 시 세션 넣고 인증도 넣어야할듯

    @PutMapping("/change/nickname")
    public void changeNickname(@RequestBody String nickname) {
        Member member = memberService.findById(1L);
        memberService.changeNickname(member, nickname);
    }

    @PutMapping("/change/style")
    public void changeStyle(@RequestBody Style style) {
        Member member = memberService.findById(1L);
        memberService.changeStyle(member, style);
    }

    @PutMapping("/change/password")
    public void changePassword(@RequestBody String password) {
        Member member = memberService.findById(1L);
        memberService.changePassword(member, password);
    }
}
