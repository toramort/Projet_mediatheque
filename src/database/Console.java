package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Console implements DatabaseObject {

    private int id_c;
    private String name_c;

    public Console(String name_c) {
        this.name_c = name_c;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_c) as max_id from console ");
            result.next();
            this.id_c = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Console(int id_c, String name_c) {
        this.id_c = id_c;
        this.name_c = name_c;
    }

    public static List<Console> read() {
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

    public static Console read(int id_console) {
        Console temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from console where id_c = " + id_console);
            result.next();
            temp = (new Console(result.getInt("id_c"), result.getString("name_c")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO console(name_c) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name_c);
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

    int getId_c() {
        return id_c;
    }

    public String getName_c() {
        return name_c;
    }

    @Override
    public String toString() {
        return name_c;
    }

}
