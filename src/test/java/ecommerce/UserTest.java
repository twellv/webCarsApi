package ecommerce;

import ecommerce.model.Car;
import ecommerce.model.User;
import ecommerce.service.UserService;
import ecommerce.util.AccessLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UserTest {

    @Test
    void userModelTest(){

        Random random = new Random();
        String number = String.valueOf(random.nextInt());

        User user = new User();
        user.setFullname("illidaren");
        user.setEmail("ilidarenEU"+number+"@gmail.com");
        user.setPassword("eu123");
        user.setRole("MODERATOR");

        Assertions.assertNotNull(user);
        Assertions.assertEquals("illidaren", user.getFullname());
        Assertions.assertEquals("ilidarenEU"+number+"@gmail.com", user.getEmail() );
        Assertions.assertEquals("eu123", user.getPassword() );
        Assertions.assertEquals(AccessLevel.MODERATOR, user.getRole() );
    }
}
