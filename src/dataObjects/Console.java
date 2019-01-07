package dataObjects;

public class Console {
    private int id_c;
    private String name_c;

    public Console(int id_c, String name_c) {
        this.id_c = id_c;
        this.name_c = name_c;
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
