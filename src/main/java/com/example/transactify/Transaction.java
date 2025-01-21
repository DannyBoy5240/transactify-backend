package com.example.transactify;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String accountNumber;

    private BigDecimal amount;

    private String creditOrDebit; // Values: "CREDIT" or "DEBIT"

    // No-argument constructor (required for JPA or frameworks like Hibernate)
    public Transaction() {
    }

    // Constructor with arguments
    public Transaction(String accountNumber, BigDecimal amount, String creditOrDebit) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.creditOrDebit = creditOrDebit;
    }

    // Getters and Setters
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreditOrDebit() {
        return creditOrDebit;
    }

    public void setCreditOrDebit(String creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }
}
