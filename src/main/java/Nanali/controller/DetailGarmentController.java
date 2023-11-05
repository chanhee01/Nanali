package Nanali.controller;

import Nanali.dtos.DetailOutfit.DetailGarmentRequestDto;
import Nanali.dtos.DetailOutfit.DetailGarmentResponseDto;
import Nanali.service.DetailGarmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class DetailGarmentController {

    //garment id 받아서 보여주는 코드
    private final DetailGarmentService detailGarmentService;

    @GetMapping
    public DetailGarmentResponseDto DetailOutfit (@RequestBody DetailGarmentRequestDto request) {
        String imgUrl = detailGarmentService.findUrl(request.getId());

        return new DetailGarmentResponseDto(imgUrl);
    }
}
