package dataObjects;

import java.util.Date;
import java.util.List;

public class Album extends Oeuvre {

    private Liste morceaux;
    private Liste personalities;

    public Album(String title, Date date_oeuvre, boolean finished, Liste morceaux, Liste personalities) {
        super(title, date_oeuvre, finished);
        this.morceaux = morceaux;
        this.personalities = personalities;
    }

    @Override
    public String toString() {
        return "Album{" +
            "morceaux=" + morceaux +
            ", personalities=" + personalities +
            super.toString() +
            '}';
    }
}
