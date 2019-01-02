package dataObjects;

import java.util.List;

public class Personality {

    private String firstname;
    private String lastname;
    private String surname;
    private List<Job> jobs; //checkbox jobs boite de dialogue
    private List<Morceau> morceaux;

    public Personality(String firstname, String lastname, String surname, List<Job> jobs, List<Morceau> morceaux){

        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.jobs = jobs;
        this.morceaux = morceaux;
    }
}
