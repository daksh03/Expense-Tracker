package com.example.expense_tracker.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.Model.Expense;
import com.example.expense_tracker.Service.ExpenseService;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/addExpense")
    public Expense Addexpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/{userId}")
    public List<Expense> getExpensebyuserId(@PathVariable String userId) {
        return expenseService.getExpensesbyUserId(userId);
    }

    @GetMapping("/{userId}/{startDate}/{endDate}")
    public List<Expense> GetExpensesByDateRange(@PathVariable String userId, @PathVariable String startDate, @PathVariable String endDate) {
        return expenseService.getExpensesByDateRange(userId,LocalDate.parse(startDate),LocalDate.parse(endDate));
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }
    
}
