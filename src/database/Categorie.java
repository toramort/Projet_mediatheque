package database;

public class Categorie implements DatabaseObject<Categorie> {

    private int id_c;
    private String name_c;

    public Categorie(int id_c, String name_c) {
        this.id_c = id_c;
        this.name_c = name_c;
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

    public int getId_c() {
        return id_c;
    }

    public String getName_c() {
        return name_c;
    }

    @Override
    public String toString() {
        return name_c;
    }
}
