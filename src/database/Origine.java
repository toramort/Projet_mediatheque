package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Origine implements DatabaseObject {

    private int id_o;
    private String name_o;

    public Origine(String name_o) {
        this.name_o = name_o;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_o) as max_id from origin ");
            result.next();
            this.id_o = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Origine(int id_o, String name_o) {
        this.name_o = name_o;
        this.id_o = id_o;
    }

    public String getName_o() {
        return name_o;
    }

    public int getId_o() {
        return id_o;
    }

    @Override
    public String toString() {
        return name_o;
    }

    public static List<Origine> read() {
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

    @Override
    public void create() {
        try {
            String query = "INSERT INTO origin(name_o) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.name_o);
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
