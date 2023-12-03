package com.project.expenseTracker.Expense;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class ExpenseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String expenseName;


    @NotBlank
    private String category;

    @NotNull(message = "Amount cannot be empty")
    @Min(value = 0, message = "Amount must be a positive value")
    private Double amount;

    private LocalDate date;

    private String comments;


    public ExpenseDTO() {}

    public ExpenseDTO(String expenseName, String category, Double amount, LocalDate date){
//        this.id = id;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;

        if (date == null) {
            this.date = LocalDate.now();
        }else{
            this.date = date;
        }
    }

    public ExpenseDTO( String expenseName,String category, Double amount,LocalDate date, String comments) {
//        this.id = id;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
        if (date == null) {
            this.date = LocalDate.now();
        }else{
            this.date = date;
        }
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "id=" + id +
                ", expenseName='" + expenseName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", comments='" + comments + '\'' +
                '}';
    }
}
