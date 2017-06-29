package nl.rabobank.personenbeheer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class PersonenInvoer {


    public static List<Persoon> personen = new ArrayList();


    public PersonenInvoer() {

    }

    public Persoon addPersoon(Persoon persoon) {
//        this.id=bepaalMaxId();
        if (persoon != null) {
            personen.add(persoon);
        }
        return persoon;
    }

    public static int bepaalMaxId() {
        int maxid = 0;

        for (Persoon persoon : personen) {
            int id = persoon.getId();
            if (maxid <= persoon.getId()) {
                maxid = ++id;
            }
        }
        return maxid;
    }

    public static List<Persoon> sortByAchterNaamAscending(List<Persoon> personen) {
        List<Persoon> list = new ArrayList<>(personen);
        sort(personen, new Comparator<Persoon>() {
            @Override
            public int compare(Persoon persoon1, Persoon persoon2) {
                return persoon1.getAchterNaam().compareTo(persoon2.getAchterNaam());
            }
        });
        return list;
    }
}
