package Nanali.service;

import Nanali.domain.cody.cloth.Outfit;
import Nanali.repository.OutfitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OutfitService {

    private final OutfitRepository outfitRepository;

    public Long save(Outfit outfit) {
        Outfit save = outfitRepository.save(outfit);
        return save.getId();
    }
}
