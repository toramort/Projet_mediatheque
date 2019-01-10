package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Personality implements DatabaseObject {

    private int id_personality;
    private String firstname;
    private String lastname;
    private String surname;
    private Job jobs;

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

    public Personality(int id_personality, String firstname, String lastname, String surname, Job jobs) {
        this.id_personality = id_personality;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.jobs = jobs;

    }

    public Personality(String firstname, String lastname, String surname, Job jobs) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.jobs = jobs;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id_p) as max_id from personality ");
            result.next();
            this.id_personality = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public Job getJobs() {
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
            String queryJ = "INSERT INTO job_personality(id_job, id_p) VALUES (?,?)";
            PreparedStatement statementJ = conn.prepareStatement(queryJ);
            statementJ.setInt(1, this.jobs.getId_job());
            statementJ.setInt(2, this.getId_personality());
            statementJ.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAssocJob() {
        try {
            String query1 = "INSERT INTO job_personality(id_p, id_job) VALUES(?,?)";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            statement1.setInt(1, this.getJobs().getId_job());
            statement1.setInt(2, this.getId_personality());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossible de créer l'association Job - Personality",
                "le titre", JOptionPane.ERROR_MESSAGE);
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
        return this.firstname + " " + this.lastname + " " + this.surname + " | " + this.jobs;
    }
}
