package com.example.expense_tracker.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.expense_tracker.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    
}
