package ecommerce.controller;

import ecommerce.model.User;
import ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService = new UserService();

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        boolean verified = userService.createUser(user);

        return verified ?
            ResponseEntity.status(HttpStatus.OK).build():
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> usersList() {
        List<User> list = userService.list();


        return (list == null || list.isEmpty() )?
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build():
            ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> usersById(@PathVariable long id) {
        User readed = userService.read(id);

        return readed == null?
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
            ResponseEntity.status(HttpStatus.OK).body(readed);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable long id) {
        boolean verifyUpdate = userService.update(user, id);

        return !verifyUpdate?
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
            ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean verifyDeletion = userService.delete(id);

        return !verifyDeletion?
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
            ResponseEntity.status(HttpStatus.OK).build();
    }

}
