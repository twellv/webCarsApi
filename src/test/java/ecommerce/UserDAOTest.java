package ecommerce;

import ecommerce.dao.Connector;
import ecommerce.dao.UserDAO;
import ecommerce.model.User;
import ecommerce.service.UserService;
import ecommerce.util.AccessLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class UserDAOTest {

    UserDAO userDAO = new UserDAO();

    @BeforeEach
    public void setUp(){
        try(Connection connection = Connector.connect_test_env()){
            PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM users_test WHERE fullname='Cashas full'");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Test
    @DisplayName("should get max id from Users table")
    public void shouldGetMaxIdF(){
        UserService.TEST_ENVIRONMENT = true;

        List<User> list = userDAO.listUsers();
        list.sort(Comparator.comparingLong(User::getId));

        User maxIdUser = list.get(list.size() - 1);
        Assertions.assertNotNull(maxIdUser);
        Assertions.assertEquals(maxIdUser.getId(), userDAO.getMaxId());

        UserService.TEST_ENVIRONMENT = false;
    }

    @Test
    public void shouldCreateADAOUser(){
        UserService.TEST_ENVIRONMENT = true;

        UserDAO userDAO = new UserDAO();

        Random random = new Random();
        String randomNumber = String.valueOf(random.nextInt(1000000));

        User user = new User("Cashas full", "myEmail"+randomNumber+"@gg.com","binhaNossa", AccessLevel.ADMIN);
        Assertions.assertTrue(userDAO.createUser(user));

        User singleUser = userDAO.read(userDAO.getMaxId());
        Assertions.assertEquals(singleUser.getFullname(), user.getFullname());

        List<User> userList = userDAO.listUsers();
        Assertions.assertFalse(userList.isEmpty());
        Assertions.assertNotNull(userList);

        singleUser.setFullname("FullName Updated");
        singleUser.setEmail("email"+randomNumber+"bol.com");
        singleUser.setPassword("password Updated");
        singleUser.setRole(String.valueOf(AccessLevel.SUPER_ADMIN));
        Assertions.assertTrue(userDAO.update(singleUser));

        userDAO.delete(singleUser.getId());
        Assertions.assertNull(userDAO.read(singleUser.getId()));

        UserService.TEST_ENVIRONMENT = false;
    }

}
