package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Genre implements DatabaseObject {

    private int id_g;
    private String genre;

    public Genre(String genre) {
        this.genre = genre;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_g) as max_id from genre ");
            result.next();
            this.id_g = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Genre(int id_g, String genre) {
        this.id_g = id_g;
        this.genre = genre;
    }

    public int getId_g() {
        return id_g;
    }

    @Override
    public String toString() {
        return genre;
    }

    public static List<Genre> read() {
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

    public static Genre read(int id_genre) {
        Genre temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from genre WHERE id_g = " + id_genre);
            result.next();
            temp = (new Genre(result.getInt("id_g"), result.getString("genre")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO genre(genre) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.genre);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
