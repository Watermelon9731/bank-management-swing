package bank.management.system.dao;

import bank.management.system.Connector;
import bank.management.system.model.Account;

import java.sql.*;

public class AccountDAO {
    private Connector connector;

    public AccountDAO(Connector connector) {
        this.connector = connector;
    }

    public Account findByCardNumber(String cardNumber) throws SQLException {
        String query = "select * from signup_third where card_number ='" + cardNumber + "' ";
        try {
            ResultSet rs = connector.statement.executeQuery(query);
            if (rs.next()) {
                return extractAccountFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Boolean login(String pin, String cardNumber) throws SQLException {
        String query = "select * from login where pin='" + pin + "' and card_number ='" + cardNumber + "'";
        try {
            ResultSet rs = connector.statement.executeQuery(query);
            if (rs.next()) {
                extractAccountFromResultSet(rs);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Integer getAccountBalance(String pin) throws SQLException {
        String query = "select * from bank where pin='" + pin + "'";
        try {
            ResultSet res = connector.statement.executeQuery(query);
            int balance = 0;
            while (res.next()) {
                if (res.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(res.getString("amount"));
                } else {
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }
            return balance;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Account extractAccountFromResultSet(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getString("form_id"));
        account.setCardNumber(rs.getString("card_number"));
        return account;
    }
}
