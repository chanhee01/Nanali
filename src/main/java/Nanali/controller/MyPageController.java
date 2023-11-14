package Nanali.controller;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.MemberImg;
import Nanali.domain.Member.Style;
import Nanali.dtos.MyPage.LikeGarmentDto;
import Nanali.dtos.MyPage.LikeOutfitDto;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.outfit.OutfitDto;
import Nanali.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myPage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MyPageController {

    private final MemberService memberService;
    private final LikeGarmentService likeGarmentService;
    private final LikeOutfitService likeOutfitService;
    private final MemberImgService memberImgService;
    private final HttpSession session;

    @GetMapping("/outfit")
    public LikeOutfitDto outfit() {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
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
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
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

    @PatchMapping("/change/nickname")
    public void changeNickname(@RequestBody @NotBlank String nickname) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        System.out.println("id = " + member.getId());

        memberService.changeNickname(member, nickname);
    }

    @PatchMapping("/change/style")
    public void changeStyle(@RequestBody @NotNull Style style) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        memberService.changeStyle(member, style);
    }

    @PatchMapping("/change/password")
    public void changePassword(@RequestBody @NotBlank String password) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        memberService.changePassword(member, password);
    }

    @PatchMapping("/memberImg")
    public void changeMemberImg(@RequestPart MultipartFile memberImg) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

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
