package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeGarment;
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
        return likeGarmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<LikeGarment> findAllByMember(Member member) {
        return likeGarmentRepository.findAllByMember(member);
    }

    public List<String> findTops(Member member) {
        List<LikeGarment> allTop = likeGarmentRepository.findAllTop(member);

        List<String> LikeTops = allTop.stream().map(top -> top.getGarment().getImgUrl()).collect(Collectors.toList());
        return LikeTops;
    }

    public List<String> findPants(Member member) {
        List<LikeGarment> allPants = likeGarmentRepository.findAllPants(member);

        List<String> LikePants = allPants.stream().map(pant -> pant.getGarment().getImgUrl()).collect(Collectors.toList());
        return LikePants;
    }

    public List<String> findOuters(Member member) {
        List<LikeGarment> allOuter = likeGarmentRepository.findAllOuter(member);

        List<String> LikeOuters = allOuter.stream().map(outer -> outer.getGarment().getImgUrl()).collect(Collectors.toList());
        return LikeOuters;
    }

    public List<String> findShoes(Member member) {
        List<LikeGarment> allShoes = likeGarmentRepository.findAllShoes(member);

        List<String> LikeShoes = allShoes.stream().map(shoes -> shoes.getGarment().getImgUrl()).collect(Collectors.toList());
        return LikeShoes;
    }
}
