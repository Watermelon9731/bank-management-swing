package bank.management.system.controller;

import bank.management.system.Connector;
import bank.management.system.model.Account;
import bank.management.system.dao.TransactionDAO;

import java.sql.SQLException;

public class TransactionController {
    private static Connector connector = new Connector();
    private static TransactionDAO transactionDAO = new TransactionDAO(connector);

    public static boolean deposit(String pin, String amount) throws SQLException {
        if (transactionDAO == null) {
            return false;
        } else {
            try {
            int intAmount = Integer.parseInt(amount);
            boolean isDeposit = transactionDAO.deposit(pin, intAmount);
            } catch (NumberFormatException e) {
                return false;
            }
            return false;
        }
    }
}
