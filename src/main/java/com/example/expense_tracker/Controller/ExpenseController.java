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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.Model.Expense;
import com.example.expense_tracker.Service.ExpenseService;

@RestController
@RequestMapping("/api")
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
    System.out.println("UserId: " + userId);
    System.out.println("StartDate: " + startDate);
    System.out.println("EndDate: " + endDate);

    List<Expense> expenses = expenseService.getExpensesByDateRange(userId, LocalDate.parse(startDate), LocalDate.parse(endDate));
    System.out.println("Expenses Found: " + expenses);

    return expenses;
}


    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/category/{userId}/{category}")
    public List<Expense> GetbyUserIDAndCategory(@PathVariable String userId,@PathVariable String category) {
        return expenseService.getExpensesByUserIdAndCategory(userId, category);
    }

    @GetMapping("/datebetween/{userId}/{category}/{startDate}/{endDate}")
    public List<Expense> GetByUserIdAndCategoryAndDateBetween(@PathVariable String userId,@PathVariable String category,@PathVariable String startDate, @PathVariable String endDate) {
        return expenseService.getExpensesByUserIdAndCategoryAndDateRange(userId, category, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
    
}
