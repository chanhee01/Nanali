package Nanali.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController { // 서버 켜져있는지 확인용 컨트롤러

    @GetMapping("/")
    public String home() {
        return "ok";
    }
}
