package bank.management.system.model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private String id;
    private String cardNumber;
    private String balance;
    private String accountType;

    public Account() {
    }

    public Account(String id, String cardNumber, String balance
    ) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String accountNumber) {
        this.cardNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
