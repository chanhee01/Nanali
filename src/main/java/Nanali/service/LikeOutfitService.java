package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.outfit.LikeOutfit;
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

    public LikeOutfit findOne(Long id) {
        return likeOutfitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<String> findAllByMember(Member member) {
        List<LikeOutfit> allByMember = likeOutfitRepository.findAllByMember(member);

        List<String> LikeOutfits = allByMember.stream().map(outfit -> outfit.getImgUrl()).collect(Collectors.toList());
        return LikeOutfits;
    }
}
