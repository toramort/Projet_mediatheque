package GUI;

import database.Master;

public class Main {
    public static void main(String[] args) {
        new Master("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/projet_mediatheque", "postgres", "root");
        new Fenetre();
    }

}
