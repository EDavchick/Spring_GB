package com.dav.lection04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private boolean usersAdded = false;

    public List<User> getAllUsers(){
        if (!usersAdded) {
            userRepository.save(new User(null, "Elena", "qwwer@ga.com"));
            userRepository.save(new User(null, "John", "trew@ga.com"));
            userRepository.save(new User(null, "Marta", "nasfg@ga.com"));
            usersAdded = true;
        }

        return userRepository.findAll();
    }

    public User getUserByID(Long id) {
        return userRepository.findById(id).get();
    }

}
