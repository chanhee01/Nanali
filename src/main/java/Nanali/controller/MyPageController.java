package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.MemberImg;
import Nanali.domain.Member.Style;
import Nanali.dtos.MyPage.LikeGarmentDto;
import Nanali.dtos.MyPage.LikeOutfitDto;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.outfit.OutfitDto;
import Nanali.service.LikeGarmentService;
import Nanali.service.LikeOutfitService;
import Nanali.service.MemberImgService;
import Nanali.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myPage")
public class MyPageController {

    private final MemberService memberService;
    private final LikeGarmentService likeGarmentService;
    private final LikeOutfitService likeOutfitService;
    private final MemberImgService memberImgService;

    @GetMapping("/outfit")
    public LikeOutfitDto outfit() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();

        MemberImg memberImg;

        String imgUrl;

        if (member.getMemberImg() == null) {
            memberImg = null;
            imgUrl = null;
        }
        else {
            memberImg = member.getMemberImg();
            imgUrl = memberImg.getImgUrl();
        }

        List<OutfitDto> outfits = likeOutfitService.findAllByMember(member);

        LikeOutfitDto outfitDto = LikeOutfitDto.builder()
                .nickname(nickname).email(email).memberImg(imgUrl).outfits(outfits).build();
        return outfitDto;
    }

    @GetMapping("/garment")
    public LikeGarmentDto garment() {
        Member member = memberService.findById(1L);
        String nickname = member.getNickname();
        String email = member.getEmail();

        MemberImg memberImg;

        String imgUrl;

        if (member.getMemberImg() == null) {
            memberImg = null;
            imgUrl = null;
        }
        else {
            memberImg = member.getMemberImg();
            imgUrl = memberImg.getImgUrl();
        }

        List<GarmentDto> tops = likeGarmentService.findTops(member);
        List<GarmentDto> pants = likeGarmentService.findPants(member);
        List<GarmentDto> outers = likeGarmentService.findOuters(member);
        List<GarmentDto> shoes = likeGarmentService.findShoes(member);

        LikeGarmentDto garmentDto = LikeGarmentDto.builder()
                .nickname(nickname).email(email).memberImg(imgUrl)
                .outers(outers).tops(tops).pants(pants).shoes(shoes).build();

        return garmentDto;
    }

    // 로그인 시 세션 넣고 인증도 넣어야할듯

    @PatchMapping("/change/nickname")
    public void changeNickname(@RequestBody String nickname) {
        Member member = memberService.findById(1L);
        memberService.changeNickname(member, nickname);
    }

    @PatchMapping("/change/style")
    public void changeStyle(@RequestBody Style style) {
        Member member = memberService.findById(1L);
        memberService.changeStyle(member, style);
    }

    @PatchMapping("/change/password")
    public void changePassword(@RequestBody String password) {
        Member member = memberService.findById(1L);
        memberService.changePassword(member, password);
    }

    @PatchMapping("/memberImg")
    public void changeMemberImg(@RequestPart MultipartFile memberImg) {
        Member member = memberService.findById(1L);

        MemberImg image = memberImgService.findMemberImg(member);
        if(image != null) {
            Long memberImgId = image.getId();
            memberImgService.updateImg(memberImg, memberImgId);
        }
        else {
            memberImgService.saveImg(memberImg, member);
        }
    }
}
