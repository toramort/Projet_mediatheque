package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Version implements DatabaseObject {
    private int id_v;
    private String version;

    public Version(String version) {
        this.version = version;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_v) as max_id from version ");
            result.next();
            this.id_v = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Version(int id_v, String version) {
        this.id_v = id_v;
        this.version = version;
    }

    public int getId_v() {
        return id_v;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return version;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO version(version) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.version);
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
