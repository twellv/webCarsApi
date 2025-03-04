package ecommerce.service;

import com.cloudinary.Cloudinary;
import ecommerce.dao.ImageDAO;
import ecommerce.model.Image;

import java.util.List;

public class ImageDatabaseService {

    private Cloudinary cloudinary;

    public Boolean saveImageDatabaseService(String tittle, String alttext, String url){
        ImageDAO img = new ImageDAO();


        System.out.println("Boolean in SERVICE method");

        return img.saveImageDAO(tittle, alttext, url);
    }

    public List<Image> getListImageDatabaseService() {
        ImageDAO imgDAO = new ImageDAO();
        return imgDAO.getImageListDAO();
    }

}
