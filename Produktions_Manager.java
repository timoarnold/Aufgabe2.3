import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert, damit sie immer wieder neu eintreffende Bestellungen abarbeiten und den Robotern zum Produzieren geben kann.
 */

public class Produktions_Manager extends Thread {
    /**
     * Instanzvariablen:
     *
     * - holzRoboter
     * - montageRoboter
     * - lackierRoboter
     * - verpackungsRoboter
     * - meineFabrik
     * - meinLager
     * - zuVerarbeitendeBestellungen
     * - bestellungenInProduktion
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

    public Produktions_Manager() { //mein --> param
        zuVerarbeitendeBestellungen = new LinkedList<Bestellung>();
        bestellungenInProduktion = new LinkedList<Bestellung>();

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
     * Wenn im Lager genügend Material vorhanden ist, wird somit die Produktion gestartet.
     * <p>
     * Zudem wird bei der Produktion geprüft, ob eine Bestellung abgeschlossen ist.
     * Wenn ja, wird die Bestellung von der zu produzierenden Bestellungen gelöscht.
     * Gleichzeitig wird  in der Klasse Bestellung festgehalten, dass die Produkte produziert und bereit auszuliefern sind.
     * <p>
     * Schliesslich soll der Thread um die Zeit zeit schlafen
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
                for (Produkt produkt : naechsteBestellung.getBestellteProdukte()){
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
     * Die folgenden beiden Methoden schienen mir nicht korrekt bennant bzw. auch nicht in Miro vorhanden
     * den Inhalt von "starte Produktion" habe ich von Übung 7 übernommen und übersetzt, denke aber, dieser sollte zu
     * einer neuen Methode "setzeProduktionsAblauf" benannt werden.
     *
     * ANM Cha: ich finde es gut, die zwei Methoden zu kombinieren - wir hatten ja gesagt, die Übung 7 dient als Beispiel, deshalb super :)
     * in Miro steht im Text, dass es eine "starteProduktion" Methode braucht. Aber nicht explizit im Diagramm.
     * Ich würde sie nicht setzteProduktionsAblauf bennen, weil wir ja in Produkt schon eine solch benannte Methode haben?
     */

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
