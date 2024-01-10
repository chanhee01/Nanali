package Nanali.domain.Member.repository;

import Nanali.domain.Member.model.MemberImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberImgRepository extends JpaRepository<MemberImg, Long> {

    Optional<MemberImg> findById(Long id);
}
