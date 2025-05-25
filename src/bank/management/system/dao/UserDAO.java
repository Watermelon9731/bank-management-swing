package bank.management.system.dao;

import bank.management.system.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void save(User user) throws SQLException;
    User findByFormId(String formId) throws SQLException;
    User findByCardNumberAndPin(String cardNumber, String pin) throws SQLException;
    void updatePassword(String formId, String newPassword) throws SQLException;
    boolean exists(String formId) throws SQLException;
    List<User> findAll() throws SQLException;
} 