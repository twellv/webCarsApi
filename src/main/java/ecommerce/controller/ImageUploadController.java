package ecommerce.controller;

import ecommerce.model.Image;
import ecommerce.service.ImageDatabaseService;
import ecommerce.service.ImageUploadRemoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageUploadController {

    @RequestMapping("/upload")
    public ResponseEntity<String> uploadController(MultipartFile file, String tittle, String alttext) {
        ImageUploadRemoteService upload = new ImageUploadRemoteService();
        return upload.uploadToBucket(file, tittle, alttext);
    }

    @RequestMapping("/list")
    public List<Image> getListImagesController(){
        ImageDatabaseService img = new ImageDatabaseService();
        return img.getListImageDatabaseService();
    }
}
