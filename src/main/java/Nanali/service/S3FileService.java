package Nanali.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3FileService {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    // upload(multipartFile, "folderName")로 호출해서 해당 폴더에 들어가도록 설정

    @Transactional
    public Map<String, String> upload(MultipartFile multipartFile, String folderName) {

        try {
            String s3FileName = folderName + "/" + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentType("image/jpeg");
            objMeta.setContentLength(multipartFile.getSize());
            objMeta.setContentDisposition("inline");

            amazonS3.putObject(bucket, folderName + "/" + s3FileName, multipartFile.getInputStream(), objMeta);

            String s3Url = amazonS3.getUrl(bucket, s3FileName).toString();

            Map<String, String> result = new HashMap<>();
            result.put("s3FileName", s3FileName);
            result.put("s3Url", s3Url);

            return result;
        } catch (Exception e) {
            log.error("파일 업로드 중 오류 발생: " + e.getMessage());
            throw new RuntimeException("파일 업로드 중 오류 발생", e);
        }

    }

    @Transactional
    public void deleteImage(String fileName) {
        log.info("Deleting file: {}", fileName);
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
    }
}
