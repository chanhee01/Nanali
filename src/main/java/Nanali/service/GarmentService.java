package Nanali.service;

import Nanali.domain.cody.cloth.Garment;
import Nanali.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GarmentService {

    private final GarmentRepository garmentRepository;

    @Transactional
    public Long save(Garment garment) {
        Garment save = garmentRepository.save(garment);
        return save.getId();
    }
}
