package bank.management.system.model;

public class Transaction {
    private String pin;
    private String date;
    private String type;
    private String amount;

    public Transaction(String pin, String date, String type, String amount) {
        this.pin = pin;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    // Getters and Setters
    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
} 