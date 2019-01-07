package GUI;

import javax.swing.*;
import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

class ConnectionDB {
    private static Connection conn;

    protected ConnectionDB(String driver, String url, String user, String passwd) {

        conn = null;
        try {
            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection to database failed", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static Connection getConn() {
        return conn;
    }
}
