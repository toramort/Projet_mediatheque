package dataObjects;

public class Origine {
    private String name_o;
    private int id_o;

    public Origine(String name_o, int id_o) {
        this.name_o = name_o;
        this.id_o = id_o;
    }

    public String getName_o() {
        return name_o;
    }

    public int getId_o() {
        return id_o;
    }

    @Override
    public String toString() {
        return name_o;
    }
}
