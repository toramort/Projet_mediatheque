package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Job implements DatabaseObject {

    private String name_job;
    private int id_job;

    public Job(String name_job) {
        this.name_job = name_job;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_job) as max_id from job ");
            result.next();
            this.id_job = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Job(int id_job, String name_job) {
        this.name_job = name_job;
        this.id_job = id_job;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO job(name_job) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.name_job);
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

    @Override
    public String toString() {
        return name_job;
    }
}
