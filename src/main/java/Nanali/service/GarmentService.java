package Nanali.service;

import Nanali.domain.Member.Style;
import Nanali.domain.cody.Category;
import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.Sex;
import Nanali.dtos.weather.GarmentWeatherRequest;
import Nanali.dtos.weather.OutfitWeatherRequest;
import Nanali.repository.GarmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GarmentService {

    private final GarmentRepository garmentRepository;

    private final S3FileService s3FileService;

    @Transactional
    public Garment save(MultipartFile OutfitImg, Category category, Sex sex, GarmentWeatherRequest weather) {

        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(OutfitImg, "garment");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;

        Garment garment = new Garment(imgName, imgUrl, category, sex, weather.getTemp_from(), weather.getTemp_to(),
                weather.getUv_from(), weather.getUv_to(), weather.getRain_from(), weather.getRain_to());

        Garment savedGarment = garmentRepository.save(garment);
        return savedGarment;
    }

    public Garment findById(Long id) {
        return garmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Garment> findOuters(Long temp, Long uv, Long rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsOuter(temp, uv, rain, sex);
    }

    public List<Garment> findTops(Long temp, Long uv, Long rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsTop(temp, uv, rain, sex);
    }

    public List<Garment> findPants(Long temp, Long uv, Long rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsPants(temp, uv, rain, sex);
    }

    public List<Garment> findShoes(Long temp, Long uv, Long rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsShoes(temp, uv, rain, sex);
    }
}
