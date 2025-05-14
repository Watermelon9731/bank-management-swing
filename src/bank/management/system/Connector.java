package bank.management.system;

import java.sql.*;

public class Connector {
    Connection connect = null;
    Statement statement = null;

    public Connector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingSystem", "root", "Mysql12312345#");
            statement = connect.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
