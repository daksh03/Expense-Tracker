package com.example.expense_tracker.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document(collection = "users")
public class User {
    public User(String id, String username, String role, String email, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
    }
    public User() {
        //TODO Auto-generated constructor stub
    }
    @Id
    private String id;
    private String username;
    private String role;
    private String email;
    private String password;
}
