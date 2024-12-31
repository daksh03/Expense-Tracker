package com.example.expense_tracker.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.Model.Expense;
import com.example.expense_tracker.Repository.ExpenseRepo;

@Service

public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepo expenseRepo;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public List<Expense> getExpensesbyUserId(String userId) {
        return expenseRepo.findByUserId(userId);
    }

    public List<Expense> getExpensesByDateRange(String userId, LocalDate startDate, LocalDate endDate) {
        System.out.println("Querying for UserId: " + userId + ", StartDate: " + startDate + ", EndDate: " + endDate);
        List<Expense> expenses = expenseRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
        System.out.println("Expenses Returned: " + expenses);
        return expenses;
    }

    @Override
    public Expense updateExpense(String id,Expense expense) {
        Expense existingExpense = expenseRepo.findById(id)
                            .orElseThrow(()-> new RuntimeException("Expense not found with id :"+id));
                existingExpense.setAmount(expense.getAmount());
                existingExpense.setCategory(expense.getCategory());
                existingExpense.setDescription(expense.getDescription());
                existingExpense.setDate(expense.getDate());
        return expenseRepo.save(existingExpense);
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepo.deleteById(id);
    }
    
    @Override
    public List<Expense> getExpensesByUserIdAndCategory(String userId, String category) {
        return expenseRepo.findByUserIdAndCategory( userId, category);
    }

    @Override
    public List<Expense> getExpensesByUserIdAndCategoryAndDateRange(String userId, String category, LocalDate startDate, LocalDate endDate) {
        return expenseRepo.findByUserIdAndCategoryAndDateBetween( userId, category,startDate,endDate);
    }
}
