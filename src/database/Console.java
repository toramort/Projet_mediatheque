package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public Console(int id_c, String name_c) {
        this.id_c = id_c;
        this.name_c = name_c;
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

    public int getId_c() {
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
