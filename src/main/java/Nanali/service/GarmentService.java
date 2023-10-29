package Nanali.service;

import Nanali.domain.cody.cloth.Garment;
import Nanali.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Garment> findOuters(Long temp, Long uv, Long rain) {
        return garmentRepository.findAllByCategoryIsOuter(temp, uv, rain);
    }

    public List<Garment> findTops(Long temp, Long uv, Long rain) {
        return garmentRepository.findAllByCategoryIsTop(temp, uv, rain);
    }

    public List<Garment> findPants(Long temp, Long uv, Long rain) {
        return garmentRepository.findAllByCategoryIsPants(temp, uv, rain);
    }

    public List<Garment> findShoes(Long temp, Long uv, Long rain) {
        return garmentRepository.findAllByCategoryIsShoes(temp, uv, rain);
    }
}
