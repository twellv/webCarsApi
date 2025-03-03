package ecommerce.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ecommerce.dao.ImageDAO;
import ecommerce.model.Image;

import java.util.List;
import java.util.Map;

public class ImageDatabaseService {

    private Cloudinary cloudinary;

    public Boolean saveImageInfoDatabase(String tittle, String alttext, String url){
        ImageDAO img = new ImageDAO();
        Boolean isSaved = img.saveImageInfoDAO(tittle, alttext, url);
        return isSaved;
    }

    public List<Image> getListImageInfoDatabase() {
        ImageDAO imgDAO = new ImageDAO();
        return imgDAO.getImageListDAO();
    }

}
