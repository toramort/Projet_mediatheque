package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class DBMaster {
    private static Connection conn;

    public DBMaster(String driver, String url, String user, String passwd) {

        conn = null;
        try {
            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection to database failed", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static List<Categorie> readCategorie() {
        List<Categorie> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from categorie");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Categorie(result.getInt("id_c"), result.getString("name_c")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static Connection getConn() {
        return conn;
    }
}
