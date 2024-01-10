package Nanali.domain.outfit.service;

import Nanali.domain.Member.model.Style;
import Nanali.domain.outfit.model.Outfit;
import Nanali.global.base.Sex;
import Nanali.global.weather.dto.OutfitWeatherRequest;
import Nanali.domain.outfit.repository.OutfitRepository;
import Nanali.global.s3.S3FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OutfitService {

    private final OutfitRepository outfitRepository;
    private final S3FileService s3FileService;

    @Transactional
    public Outfit save(MultipartFile OutfitImg, Style style, Sex sex, OutfitWeatherRequest weather) {

        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(OutfitImg, "outfit");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;

        Outfit outfit = Outfit.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .style(style)
                .sex(sex)
                .tempFrom(weather.getTempFrom())
                .tempTo(weather.getTempTo())
                .uvFrom(weather.getUvFrom())
                .uvTo(weather.getUvTo())
                .rainFrom(weather.getRainFrom())
                .rainTo(weather.getRainTo()).build();

        Outfit savedOutfit = outfitRepository.save(outfit);

        return savedOutfit;
    }

    public Outfit findOutfit(Double temp, Double uv, Double rain, Style style, Sex sex) {
        List<Outfit> allOutifs = outfitRepository.findAllOutifs(temp, uv, rain, style, sex);

        Collections.shuffle(allOutifs);

        return allOutifs.get(0);
    }

    public Outfit findOne(Long id) {
        Outfit find = outfitRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(String.format("failed to find Outfit. id: %s", id)));
        return find;
    }
}
