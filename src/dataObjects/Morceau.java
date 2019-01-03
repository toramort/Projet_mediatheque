package dataObjects;

import com.sun.jdi.event.MonitorContendedEnteredEvent;

import java.util.List;
import java.util.SortedSet;

public class Morceau {
    private String name_morceau;
    private List<Personality> personalities;
    private int id_morceau;

    public Morceau(String name_morceau, List<Personality> personalities) {
        this.name_morceau = name_morceau;
        this.personalities = personalities;
    }

    public Morceau(String name_morceau){
        this.name_morceau = name_morceau;
    }
}
