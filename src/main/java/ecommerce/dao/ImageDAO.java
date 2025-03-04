package ecommerce.dao;

import ecommerce.model.Image;
import ecommerce.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {

    public Boolean saveImageDAO(String tittle, String alttext, String url) {
        Boolean isSaved = false;

            try(Connection connection = Connector.connect_test_env();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO image"
                                + "(tittle, alttext, url)"
                                + "VALUES (?,?,?);")) {
                preparedStatement.setString(1, tittle);
                preparedStatement.setString(2, alttext);
                preparedStatement.setString(3, url);
                int rowsAffected = preparedStatement.executeUpdate();
                isSaved = rowsAffected > 0;
            } catch (SQLException e) {
                Logger.sendError("Error in upload DAO:"+e.getMessage());
            }
        System.out.println("Boolean in DAO method");
        return isSaved;
    }

    public Image getImageDAO(String url){
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
        }catch (SQLException e) {e.printStackTrace();}
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return imgList;
    }

    public void updateImageDAO(){
        // resgatar uma imagem {metodo get através da URL?}
    }

}
