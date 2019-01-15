package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Categorie implements DatabaseObject {

    private int id_c;
    private String name_c;

    Categorie(int id_c, String name_c) {
        this.id_c = id_c;
        this.name_c = name_c;
    }

    public static List<Categorie> read() {
        List<Categorie> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from categorie");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Categorie(result.getInt("id_c"), result.getString("name_c")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
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
