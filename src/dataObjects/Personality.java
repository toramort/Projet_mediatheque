package dataObjects;

import java.util.List;

public class Personality {

    private int id_personality;
    private String firstname;
    private String lastname;
    private String surname;
    private List<Job> jobs; //checkbox jobs boite de dialogue

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
}
