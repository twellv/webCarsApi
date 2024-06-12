package ecommerce.service;

import ecommerce.dao.UserDAO;
import ecommerce.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static boolean TEST_ENVIRONMENT = false;

    UserDAO userDAO = new UserDAO();

    public boolean createUser(User user){
        User newUser;
        boolean isCreated = false;

        if (user != null) {
            newUser = new User();
            newUser.setFullname(user.getFullname());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setRole(String.valueOf(user.getRole()));
            isCreated = userDAO.createUser(newUser);
        }

        return isCreated;
    }

    public List<User> list(){
        List<User> userResponseList = new ArrayList<>();

        for(User c : userDAO.listUsers()) {
            User user1 = new User();
            user1.setId(c.getId());
            user1.setFullname(c.getFullname());
            user1.setEmail(c.getEmail());
            user1.setPassword(c.getPassword());
            user1.setRole(String.valueOf(c.getRole()));
            userResponseList.add(user1);
        }
        return userResponseList;
    }

    public User read(Long id){
        return userDAO.read(id);
    }

    public boolean update(User user, long id){
        User oldUser = new UserDAO().read(id);
        boolean isUpdated = false;

        if(oldUser != null) {
            oldUser.setFullname(user.getFullname());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(String.valueOf(user.getRole()));
            isUpdated = userDAO.update(oldUser);
        }
        return isUpdated;
    }

    public boolean delete(long id) {
        return userDAO.delete(id);
    }

}
