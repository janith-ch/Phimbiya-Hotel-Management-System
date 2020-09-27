package lk.hotelManagement.backend.controller;

import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> users() {
        return userService.users();
    }

    @PostMapping("/")
    public boolean createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
