package bank.management.system.dao;

import bank.management.system.Connector;
import bank.management.system.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {
    private Connector connector;

    public TransactionDAO(Connector connector) {
        this.connector = connector;
    }

    public boolean deposit(String pin, int amount) {
        String query = "select * from bank where pin = '" + pin + "'";
        try {
            ResultSet res = connector.statement.executeQuery(query);
            if (res.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
