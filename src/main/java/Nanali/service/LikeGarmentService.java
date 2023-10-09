package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.outfit.LikeGarment;
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

    public LikeGarment findOne(Long id) {
        return likeGarmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<LikeGarment> findAllByMember(Member member) {
        return likeGarmentRepository.findAllByMember(member);
    }

    public List<String> findTops(Member member) {
        List<LikeGarment> allTop = likeGarmentRepository.findAllTop(member);

        List<String> LikeTops = allTop.stream().map(top -> top.getImgUrl()).collect(Collectors.toList());
        return LikeTops;
    }

    public List<String> findPants(Member member) {
        List<LikeGarment> allPants = likeGarmentRepository.findAllPants(member);

        List<String> LikePants = allPants.stream().map(pant -> pant.getImgUrl()).collect(Collectors.toList());
        return LikePants;
    }

    public List<String> findOuters(Member member) {
        List<LikeGarment> allOuter = likeGarmentRepository.findAllOuter(member);

        List<String> LikeOuters = allOuter.stream().map(outer -> outer.getImgUrl()).collect(Collectors.toList());
        return LikeOuters;
    }

    public List<String> findShoes(Member member) {
        List<LikeGarment> allShoes = likeGarmentRepository.findAllShoes(member);

        List<String> LikeShoes = allShoes.stream().map(shoes -> shoes.getImgUrl()).collect(Collectors.toList());
        return LikeShoes;
    }
}
