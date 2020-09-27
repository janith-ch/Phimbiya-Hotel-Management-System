package lk.hotelManagement.backend.service;

import lk.hotelManagement.backend.model.User;
import lk.hotelManagement.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> users() {
        return userRepository.users();
    }

    public boolean createUser(User user) {
        return userRepository.createUser(user);
    }

}
