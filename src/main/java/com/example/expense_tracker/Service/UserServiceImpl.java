package com.example.expense_tracker.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.Model.User;
import com.example.expense_tracker.Repository.UserRepository;

@Service


public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("User with this id exists");
        }
        Optional<User> newuser = userRepository.findByUsername(user.getUsername());
        if(newuser.isPresent()) {
            throw new IllegalArgumentException("User should have different username");
        }
        if(user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("User");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not found for id :"+id));
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found for id: " + id);
        }
        userRepository.deleteById(id);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
