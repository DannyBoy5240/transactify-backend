package com.example.transactify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/{accountNumber}")
    public AccountResponse getTransactions(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountNumber(accountNumber);
        BigDecimal balance = transactionService.calculateBalance(accountNumber);
        return new AccountResponse(transactions, balance);
    }
}

class AccountResponse {
    private List<Transaction> transactions;
    private BigDecimal balance;

    public AccountResponse(List<Transaction> transactions, BigDecimal balance) {
        this.transactions = transactions;
        this.balance = balance;
    }

    // Getters and Setters
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}