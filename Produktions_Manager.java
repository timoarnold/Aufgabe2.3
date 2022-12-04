import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 * <p>
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert, damit sie immer wieder neu eintreffende Bestellungen abarbeiten und den Robotern zum Produzieren geben kann.
 */

public class Produktions_Manager extends Thread {
    /**
     * Instanzvariablen:
     * <p>
     * - holzRoboter:
     * - montageRoboter:
     * - lackierRoboter:
     * - verpackungsRoboter:
     * - zuVerarbeitendeBestellungen:
     * - bestellungenInProduktion:
     */

    private Holzbearbeitungs_Roboter holzRoboter;
    private Montage_Roboter montageRoboter;
    private Lackier_Roboter lackierRoboter;
    private Verpackungs_Roboter verpackungsRoboter;
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList<Bestellung> bestellungenInProduktion;

    /**
     * Konstruktor für die Klasse Produktionsmanager.
     * Hier sind alle Roboter als Threads instanziiert und werden gestartet.
     * Zwei LinkedLists werden instanziiert, um die zu verarbeitende Bestellungen und die Bestellungen in Produktion zu verwalten.
     */

    public Produktions_Manager() {
        zuVerarbeitendeBestellungen = new LinkedList<>();
        bestellungenInProduktion = new LinkedList<>();

        holzRoboter = new Holzbearbeitungs_Roboter();
        montageRoboter = new Montage_Roboter();
        lackierRoboter = new Lackier_Roboter();
        verpackungsRoboter = new Verpackungs_Roboter();

        holzRoboter.start();
        montageRoboter.start();
        lackierRoboter.start();
        verpackungsRoboter.start();
    }

    /**
     * Die fuegeZuVerarbeitendeBestellungenHinzu Methode fügt Bestellungen zu Liste zuVerarbeitendeBestellungen hinzu.
     *
     * @param bestellung: Bestellung, welche verarbeitet werden soll.
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung) {
        this.zuVerarbeitendeBestellungen.add(bestellung);
    }

    /**
     * Die run Methode des Threats prüft immer wieder, ob eine neue Bestellung eingetroffen ist.
     * Bestellungen werden dann aus der Liste der zu verarbeitenden Bestellungen herausgenommen
     * und in die Liste der zu produzierenden Bestellungen (bestellungenInProduktion) gespeichert.
     * Die Liste der bestellten Produkte (naechsteBestellung.getBestellteProdukte()) werden nach Produkttyp (Stuhl, Sofa) sortiert,
     * sodass bei der Produktion einer Bestellung die Roboter nicht so oft umkonfiguriert werden müssen.
     * Wenn im Lager genügend Material vorhanden ist, wird somit die Produktion gestartet.
     * <p>
     * Zudem wird bei der Produktion geprüft, ob eine Bestellung abgeschlossen ist.
     * Wenn ja, wird die Bestellung von der zu produzierenden Bestellungen gelöscht.
     * Gleichzeitig wird in der Klasse Bestellung festgehalten, dass die Produkte produziert und bereit auszuliefern sind.
     * <p>
     * Schliesslich soll der Thread für eine bestimmte Zeit schlafen
     */

    public void run() {
        while (true) {
            Bestellung naechsteBestellung = zuVerarbeitendeBestellungen.poll();
            if (naechsteBestellung != null) {
                ThreadUtil.syncedPrintln("[Produktionsmanager] Beginne zu produzieren: Bestellungsnummer " + naechsteBestellung.gibBestellNummer());
                bestellungenInProduktion.add(naechsteBestellung);
                starteProduktion(naechsteBestellung);
                naechsteBestellung.getBestellteProdukte().sort((o1, o2)
                        -> o1.toString().compareTo(
                        o2.toString()));
                for (Produkt produkt : naechsteBestellung.getBestellteProdukte()) {
                    produkt.starteNaechsteProduktionsStation();
                }
            }

            for (Bestellung bestellung : bestellungenInProduktion) {
                boolean sindAlleProdukteProduziert = true;
                for (Produkt produkt : bestellung.liefereBestellteProdukte()) {
                    sindAlleProdukteProduziert = sindAlleProdukteProduziert && produkt.istProduziert();
                }
                if (sindAlleProdukteProduziert) {
                    bestellungenInProduktion.remove(bestellung);
                    bestellung.setzeAlleProdukteProduziert();
                    ThreadUtil.syncedPrintln("[Produktionsmanager] Fertig produziert: Bestellungsnummer " + bestellung.gibBestellNummer());
                }
            }
            ThreadUtil.sleep(1000);
        }
    }

    /**
     * In der Methode starteProduktion wird jedem Produkt der Bestellung
     * die entsprechenden Roboter zugewiesen und die Produktion dadurch gestartet.
     *
     * @param bestellung: Bestellung, welche produziert wird.
     */
    private void starteProduktion(Bestellung bestellung) {

        for (Produkt produkt : bestellung.getBestellteProdukte()) {

            LinkedList<Roboter> produktionsAblauf = new LinkedList<>();
            HashMap<Roboter, Integer> produktionsZeit = new HashMap<>();

            if (produkt instanceof Stuhl) {
                produktionsAblauf.add(holzRoboter);
                produktionsZeit.put(holzRoboter, Stuhl.HOLZARBEIT_ZEIT);
                produktionsAblauf.add(montageRoboter);
                produktionsZeit.put(montageRoboter, Stuhl.MONTAGE_ZEIT);
                produktionsAblauf.add(lackierRoboter);
                produktionsZeit.put(lackierRoboter, Stuhl.LACKIER_ZEIT);
                produktionsAblauf.add(verpackungsRoboter);
                produktionsZeit.put(verpackungsRoboter, Stuhl.VERPACKUNG_ZEIT);
            } else if (produkt instanceof Sofa) {
                produktionsAblauf.add(holzRoboter);
                produktionsZeit.put(holzRoboter, Sofa.HOLZARBEIT_ZEIT);
                produktionsAblauf.add(lackierRoboter);
                produktionsZeit.put(lackierRoboter, Sofa.LACKIER_ZEIT);
                produktionsAblauf.add(montageRoboter);
                produktionsZeit.put(montageRoboter, Sofa.MONTAGE_ZEIT);
                produktionsAblauf.add(verpackungsRoboter);
                produktionsZeit.put(verpackungsRoboter, Sofa.VERPACKUNG_ZEIT);
            }
            produkt.setzeProduktionsAblauf(produktionsAblauf);
            produkt.setzeProduktionsZeit(produktionsZeit);
        }

    }
}
