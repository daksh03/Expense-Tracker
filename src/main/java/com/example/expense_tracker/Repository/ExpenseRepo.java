package com.example.expense_tracker.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.expense_tracker.Model.Expense;

public interface ExpenseRepo extends MongoRepository<Expense ,String>{
    List<Expense> findByUserId(String userId);

    @Query("{'userId': ?0, 'date': { $gte: ?1, $lte: ?2 }}")
    List<Expense> findByUserIdAndDateBetween(String userId, LocalDate startDate, LocalDate endDate);

    List<Expense> findByUserIdAndCategory(String userId,String category);

    List<Expense> findByUserIdAndCategoryAndDateBetween(String userId,String category,LocalDate startDate,LocalDate endDate);
    
}
