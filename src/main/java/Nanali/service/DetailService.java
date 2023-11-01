package Nanali.service;

import Nanali.domain.cody.cloth.detail.Detail;
import Nanali.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DetailService {

    private final DetailRepository detailRepository;

    @Transactional()
    public Long save(Detail detail) {
        Detail saved = detailRepository.save(detail);
        return saved.getId();
    }

    public Detail findOuter(Long id) {
        Detail outer = detailRepository.findOuter(id);
        return outer;
    }

    public Detail findTop(Long id) {
        Detail outer = detailRepository.findTop(id);
        return outer;
    }

    public Detail findPants(Long id) {
        Detail outer = detailRepository.findPants(id);
        return outer;
    }

    public Detail findShoes(Long id) {
        Detail outer = detailRepository.findShoes(id);
        return outer;
    }
}
