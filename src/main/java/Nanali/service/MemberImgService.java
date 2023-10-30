package Nanali.service;

import Nanali.domain.Member.Member;
import Nanali.domain.Member.MemberImg;
import Nanali.repository.MemberImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberImgService {

    private final MemberService memberService;

    private final MemberImgRepository memberImgRepository;

    private final S3FileService s3FileService;

    @Transactional
    public void saveImg(Member member, MultipartFile imgInMember) throws Exception{

        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(imgInMember, "memberImg");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;
        MemberImg memberImg = new MemberImg(imgName, imgUrl);

        memberImgRepository.save(memberImg);
    }

    public MemberImg findMemberImg(Member member) {
        MemberImg memberImg = memberImgRepository.findById(member.getId()).orElseThrow(() -> new IllegalArgumentException());

        return memberImg;
    }

    @Transactional
    public void updateMemberImg(Member member, MultipartFile imgInMember) throws Exception {
        MemberImg memberImg = findMemberImg(member);

        s3FileService.deleteImage(memberImg.getImgName());

        String memberImgName = imgInMember.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(imgInMember, "memberImg");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;

        memberImg.update_memberImg(imgName, imgUrl);
    }
}
