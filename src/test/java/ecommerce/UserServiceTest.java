package ecommerce;

import ecommerce.dao.Connector;
import ecommerce.dao.UserDAO;
import ecommerce.model.User;
import ecommerce.service.UserService;
import ecommerce.util.AccessLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class UserServiceTest {

    @BeforeEach
    public void setUp(){
        try(Connection connection = Connector.connect_test_env()){
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM users_test WHERE fullname='Minduka GG'");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Test
    public void userServiceTest(){
        UserService.TEST_ENVIRONMENT = true;

        UserService userService = new UserService();
        UserDAO userDAO = new UserDAO();

        Random random = new Random();
        String numeroRandom = String.valueOf(random.nextInt(1000000));

        User user = new User("Minduka GG", "minduCat"+numeroRandom+"@bol.com","gg123", AccessLevel.USER);

        Assertions.assertTrue(userService.createUser(user));

        User singleUser = userService.read(userDAO.getMaxId());
        Assertions.assertEquals(singleUser.getFullname(), user.getFullname());
        Assertions.assertEquals(singleUser.getEmail(), user.getEmail());

        List<User> userList = userService.list();
        Assertions.assertFalse(userList.isEmpty());
        Assertions.assertNotNull(userList);

        singleUser.setFullname("FullName service Updated");
        singleUser.setEmail("email_service"+numeroRandom+"@gmail.com");
        singleUser.setPassword("password service Updated");
        singleUser.setRole(String.valueOf(AccessLevel.MODERATOR));
        Assertions.assertTrue(userService.update(singleUser, singleUser.getId()));

        userService.delete(singleUser.getId());
        Assertions.assertNull(userService.read(singleUser.getId()));

        UserService.TEST_ENVIRONMENT = false;
    }

}
