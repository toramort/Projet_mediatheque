package GUI;


import database.Categorie;
import database.DBMaster;

public class Main {
    public static void main(String[] args) {
        new DBMaster("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/projet_mediatheque", "postgres", "root");
        new Fenetre();
        for (Categorie cat : DBMaster.readCategorie()) {
            System.out.println(cat);

        }
    }
}
