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
    public DetailRequestDto details(@PathVariable Long outfitId) {
        Outfit outfit = outfitService.findOne(outfitId);

        Detail outer = detailService.findOuter(outfitId);
        Detail top = detailService.findTop(outfitId);
        Detail pants = detailService.findPants(outfitId);
        Detail shoes = detailService.findShoes(outfitId);

        GarmentDto outerDto = new GarmentDto(outer.getId(), outer.getImgUrl());
        GarmentDto topDto = new GarmentDto(top.getId(), top.getImgUrl());
        GarmentDto pantsDto = new GarmentDto(pants.getId(), pants.getImgUrl());
        GarmentDto shoesDto = new GarmentDto(shoes.getId(), shoes.getImgUrl());

        return new DetailRequestDto(outfit.getImgUrl(), outerDto, topDto, pantsDto, shoesDto);
    }

    @PostMapping
    public void InsertDetail (@RequestPart InsertDetailDto request,
                              @RequestPart MultipartFile detailImg) {

        Outfit outfit = outfitService.findOne(request.getOutfitId());

        detailService.save(detailImg, request.getCategory(), outfit);
    }

    @GetMapping("{outfitId}/{detailId}")
    public DetailGarmentResponseDto DetailOutfit (@PathVariable Long detailId) {
        Garment garment = garmentService.findById(detailId);
        String imgUrl = garment.getImgUrl();

        return new DetailGarmentResponseDto(imgUrl);
    }
}
