package com.example.expense_tracker.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private String userId;
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
}
