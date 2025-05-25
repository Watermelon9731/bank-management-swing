package bank.management.system.controller;

import bank.management.system.Connector;
import bank.management.system.dao.AccountDAO;
import bank.management.system.dao.TransactionDAO;

import java.util.Date;
import java.sql.SQLException;

public class TransactionController {
    private static Connector connector = new Connector();
    private static TransactionDAO transactionDAO = new TransactionDAO(connector);

    private static AccountDAO accountDAO = new AccountDAO(connector);

    public static boolean deposit(String pin, String amount) throws SQLException {
        if (transactionDAO == null) {
            return false;
        } else {
            try {
                Date time = new Date();
                Float.parseFloat(amount);
                boolean isDeposit = transactionDAO.deposit(pin, amount, time);
                return isDeposit;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    public static boolean withdraw(String pin, String amount) throws SQLException {
        if (transactionDAO == null) {
            return false;
        } else {
            System.out.println(amount);
            int intAmount = Integer.parseInt(amount);
            int balance = 0;
            try {
                 balance += accountDAO.getAccountBalance(pin);
                System.out.println(balance);
                if (balance >= 0 && balance > intAmount) {
                    try {
                        Date time = new Date();
                        boolean isSuccess = transactionDAO.withdraw(pin, amount, time);
                        return isSuccess;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
