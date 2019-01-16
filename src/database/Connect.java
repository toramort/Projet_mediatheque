package database;

import javax.swing.*;
import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

public class Connect {
    private static Connection conn;

    public static void setup(String url, String user, String passwd) {

        conn = null;
        try {
            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection to database failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
