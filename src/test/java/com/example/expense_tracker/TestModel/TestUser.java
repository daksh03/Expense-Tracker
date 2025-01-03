package com.example.expense_tracker.TestModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.expense_tracker.Model.User;

public class TestUser {
    

    @Test

    void testUser() {
        User user = new User();
        user.setId("1");
        user.setUsername("daksh07");
        user.setEmail("Daksh@rediffmail.com");
        user.setPassword("2435axcqw34");
        
        Assertions.assertEquals("1", user.getId());
        Assertions.assertEquals("daksh07", user.getUsername());
        Assertions.assertEquals("Daksh@rediffmail.com", user.getEmail());
        Assertions.assertEquals("2435axcqw34", user.getPassword());
    }
}
