package database;

import java.util.Date;
import java.util.List;

public class JeuVideo extends Oeuvre {

    private Console console;

    public JeuVideo(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, Categorie categorie, Console console) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, categorie);
        this.console = console;
    }

    public JeuVideo(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, List<Evaluation> evaluations, Categorie categorie, Console console) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, evaluations, categorie);
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
