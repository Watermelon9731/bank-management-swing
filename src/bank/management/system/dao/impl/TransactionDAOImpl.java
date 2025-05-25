package bank.management.system.dao.impl;

import bank.management.system.Connector;
import bank.management.system.dao.TransactionDAO;
import bank.management.system.model.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    private final Connector connector;

    public TransactionDAOImpl() {
        this.connector = new Connector();
    }

    @Override
    public void save(Transaction transaction) throws SQLException {
        String query = "INSERT INTO bank VALUES ('" +
            transaction.getPin() + "', '" +
            transaction.getDate() + "', '" +
            transaction.getType() + "', '" +
            transaction.getAmount() + "')";
        
        connector.statement.executeUpdate(query);
    }

    @Override
    public List<Transaction> findByPin(String pin) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM bank WHERE pin = '" + pin + "'";
        ResultSet rs = connector.statement.executeQuery(query);
        
        while (rs.next()) {
            transactions.add(extractTransactionFromResultSet(rs));
        }
        return transactions;
    }

    @Override
    public int getBalance(String pin) throws SQLException {
        int balance = 0;
        List<Transaction> transactions = findByPin(pin);
        
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("Deposit")) {
                balance += Integer.parseInt(transaction.getAmount());
            } else {
                balance -= Integer.parseInt(transaction.getAmount());
            }
        }
        return balance;
    }

    @Override
    public void updatePin(String oldPin, String newPin) throws SQLException {
        String query = "UPDATE bank SET pin = '" + newPin + "' WHERE pin = '" + oldPin + "'";
        connector.statement.executeUpdate(query);
    }

    private Transaction extractTransactionFromResultSet(ResultSet rs) throws SQLException {
        return new Transaction(
            rs.getString("pin"),
            rs.getString("date"),
            rs.getString("type"),
            rs.getString("amount")
        );
    }
} 