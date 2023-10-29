package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
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
        return likeOutfitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<String> findAllByMember(Member member) {
        List<LikeOutfit> allByMember = likeOutfitRepository.findAllByMember(member.getId());

        List<String> LikeOutfits = allByMember.stream()
                .map(outfit -> outfit.getOutfit().getImgUrl())
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
}
