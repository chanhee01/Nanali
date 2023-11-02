package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.Style;
import Nanali.dtos.MyPage.LikeGarmentDto;
import Nanali.dtos.MyPage.LikeOutfitDto;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.outfit.OutfitDto;
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
    public LikeOutfitDto outfit() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        String memberImg = member.getMemberImg().getImgUrl();

        List<OutfitDto> outfits = likeOutfitService.findAllByMember(member);

        LikeOutfitDto outfitDto = new LikeOutfitDto(nickname, email, memberImg, outfits);
        return outfitDto;
    }

    @GetMapping("/garment")
    public LikeGarmentDto garment() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();
        String memberImg = member.getMemberImg().getImgUrl();

        List<GarmentDto> tops = likeGarmentService.findTops(member);
        List<GarmentDto> pants = likeGarmentService.findPants(member);
        List<GarmentDto> outers = likeGarmentService.findOuters(member);
        List<GarmentDto> shoes = likeGarmentService.findShoes(member);

        LikeGarmentDto garmentDto = new LikeGarmentDto(nickname, email, memberImg, tops, pants, outers, shoes);
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
