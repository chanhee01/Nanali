package Nanali.domain.like.api;

import Nanali.domain.Member.model.Member;
import Nanali.domain.Member.service.MemberService;
import Nanali.domain.garment.service.GarmentService;
import Nanali.domain.like.model.LikeGarment;
import Nanali.domain.like.model.LikeOutfit;
import Nanali.domain.like.model.LikeStatus;
import Nanali.domain.garment.model.Garment;
import Nanali.domain.like.service.likeGarment.LikeGarmentService;
import Nanali.domain.like.service.likeOutfit.LikeOutfitService;
import Nanali.domain.outfit.model.Outfit;
import Nanali.domain.outfit.service.OutfitService;
import Nanali.global.login.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LikeController {

    private final MemberService memberService;
    private final GarmentService garmentService;
    private final OutfitService outfitService;
    private final LikeOutfitService likeOutfitService;
    private final LikeGarmentService likeGarmentService;
    private final HttpSession session;

    @PostMapping("/outfit/{outfitId}") // 추천 페이지에서 좋아요 누르기
    public void LikeOutfit(@PathVariable Long outfitId) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Outfit outfit = outfitService.findOne(outfitId);

        boolean CanLikeStatus = likeOutfitService.validationLikeOutfit(member.getId(), outfitId);
        if (CanLikeStatus == true) {
            LikeOutfit likeOutfit = LikeOutfit.builder()
                            .member(member).outfit(outfit).likeStatus(LikeStatus.LIKE).build();
            likeOutfitService.save(likeOutfit);
        }
        else {
        }
    }

    @DeleteMapping("/outfit/{outfitId}")
    public void deleteOutfit(@PathVariable Long outfitId) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Outfit outfit = outfitService.findOne(outfitId);

        likeOutfitService.deleteLikeOutfit(member, outfit);
    }

    @PostMapping("/garment/{garmentId}") // 추천 페이지에서 좋아요 누르기
    public void LikeGarment(@PathVariable Long garmentId) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Garment garment = garmentService.findById(garmentId);

        boolean CanLikeStatus = likeGarmentService.validationLikeGarment(member.getId(), garmentId);
        if (CanLikeStatus == true) {
            LikeGarment likeGarment = LikeGarment.builder()
                            .member(member).garment(garment).likeStatus(LikeStatus.LIKE).build();
            likeGarmentService.save(likeGarment);
        }
        else {
        }
    }

    @DeleteMapping("/garment/{garmentId}")
    public void deleteGarment(@PathVariable Long garmentId) {
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        Garment garment = garmentService.findById(garmentId);

        likeGarmentService.deleteLikeGarment(member, garment);
    }


    /*@PatchMapping("/outfit/change") // 마이페이지 좋아요 누르기, 취소
    public void changeOutfit(@RequestBody Long outfitId) {
        likeOutfitService.changeLikeOutfit(outfitId);
    }*/

    /*@PatchMapping("/garment/change") // 마이페이지 좋아요 누르기, 취소
    public void changeGarment(@RequestBody Long garmentId) {
        likeOutfitService.changeLikeOutfit(garmentId);
    }*/
}
