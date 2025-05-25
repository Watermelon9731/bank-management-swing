package bank.management.system.dao.impl;

import bank.management.system.Connector;
import bank.management.system.dao.UserDAO;
import bank.management.system.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connector connector;

    public UserDAOImpl() {
        this.connector = new Connector();
    }

    @Override
    public void save(User user) throws SQLException {
        String query = "INSERT INTO signup VALUES ('" + 
            user.getFormId() + "', '" + 
            user.getName() + "', '" + 
            user.getAccount() + "', '" + 
            user.getDob() + "', '" + 
            user.getGender() + "', '" + 
            user.getEmail() + "', '" + 
            user.getMaritalStatus() + "', '" + 
            user.getAddress() + "', '" + 
            user.getCity() + "', '" + 
            user.getProvince() + "', '" + 
            user.getPassword() + "')";
        
        connector.statement.executeUpdate(query);
    }

    @Override
    public User findByFormId(String formId) throws SQLException {
        String query = "SELECT * FROM signup WHERE form_id = '" + formId + "'";
        ResultSet rs = connector.statement.executeQuery(query);
        
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        return null;
    }

    @Override
    public User findByCardNumberAndPin(String cardNumber, String pin) throws SQLException {
        String query = "SELECT s.* FROM signup s " +
                      "JOIN login l ON s.form_id = l.form_id " +
                      "WHERE l.card_number = '" + cardNumber + "' AND l.pin = '" + pin + "'";
        ResultSet rs = connector.statement.executeQuery(query);
        
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        return null;
    }

    @Override
    public void updatePassword(String formId, String newPassword) throws SQLException {
        String query = "UPDATE signup SET password = '" + newPassword + "' WHERE form_id = '" + formId + "'";
        connector.statement.executeUpdate(query);
    }

    @Override
    public boolean exists(String formId) throws SQLException {
        String query = "SELECT 1 FROM signup WHERE form_id = '" + formId + "'";
        ResultSet rs = connector.statement.executeQuery(query);
        return rs.next();
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM signup";
        ResultSet rs = connector.statement.executeQuery(query);
        
        while (rs.next()) {
            users.add(extractUserFromResultSet(rs));
        }
        return users;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(
            rs.getString("form_id"),
            rs.getString("name"),
            rs.getString("account"),
            rs.getString("dob"),
            rs.getString("gender"),
            rs.getString("email"),
            rs.getString("marital_status"),
            rs.getString("address"),
            rs.getString("city"),
            rs.getString("province"),
            rs.getString("password")
        );
    }
} 