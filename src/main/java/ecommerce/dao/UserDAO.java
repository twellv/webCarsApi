package ecommerce.dao;

import ecommerce.model.User;
import ecommerce.service.UserService;
import ecommerce.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean createUser(User user){
        boolean savedUser = false;

        String query = UserService.TEST_ENVIRONMENT?
                "INSERT INTO users_test (fullname, email, password, role) VALUES (?, ?, ?, ?);":
                "INSERT INTO users (fullname, email, password, role) VALUES (?, ?, ?, ?);";

        try(Connection connection = UserService.TEST_ENVIRONMENT?Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, String.valueOf(user.getRole()));

            int i = preparedStatement.executeUpdate();
            savedUser = i > 0;
        } catch (SQLException ex){
            Logger.sendError("Error in createUser method:"+ex.getMessage());
        }
        return savedUser;
    }

    public List<User> listUsers() {
        List<User> listToReturn = new ArrayList<>();
        User user;

        String query = UserService.TEST_ENVIRONMENT?
                "SELECT id, fullname, email, password, role FROM users_test":
                "SELECT id, fullname, email, password, role FROM users";

        try(Connection connection = UserService.TEST_ENVIRONMENT?Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFullname(resultSet.getString("fullname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                listToReturn.add(user);
            }
        } catch(SQLException ex) {
            Logger.sendError("Error in listUsers method:"+ex.getMessage());
        }
        return  listToReturn;
    }

    public User read(long id){
        User user = null;

        String query = UserService.TEST_ENVIRONMENT?
                "SELECT id, fullname, email, password, role FROM users_test WHERE id='"+id+"';":
                "SELECT id, fullname, email, password, role FROM users WHERE id='"+id+"';";

        try(Connection connection = UserService.TEST_ENVIRONMENT?Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){

                if(resultSet.next()){
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setFullname(resultSet.getString("fullname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(resultSet.getString("role"));
                }
            } catch(SQLException ex) {
                Logger.sendError("Error in read method:"+ex.getMessage());
            }
        return user;
    }

    public long getMaxId() {
        String query = UserService.TEST_ENVIRONMENT?
            "SELECT id FROM users_test WHERE id=(SELECT max(id) FROM users_test);":
            "SELECT id FROM users WHERE id=(SELECT max(id) FROM users);";

        long id = 0;

        try(Connection connection = UserService.TEST_ENVIRONMENT?
            Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while(resultSet.next()) id = resultSet.getLong("id");
        } catch (SQLException ex) {
            Logger.sendError("Error in getMaxId method: " + ex.getMessage());
        }
        return id;
    }

    public boolean update(User user) {
        boolean isUpdated = false;

        String db = UserService.TEST_ENVIRONMENT? "users_test":"users";

        try(Connection connection = UserService.TEST_ENVIRONMENT?
                Connector.connect_test_env():Connector.connect()){
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE "+db+" SET "
                                +"fullname = ?, "
                                +"email = ?, "
                                +"password = ?, "
                                +"role = ? "
                                +"WHERE id = "+user.getId()+";");
                preparedStatement.setString(1, user.getFullname());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, String.valueOf(user.getRole()));

                int rowsAffected = preparedStatement.executeUpdate();
                isUpdated = rowsAffected > 0;

                preparedStatement.close();
            } catch (SQLException ex){
                Logger.sendError("Error in delete method:"+ex.getMessage());
            }
        return isUpdated;
    }

    public boolean delete(long id) {
        boolean isDeleted = false;

        String query = UserService.TEST_ENVIRONMENT?
            "DELETE FROM users_test WHERE id = ?;":"DELETE FROM users WHERE id = ?;";

        try(Connection connection = UserService.TEST_ENVIRONMENT?
            Connector.connect_test_env():Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            isDeleted = rowsAffected > 0;
        } catch(SQLException ex) {
            Logger.sendError("Error in delete method:"+ex.getMessage());
        }
        return isDeleted;
    }

}
