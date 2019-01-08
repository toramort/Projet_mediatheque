package database;

import java.util.Date;
import java.util.List;

public abstract class Oeuvre implements DatabaseObject {

    private int id_oeuvre;
    private String title;
    private Date date_ajout;
    private Date date_oeuvre;
    private boolean finished;
    private List<Personality> personalities;
    private List<Genre> genres;
    private Origine origine;
    private List<Version> versions;
    private Support support;
    private List<Evaluation> evaluations;
    private Categorie categorie;

    public Oeuvre(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, Categorie categorie) {
        this.id_oeuvre = id_oeuvre;
        this.title = title;
        this.date_ajout = date_ajout;
        this.date_oeuvre = date_oeuvre;
        this.finished = finished;
        this.personalities = personalities;
        this.genres = genres;
        this.origine = origine;
        this.versions = versions;
        this.support = support;
        this.categorie = categorie;
    }

    Oeuvre(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, List<Evaluation> evaluations, Categorie categorie) {
        this.id_oeuvre = id_oeuvre;
        this.title = title;
        this.date_ajout = date_ajout;
        this.date_oeuvre = date_oeuvre;
        this.finished = finished;
        this.personalities = personalities;
        this.genres = genres;
        this.origine = origine;
        this.versions = versions;
        this.support = support;
        this.evaluations = evaluations;
        this.categorie = categorie;
    }


    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public Date getDate_oeuvre() {
        return date_oeuvre;
    }

    public void setDate_oeuvre(Date date_oeuvre) {
        this.date_oeuvre = date_oeuvre;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<Personality> getPersonalities() {
        return personalities;
    }

    public void setPersonalities(List<Personality> personalities) {
        this.personalities = personalities;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Origine getOrigine() {
        return origine;
    }

    public void setOrigine(Origine origine) {
        this.origine = origine;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
