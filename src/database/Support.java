package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Support implements DatabaseObject {
    private int id_s;
    private String name_s;

    public Support(String name_s) {
        this.name_s = name_s;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_s) as max_id from support ");
            result.next();
            this.id_s = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Support(int id_s, String name_s) {
        this.id_s = id_s;
        this.name_s = name_s;
    }

    public int getId_s() {
        return id_s;
    }

    public String getName_s() {
        return name_s;
    }

    @Override
    public String toString() {
        return name_s;
    }

    public static List<Support> read() {
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

    public static Support read(int id_support) {
        Support temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from support where id_s = " + id_support);
            result.next();
            temp = (new Support(result.getInt("id_s"), result.getString("name_s")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO support(name_s) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.name_s);
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
