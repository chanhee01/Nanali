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
    public MemberImg saveImg(MultipartFile imgInMember, Member member) {

        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(imgInMember, "memberImg");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;
        MemberImg memberImg = new MemberImg(imgName, imgUrl, member);

        MemberImg savedImg = memberImgRepository.save(memberImg);
        return savedImg;
    }

    public MemberImg findMemberImg(Member member) {
        MemberImg memberImg = memberImgRepository.findById(member.getId()).orElseThrow(() -> new IllegalArgumentException());

        return memberImg;
    }

    public MemberImg findById(Long id) {
        MemberImg memberImg = memberImgRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return memberImg;
    }

    @Transactional
    public void updateImg(MultipartFile MemberImg, Long memberImgId) {
        // 기존 이미지 삭제
        MemberImg memberImg = findById(memberImgId);
        s3FileService.deleteImage(memberImg.getImgName());

        String imgName = "";
        String imgUrl = "";
        Map<String, String> result = s3FileService.upload(MemberImg, "memberImg");
        String s3FileName = result.get("s3FileName");
        String s3Url = result.get("s3Url");
        imgName = s3FileName;
        imgUrl = s3Url;

        memberImg.update_memberImg(imgName, imgUrl);
    }
}
