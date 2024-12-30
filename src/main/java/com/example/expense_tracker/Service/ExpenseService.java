package com.example.expense_tracker.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.expense_tracker.Model.Expense;

public interface ExpenseService {
    Expense addExpense(Expense expense);
    List<Expense> getExpensesbyUserId(String userId);
    List<Expense> getExpensesByDateRange(String userId,LocalDate starDate,LocalDate endDate);
    Expense updateExpense(String id, Expense expense);
    void deleteExpense(String id);
}
