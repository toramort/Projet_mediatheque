package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Personality implements DatabaseObject {

    private int id_personality;
    private String firstname;
    private String lastname;
    private String surname;
    private List<Job> jobs; //checkbox jobs boite de dialogue

    public Personality(String firstname, String lastname, String surname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_p) as max_id from personality ");
            result.next();
            this.id_personality = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Personality(int id_personality, String firstname, String lastname, String surname) {
        this.id_personality = id_personality;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
    }

    public Personality(int id_personality, String firstname, String lastname, String surname, List<Job> jobs) {
        this.id_personality = id_personality;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.jobs = jobs;
    }

    public int getId_personality() {
        return id_personality;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurname() {
        return surname;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO personality(firstname, lastname, surname) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.firstname);
            statement.setString(2, this.lastname);
            statement.setString(3, this.surname);
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
        return this.firstname + " " + this.lastname + " " + this.surname;
    }
}
