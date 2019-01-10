package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Master {
    private static Connection conn;

    public Master(String driver, String url, String user, String passwd) {

        conn = null;
        try {
            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection to database failed", "Error", JOptionPane.ERROR_MESSAGE);
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

    public static List<Origine> readOrigin() {
        List<Origine> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from origin");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Origine(result.getInt("id_o"), result.getString("name_o")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Support> readSupport() {
        List<Support> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from support");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Support(result.getInt("id_s"), result.getString("name_s")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Version> readVersion() {
        List<Version> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from version");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Version(result.getInt("id_v"), result.getString("version")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Personality> readPersonality() {
        List<Personality> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT personality.id_p, personality.firstname, personality.lastname, personality.surname, " +
                "job.id_job, job.name_job from personality, job " +
                "inner join job_personality jp on job.id_job = jp.id_job " +
                "inner join personality p on jp.id_p = p.id_p");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Personality(result.getInt("id_p"), result.getString("firstname"), result.getString("lastname"), result.getString("surname"),
                    new Job(result.getInt("id_job"), result.getString("name_job"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Job> readJobs() {
        List<Job> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from job");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Job(result.getInt("id_job"), result.getString("name_job")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Genre> readGenres() {
        List<Genre> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from genre");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Genre(result.getInt("id_g"), result.getString("genre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static List<Console> readConsole() {
        List<Console> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from console");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Console(result.getInt("id_c"), result.getString("name_c")));
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
