package dataObjects;

import java.util.List;

public class User {

    private int id_user;
    private String name_user;
    private List<Evaluation> evaluations;

    public User(int id_user, String name_user) {
        this.id_user = id_user;
        this.name_user = name_user;
    }

    public int getId_user() {
        return id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
}
