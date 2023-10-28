package Nanali.service;

import Nanali.domain.cody.cloth.Outfit;
import Nanali.repository.OutfitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OutfitService {

    private final OutfitRepository outfitRepository;

    @Transactional
    public Long save(Outfit outfit) {
        Outfit save = outfitRepository.save(outfit);
        return save.getId();
    }

    public List<Outfit> findOutfit(Long temp, Long uv, Long rain, String style) {
        // Style 타입으로 수정 필요
        List<Outfit> allOutifs = outfitRepository.findAllOutifs(temp, uv, rain, style);
        return allOutifs;
    }

    public Outfit findOne(Long id) {
        Outfit find = outfitRepository.findById(id).get();
        return find;
    }
}
