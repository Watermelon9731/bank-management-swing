package bank.management.system.dao;

import bank.management.system.model.Transaction;
import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    void save(Transaction transaction) throws SQLException;
    List<Transaction> findByPin(String pin) throws SQLException;
    int getBalance(String pin) throws SQLException;
    void updatePin(String oldPin, String newPin) throws SQLException;
} 