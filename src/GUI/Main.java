package GUI;

import database.Connect;

public class Main {
    public static void main(String[] args) {
        new Connect("jdbc:postgresql://127.0.0.1:5432/projet_mediatheque", "postgres", "root");
        new Fenetre();
    }

}

