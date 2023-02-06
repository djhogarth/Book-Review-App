package com.bookreview.api.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User saveUserToDatabase(User u) {
       return userRepository.save(u);
    }

}
