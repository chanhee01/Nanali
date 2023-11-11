package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.dtos.outfit.OutfitDto;
import Nanali.repository.LikeOutfitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeOutfitService {

    private final LikeOutfitRepository likeOutfitRepository;

    @Transactional
    public Long save(LikeOutfit likeOutfit) {
        LikeOutfit save = likeOutfitRepository.save(likeOutfit);
        return save.getId();
    }

    public LikeOutfit findOne(Long id) {
        return likeOutfitRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(String.format("failed to find likeOutfit. id: %s", id)));
    }

    public List<OutfitDto> findAllByMember(Member member) {
        List<LikeOutfit> allByMember = likeOutfitRepository.findAllByMemberAndLikeStatusIsLike(member, LikeStatus.LIKE);

        List<OutfitDto> LikeOutfits = allByMember.stream()
                .map(outfit -> new OutfitDto(outfit.getOutfit().getId(),
                        outfit.getOutfit().getImgUrl()))
                .collect(Collectors.toList());
        return LikeOutfits;
    }

    @Transactional
    public void changeLikeOutfit(Long id) {
        LikeOutfit findOutfit = findOne(id);

        if (findOutfit.getLikeStatus() == LikeStatus.LIKE) {
            findOutfit.changeLikeStatus(LikeStatus.DISLIKE);
        }
        else {
            findOutfit.changeLikeStatus(LikeStatus.LIKE);
        }
    }

    @Transactional
    public void deleteLikeOutfit(Member member, Outfit outfit) {
        LikeOutfit likeOutfit = likeOutfitRepository.findOneByMemberAndOutfit(member.getId(), outfit.getId());
        likeOutfitRepository.deleteById(likeOutfit.getId());
    }

    public boolean validationLikeOutfit(Long memberId, Long outfitId) {
        return likeOutfitRepository.findOneByMember(memberId, outfitId) != null;
    }
}
