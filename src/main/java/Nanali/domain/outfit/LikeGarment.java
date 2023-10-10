package Nanali.domain.outfit;

import Nanali.domain.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class LikeGarment {

    @Id
    @GeneratedValue
    private Long id;

    private String imgName;

    private String imgUrl;

    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;
}
