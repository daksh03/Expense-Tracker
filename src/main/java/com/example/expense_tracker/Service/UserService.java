package com.example.expense_tracker.Service;

import java.util.List;

import com.example.expense_tracker.Model.User;

public interface UserService {

    User registerUser(User user);

    User getUserById(String id);

    void deleteUser(String id);
    
    List<User> getAllUsers();

    String verify(User user);
    
}
