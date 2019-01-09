package database;

import java.util.List;

public class Album extends Oeuvre {

    private List<Morceau> morceaux;
    private int id_album;


    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

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
