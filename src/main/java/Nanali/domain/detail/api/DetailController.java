package Nanali.domain.detail.api;

import Nanali.domain.outfit.model.Outfit;
import Nanali.domain.detail.model.Detail;
import Nanali.domain.detail.dto.DetailDto;
import Nanali.domain.detail.dto.DetailResponseDto;
import Nanali.domain.detail.dto.InsertDetailDto;
import Nanali.domain.detail.dto.DetailRequestDto;
import Nanali.domain.detail.service.DetailService;
import Nanali.domain.outfit.service.OutfitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/detail")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DetailController {

    private final OutfitService outfitService;
    private final DetailService detailService;

    @GetMapping("/{outfitId}")
    public DetailRequestDto details(@PathVariable Long outfitId) {
        Outfit outfit = outfitService.findOne(outfitId);

        Detail outer = detailService.findOuter(outfitId);
        Detail top = detailService.findTop(outfitId);
        Detail pants = detailService.findPants(outfitId);
        Detail shoes = detailService.findShoes(outfitId);

        DetailDto outerDto;

        if(outer == null) outerDto = null;
        else outerDto = DetailDto.convert(outer);
        DetailDto topDto = DetailDto.convert(top);
        DetailDto pantsDto = DetailDto.convert(pants);
        DetailDto shoesDto = DetailDto.convert(shoes);

        return new DetailRequestDto(outfit.getImgUrl(), outerDto, topDto, pantsDto, shoesDto);
    }

    @PostMapping
    public void InsertDetail (@Valid @RequestPart InsertDetailDto request,
                              @RequestPart MultipartFile detailImg) {

        Outfit outfit = outfitService.findOne(request.getOutfitId());

        detailService.save(detailImg, request.getCategory(), outfit);
    }

    @GetMapping("/detail/{detailId}")
    public DetailResponseDto DetailOutfit (@PathVariable Long detailId) {
        Detail detail = detailService.findOne(detailId);
        String imgUrl = detail.getImgUrl();

        return new DetailResponseDto(imgUrl);
    }
}
