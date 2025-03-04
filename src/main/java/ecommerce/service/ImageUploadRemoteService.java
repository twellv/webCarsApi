package ecommerce.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;


public class ImageUploadRemoteService {

    private final Cloudinary cloudinary;
    ImageDatabaseService uploadDatabase = new ImageDatabaseService();

    public ImageUploadRemoteService() {
        Dotenv dotenv = Dotenv.load();
        this.cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
    }

    public ResponseEntity<String> uploadToBucket(MultipartFile file, String tittle, String alttext) {
        try {
            Map uploadParams = ObjectUtils.asMap(
                    "use_filename", true,
                    "unique_filename", false,
                    "overwrite", true
            );

            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            Map uploadResult = cloudinary.uploader().upload(tempFile, uploadParams);

            tempFile.delete();

            String publicId = (String) uploadResult.get("public_id");

            Map<String, Object> params = ObjectUtils.asMap("public_id", publicId);

            Map resource = cloudinary.api().resource(publicId, params);
            String imageUrl = (String) resource.get("url");

            if(uploadDatabase.saveImageDatabaseService(tittle, alttext, imageUrl)){
                System.out.println("image was saved.");
            } else {System.out.println("image was NOT saved.");}

            Map qualityParams = ObjectUtils.asMap("quality_analysis", true);

            Map qualityResult = cloudinary.api().resource(publicId, qualityParams);

            System.out.println("imageURL in service: "+imageUrl);
            System.out.println("publicId in service: "+publicId);

            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error during file processing: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error during upload: " + e.getMessage());
        }
    }

}
