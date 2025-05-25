package bank.management.system.controller;

import bank.management.system.Connector;
import bank.management.system.model.Account;
import bank.management.system.dao.AccountDAO;

import java.sql.SQLException;

public class AccountController {
    private static Connector connector = new Connector();
    private static AccountDAO accountDAO = new AccountDAO(connector);

    public static Account getAccountByCardNumber(String accountNumber) throws SQLException {
        System.out.println(accountDAO);
        if (accountDAO == null) {
            return new Account();
        }
        Account account = accountDAO.findByCardNumber(accountNumber);
        return account;
    }

    public static Boolean login(String pinHash, String cardNumber) throws SQLException {
        if (accountDAO == null) {
            return false;
        } else {
            Boolean isLogin = accountDAO.login(pinHash, cardNumber);
            return isLogin;
        }
    }

    public static int getAccountBalance(String pinCode) throws SQLException {
        if (accountDAO == null) {
            return 0;
        } else {
            int accountBalance = accountDAO.getAccountBalance(pinCode);
            return accountBalance;
        }
    }
}
