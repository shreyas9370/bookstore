package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.User;
import com.bookstore.bookstore.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public User signUp(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exist");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already Exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
