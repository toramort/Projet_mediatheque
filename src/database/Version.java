package database;

public class Version {
    private int id_v;
    private String version;

    public Version(int id_v, String version) {
        this.id_v = id_v;
        this.version = version;
    }

    public int getId_v() {
        return id_v;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return version;
    }
}
