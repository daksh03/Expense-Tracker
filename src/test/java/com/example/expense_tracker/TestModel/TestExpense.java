package com.example.expense_tracker.TestModel;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.expense_tracker.Model.Expense;

public class TestExpense {
    
    @Test
    void testExpense() {
        Expense expense = new Expense();
        expense.setId("1");
        expense.setUserId("1");
        expense.setAmount(245.31);
        expense.setCategory("health");
        expense.setDate(LocalDate.of(2025,01, 07));
        expense.setDescription("supplements");

        Assertions.assertEquals("1", expense.getId());
        Assertions.assertEquals("1", expense.getUserId());
        Assertions.assertEquals(245.31, expense.getAmount());
        Assertions.assertEquals("health", expense.getCategory());
        Assertions.assertEquals(LocalDate.of(2025, 01, 07), expense.getDate());
        Assertions.assertEquals("supplements", expense.getDescription());
    }
}
