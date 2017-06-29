package nl.rabobank.personenbeheer;

        import java.text.CollationKey;
        import java.time.LocalDate;
        import java.util.*;

        import static java.util.Collections.sort;

public class Persoon implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private Persoon persoon;

    private int id;
    private LocalDate nu = LocalDate.now();
    private String achterNaam;
    private String bsnNummer;
    private String emailAdres;
    private String geslacht;
    private String telefoonNummer;
    private String tussenVoegsel;
    private String voorletters;
    private int huisNummer;
    private String huisnrToevoeging;
    private String landCd;
    private String postcode;
    private String straatNaam;
    private String plaatsNaam;
    private LocalDate geboorteDat;
    private String geboorteplaatsNaam;
    private String gemeenteNaam;
    public static List<Persoon> personen = new ArrayList();


    public Persoon(String achterNaam, LocalDate geboorteDat) {
//        this.id = id;
        this.id = bepaalMaxId();
        this.achterNaam = achterNaam;
        this.geboorteDat = geboorteDat;
    }

    public Persoon() {

    }

    public int getId() {
        return id;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public LocalDate getGeboorteDat() {
        return geboorteDat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAchterNaam(String naam) {
        this.achterNaam = naam;
    }

    public void setGeboorteDat(int klant_gebjaar, int klant_gebmaand, int klant_gebdag) {
        this.geboorteDat = LocalDate.of(klant_gebjaar, klant_gebmaand, klant_gebdag);
    }


    public Persoon addPersoon(Persoon persoon) {
//        this.id=bepaalMaxId();
        if (persoon != null) {
            personen.add(persoon);
        }
        return persoon;
    }

    public int bepaalMaxId() {
        int maxid = 0;

        for (Persoon persoon : personen) {
            if (maxid <= id) {
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

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Persoon)) {
            return false;
        }

        Persoon persoon = (Persoon) o;

        return persoon.achterNaam.equals(achterNaam) &&
                persoon.bsnNummer.equals(bsnNummer) &&
                persoon.geboorteplaatsNaam.equals(geboorteplaatsNaam);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + achterNaam.hashCode();
        result = 31 * result + bsnNummer.hashCode();
        result = 31 * result + geboorteplaatsNaam.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final String separator = ", ";
        return "Achternaam=" + achterNaam + separator + "geboortedatum=" + geboorteDat;
    }
}
