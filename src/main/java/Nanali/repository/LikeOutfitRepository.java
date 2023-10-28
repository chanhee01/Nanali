package Nanali.repository;

import Nanali.domain.Member.Member;
import Nanali.domain.cody.LikeClothes.LikeOutfit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeOutfitRepository extends JpaRepository<LikeOutfit, Long> {

    List<LikeOutfit> findAllByMember(Member member);
}
