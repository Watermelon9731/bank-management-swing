package bank.management.system.dao;

import bank.management.system.dao.impl.UserDAOImpl;
import bank.management.system.dao.impl.TransactionDAOImpl;

public class DAOFactory {
    private static DAOFactory instance;
    private final UserDAO userDAO;
    private final TransactionDAO transactionDAO;

    private DAOFactory() {
        userDAO = new UserDAOImpl();
        transactionDAO = new TransactionDAOImpl();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TransactionDAO getTransactionDAO() {
        return transactionDAO;
    }
} 