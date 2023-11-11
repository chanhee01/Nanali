package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeGarment;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import Nanali.domain.cody.LikeClothes.LikeStatus;
import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.dtos.garment.GarmentDto;
import Nanali.repository.LikeGarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeGarmentService {

    private final LikeGarmentRepository likeGarmentRepository;

    @Transactional
    public Long save(LikeGarment likeGarment) {
        LikeGarment save = likeGarmentRepository.save(likeGarment);
        return save.getId();
    }

    public LikeGarment findOne(Long id) {
        return likeGarmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(String.format("failed to find likeGarment. id: %s", id)));
    }

    public List<GarmentDto> findTops(Member member) {
        List<LikeGarment> allTop = likeGarmentRepository.findAllLikeTop(member);

        List<GarmentDto> LikeTops = allTop.stream().map(top -> GarmentDto.convert(top.getGarment()))
                .collect(Collectors.toList());

        return LikeTops;
    }

    public List<GarmentDto> findPants(Member member) {
        List<LikeGarment> allPants = likeGarmentRepository.findAllLikePants(member);

        List<GarmentDto> LikePants = allPants.stream().map(pants -> GarmentDto.convert(pants.getGarment()))
                .collect(Collectors.toList());

        return LikePants;
    }

    public List<GarmentDto> findOuters(Member member) {
        List<LikeGarment> allOuter = likeGarmentRepository.findAllLikeOuter(member);

        List<GarmentDto> LikeOuters = allOuter.stream().map(outer -> GarmentDto.convert(outer.getGarment()))
                .collect(Collectors.toList());

        return LikeOuters;
    }

    public List<GarmentDto> findShoes(Member member) {
        List<LikeGarment> allShoes = likeGarmentRepository.findAllLikeShoes(member);

        List<GarmentDto> LikeShoes = allShoes.stream().map(shoes -> GarmentDto.convert(shoes.getGarment()))
                .collect(Collectors.toList());

        return LikeShoes;
    }

    @Transactional
    public void changeLikeGarment(Long id) {
        LikeGarment findGarment = findOne(id);

        if (findGarment.getLikeStatus() == LikeStatus.LIKE) {
            findGarment.changeLikeStatus(LikeStatus.DISLIKE);
        }
        else {
            findGarment.changeLikeStatus(LikeStatus.LIKE);
        }
    }

    @Transactional
    public void deleteLikeGarment(Member member, Garment garment) {
        LikeGarment likeGarment = likeGarmentRepository.findOneByMemberAndGarment(member.getId(), garment.getId());
        likeGarmentRepository.deleteById(likeGarment.getId());
    }

    public boolean validationLikeGarment(Long memberId, Long garmentId) {
        return likeGarmentRepository.findOneByMember(memberId, garmentId) != null;
    }
}
