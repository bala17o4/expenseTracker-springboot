package com.project.expenseTracker.User;

import com.project.expenseTracker.Expense.ExpenseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Entity
@PropertySource("classpath:application.properties")
public class UserDTO {

    @Id
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()_+\\-={}\\[\\]|;:''<>,./?])(?=.*[a-zA-Z]).{8,}$", message = "Password must be at least 8 characters long with at least one uppercase letter, one lowercase letter, one special character, one number and not contain whitespace")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseDTO> expenses;

    public UserDTO() {
        this.expenses = new ArrayList<>();
    }

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ExpenseDTO> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpenseDTO> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(ExpenseDTO expense) {
        this.expenses.add(expense);

    }
}
