package bank.management.system.dao;

import bank.management.system.Connector;
import bank.management.system.model.Transaction;

import java.util.Date;
import java.sql.SQLException;

public class TransactionDAO {
    private Connector connector;

    public TransactionDAO(Connector connector) {
        this.connector = connector;
    }

    public boolean deposit(String pin, String amount, Date date) {
        try {
            String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')";
            connector.statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean withdraw(String pin, String amount, Date date) {
        try {
            String query = ("insert into bank values('" + pin + "','" + date + "', 'Withdraw', '" + amount + "')");

            connector.statement.executeUpdate(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
