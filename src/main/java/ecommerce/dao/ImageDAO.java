package ecommerce.dao;

import ecommerce.model.Car;
import ecommerce.model.Image;
import ecommerce.service.CarService;
import ecommerce.util.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageDAO {

    public Boolean saveImageInfoDAO(String tittle, String alttext, String url) {
        Boolean isSaved = false;

            try(Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO image"
                                + "(tittle, alttext, url)"
                                + "VALUES (?,?,?);")) {
                preparedStatement.setString(1, tittle);
                preparedStatement.setString(2, alttext);
                preparedStatement.setString(3, url);
                isSaved = preparedStatement.execute();
            } catch (SQLException ex) {
                Logger.sendError("Error in upload method:"+ex.getMessage());
            }
        return isSaved;
    }

    public Image getImageInfoDAO(String url){
        Image img = null;

        try(
            Connection connection = Connector.connect_test_env();
            PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT tittle, alttext, url FROM image WHERE url = ?;");
        ){
            preparedStatement.setString(1, url);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    img = new Image();
                    img.setTittle(resultSet.getString("tittle"));
                    img.setAlttext(resultSet.getString("alttext"));
                    img.setUrl(url);
                }
            }
        }catch (SQLException ex) {ex.printStackTrace();}
        return img;
    }

    public List<Image> getImageListDAO(){
        List<Image> imgList = new ArrayList<>();
        try(
            Connection connection = Connector.connect_test_env();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, tittle, alttext, url FROM image;"
            )
        ){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()) {
                    Image img = new Image();
                    img.setId(resultSet.getLong("id"));
                    img.setTittle(resultSet.getString("tittle"));
                    img.setAlttext(resultSet.getString("alttext"));
                    img.setUrl(resultSet.getString("url"));
                    imgList.add(img);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return imgList;
    }

}
