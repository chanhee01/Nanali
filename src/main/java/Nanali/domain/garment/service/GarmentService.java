package Nanali.domain.garment.service;

import Nanali.global.base.Category;
import Nanali.domain.garment.model.Garment;
import Nanali.global.base.Sex;
import Nanali.global.weather.dto.GarmentWeatherRequest;
import Nanali.domain.garment.repository.GarmentRepository;
import Nanali.global.s3.S3FileService;
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

        Garment garment = Garment.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .category(category)
                .sex(sex)
                .tempFrom(weather.getTempFrom())
                .tempTo(weather.getTempTo())
                .uvFrom(weather.getUvFrom())
                .uvTo(weather.getUvTo())
                .rainFrom(weather.getRainFrom())
                .rainTo(weather.getRainTo()).build();

        Garment savedGarment = garmentRepository.save(garment);
        return savedGarment;
    }

    public Garment findById(Long id) {
        return garmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(String.format("failed to find garment. id: %s", id)));
    }

    public List<Garment> findOuters(Double temp, Double uv, Double rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsOuter(temp, uv, rain, sex);
    }

    public List<Garment> findTops(Double temp, Double uv, Double rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsTop(temp, uv, rain, sex);
    }

    public List<Garment> findPants(Double temp, Double uv, Double rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsPants(temp, uv, rain, sex);
    }

    public List<Garment> findShoes(Double temp, Double uv, Double rain, Sex sex) {
        return garmentRepository.findAllByCategoryIsShoes(temp, uv, rain, sex);
    }
}
