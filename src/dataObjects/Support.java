package dataObjects;

public class Support {
    private int id_s;
    private String name_s;

    public Support(int id_s, String name_s) {
        this.id_s = id_s;
        this.name_s = name_s;
    }

    public int getId_s() {
        return id_s;
    }

    public String getName_s() {
        return name_s;
    }

    @Override
    public String toString() {
        return name_s;
    }
}
