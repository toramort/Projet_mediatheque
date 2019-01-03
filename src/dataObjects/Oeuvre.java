package dataObjects;

import java.util.Date;
import java.util.List;

public abstract class Oeuvre {

    private String title;
    private Date date_ajout;
    private Date date_oeuvre;
    private boolean finished;
    private Liste personalities;
    private Liste genres;
    private Origine origine;
    private Liste versions;
    private Support support;
    private Liste Evaluations;
    private int id_oeuvre;

    Oeuvre(){}

    Oeuvre(String title, Date date_oeuvre, boolean finished){
        this.title = title;
        this.date_ajout = new Date();
        this.date_oeuvre = date_oeuvre;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Oeuvre{" +
            "title='" + title + '\'' +
            ", date_ajout=" + date_ajout +
            ", date_oeuvre=" + date_oeuvre +
            ", finished=" + finished +
            ", personalities=" + personalities +
            ", genres=" + genres +
            ", origine=" + origine +
            ", versions=" + versions +
            ", support=" + support +
            ", Evaluations=" + Evaluations +
            '}';
    }
}
