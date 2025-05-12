package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    Connection connect = null;
    public Connector() {
        try {
            connect = DriverManager.getConnection("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
