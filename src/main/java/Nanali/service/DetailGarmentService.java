package Nanali.service;

import Nanali.domain.cody.cloth.Garment;
import Nanali.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DetailGarmentService {
    private final GarmentRepository garmentRepository;

    public String findUrl(long id){
        Garment garment=garmentRepository.findById(id).get();
        String imgUrl=garment.getImgUrl();

        return imgUrl;
    }

}
