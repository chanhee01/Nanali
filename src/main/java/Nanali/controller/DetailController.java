package Nanali.controller;

import Nanali.domain.cody.cloth.Garment;
import Nanali.domain.cody.cloth.Outfit;
import Nanali.domain.cody.cloth.detail.Detail;
import Nanali.dtos.detail.DetailGarmentResponseDto;
import Nanali.dtos.detail.InsertDetailDto;
import Nanali.dtos.garment.GarmentDto;
import Nanali.dtos.detail.DetailRequestDto;
import Nanali.service.DetailService;
import Nanali.service.GarmentService;
import Nanali.service.OutfitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/detail")
public class DetailController {

    //garment id 받아서 보여주는 코드
    private final OutfitService outfitService;
    private final DetailService detailService;
    private final GarmentService garmentService;

    @GetMapping("/{outfitId}")
    public DetailRequestDto details(@PathVariable("outfitId") Long id) {
        Outfit outfit = outfitService.findOne(id);

        Detail outer = detailService.findOuter(id);
        Detail top = detailService.findTop(id);
        Detail pants = detailService.findPants(id);
        Detail shoes = detailService.findShoes(id);

        GarmentDto outerDto = new GarmentDto(outer.getId(), outer.getImgUrl());
        GarmentDto topDto = new GarmentDto(top.getId(), top.getImgUrl());
        GarmentDto pantsDto = new GarmentDto(pants.getId(), pants.getImgUrl());
        GarmentDto shoesDto = new GarmentDto(shoes.getId(), shoes.getImgUrl());

        return new DetailRequestDto(outfit.getImgUrl(), outerDto, topDto, pantsDto, shoesDto);
    }

    @PostMapping
    public void InsertDetail (@RequestPart(value = "detail") InsertDetailDto request,
                              @RequestPart(value = "detailImg") MultipartFile outfitImg) {

        Outfit outfit = outfitService.findOne(request.getOutfitId());

        detailService.save(outfitImg, request.getCategory(), outfit);
    }

    @GetMapping("{outfitId}/{detailId}")
    public DetailGarmentResponseDto DetailOutfit (@PathVariable("detailId") Long id) {
        Garment garment = garmentService.findById(id);
        String imgUrl = garment.getImgUrl();

        return new DetailGarmentResponseDto(imgUrl);
    }
}
