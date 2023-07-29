package ecommerce.dao;

import ecommerce.model.Car;
import ecommerce.model.Image;
import ecommerce.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {

    public static void create(Image image) {
        Logger.sendInfo("Image was created: "+image);

        Connection connection = Connector.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO image (imgurl, imgalt, title) VALUES (?, ?, ?);");
            preparedStatement.setString(1, image.getImgurl());
            preparedStatement.setString(2, image.getImgalt());
            preparedStatement.setString(3, image.getTitle());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in create image method : " + exception.getMessage());
        }
        Logger.sendInfo("... EXITING FROM IMAGE...");
    }

    public static List<Image> readAll(){
        List<Image> imageList = new ArrayList<>();

        try {
            Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM image;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Image image = new Image();
                image.setId(resultSet.getLong("image_id"));
                image.setImgurl(resultSet.getString("imgurl"));
                image.setImgalt(resultSet.getString("imgalt"));
                image.setTitle(resultSet.getString("title"));
                imageList.add(image);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in read all images method: " + exception.getMessage());
        }
        return imageList;
    }

    public static Image readById(long id) {
        Image image = null;
        Connection connection = Connector.connect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM image WHERE image.image_id = '"+id+"';");
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                image = new Image();
                image.setId(resultSet.getLong("image_id"));
                image.setImgurl(resultSet.getString("imgurl"));
                image.setImgalt(resultSet.getString("imgalt"));
                image.setTitle(resultSet.getString("title"));

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError(exception.getMessage());
        }
        return image;
    }

    public static long getMaxId() {

        String query =  "SELECT id FROM image WHERE id=(SELECT max(id) FROM image);";
        long id = 0;

        try {
            Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getLong("id");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            Logger.sendError("Error in image GET MAX id" + exception.getMessage());
        }
        return id;
    }

    public static boolean update(Image image) {
        Logger.sendInfo("...UPDATE IMAGE...");

        boolean isUpdated = false;

        Connection connection = Connector.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE image SET "
                            +"imgurl = ?, "
                            +"imgalt = ?, "
                            +"title = ? "
                            +"WHERE image_id = "+image.getId()+";");
            preparedStatement.setString(1, image.getImgurl());
            preparedStatement.setString(2, image.getImgalt());
            preparedStatement.setString(3, image.getTitle());


            int rowsAffected = preparedStatement.executeUpdate();
            isUpdated = rowsAffected > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        Logger.sendInfo("... EXITING UPDATE IMAGE ...");
        return isUpdated;
    }

    public static boolean delete(long id) {
        boolean isDeleted = false;

        Connection connection = Connector.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM image WHERE image_id = ?;");
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            isDeleted = rowsAffected > 0;

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return isDeleted;
    }

}
