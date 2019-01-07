package dataObjects;

public class Genre {

    private int id_g;
    private String genre;

    public Genre(int id_g, String genre) {
        this.id_g = id_g;
        this.genre = genre;
    }

    public int getId_g() {
        return id_g;
    }

    @Override
    public String toString() {
        return genre;
    }
}
