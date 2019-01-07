package dataObjects;

import java.util.Date;
import java.util.List;

public class Album extends Oeuvre {

    private List<Morceau> morceaux;
    private int id_album;

    public Album(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, List<Evaluation> evaluations, Console console, Categorie categorie, List<Morceau> morceaux, int id_album) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, evaluations, console, categorie);
        this.morceaux = morceaux;
        this.id_album = id_album;
    }

    @Override
    public int getId_oeuvre() {
        return super.getId_oeuvre();
    }

    @Override
    public void setId_oeuvre(int id_oeuvre) {
        super.setId_oeuvre(id_oeuvre);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public Date getDate_ajout() {
        return super.getDate_ajout();
    }

    @Override
    public void setDate_ajout(Date date_ajout) {
        super.setDate_ajout(date_ajout);
    }

    @Override
    public Date getDate_oeuvre() {
        return super.getDate_oeuvre();
    }

    @Override
    public void setDate_oeuvre(Date date_oeuvre) {
        super.setDate_oeuvre(date_oeuvre);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void setFinished(boolean finished) {
        super.setFinished(finished);
    }

    @Override
    public List<Personality> getPersonalities() {
        return super.getPersonalities();
    }

    @Override
    public void setPersonalities(List<Personality> personalities) {
        super.setPersonalities(personalities);
    }

    @Override
    public List<Genre> getGenres() {
        return super.getGenres();
    }

    @Override
    public void setGenres(List<Genre> genres) {
        super.setGenres(genres);
    }

    @Override
    public Origine getOrigine() {
        return super.getOrigine();
    }

    @Override
    public void setOrigine(Origine origine) {
        super.setOrigine(origine);
    }

    @Override
    public List<Version> getVersions() {
        return super.getVersions();
    }

    @Override
    public void setVersions(List<Version> versions) {
        super.setVersions(versions);
    }

    @Override
    public Support getSupport() {
        return super.getSupport();
    }

    @Override
    public void setSupport(Support support) {
        super.setSupport(support);
    }

    @Override
    public List<Evaluation> getEvaluations() {
        return super.getEvaluations();
    }

    @Override
    public void setEvaluations(List<Evaluation> evaluations) {
        super.setEvaluations(evaluations);
    }

    @Override
    public Console getConsole() {
        return super.getConsole();
    }

    @Override
    public void setConsole(Console console) {
        super.setConsole(console);
    }

    @Override
    public Categorie getCategorie() {
        return super.getCategorie();
    }

    @Override
    public void setCategorie(Categorie categorie) {
        super.setCategorie(categorie);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public List<Morceau> getMorceaux() {
        return morceaux;
    }

    public void setMorceaux(List<Morceau> morceaux) {
        this.morceaux = morceaux;
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }
}
