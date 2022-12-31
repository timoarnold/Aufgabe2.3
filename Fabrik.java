import java.util.ArrayList;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 * <p>
 * Die Klasse Fabrik bildet die Schnittstelle zwischen Kund:innen und der Produktion.
 * Sie nimmt Bestellungen entgegen und verwaltet diese.
 */

public class Fabrik {
    /**
     * Instanzvariablen:
     * <p>
     * - bestellungen: Array-Liste, in der alle eingegangenen Bestellungen als Typ <Bestellung> abgespeichert werden.
     * - bestellungsNr: Nummer, welche jeder Bestellung aufsteigend zugeordnet wird, beginnend bei 1 (int).
     * - lager: Das zur Fabrik gehörende Lager (jeweils eines).
     * - produktionsManager: Der Manager, welcher neu eintreffende Bestellungen verarbeitet und den jeweiligen Robotern zuweist.
     */
    private ArrayList<Bestellung> bestellungen;
    private int bestellungsNr;
    private Lager lager;
    private Produktions_Manager produktionsManager;

    /**
     * Konstruktor für Objekte der Klasse Fabrik: Hier werden die Instanzvariabeln (siehe oben) initialisiert.
     */
    public Fabrik() {
        bestellungen = new ArrayList<>();
        lager = new Lager();
        produktionsManager = new Produktions_Manager();
        produktionsManager.start();
    }

    /**
     * Die Main-Methode ermöglicht den Einstieg in das Programm. Dabei werden eine Fabrik, ein GUIController
     * und ein GUI instanziert. Dadurch öffnet sich das Userinterface, auf welchem mit dem Programm interagiert werden
     * kann.
     */
    public static void main(String[] args) {
        System.out.println("Ausgabe aus der main()-Methode:");
        Fabrik fabrik = new Fabrik();

        GUIController controller = new GUIController(fabrik);
        GUI gui = new GUI(controller);
    }

    /**
     * Bestellung aufgeben.
     *
     * @param sofa:  Anzahl Sofas, die in einer Bestellung bestellt wurden.
     * @param stuhl: Anzahl Stühle, die in einer Bestellung bestellt wurden.
     *               <p>
     *               Anmerkung: Durch bestellungAufgeben wird eine neue Instanz der Klasse Bestellung erstellt, die Bestellung bestätigt und in der Array "bestellungen" gespeichert.
     *               Zu jeder aufgegebenen Bestellung wird hier die jeweilige Lieferzeit ausgerechnet und gesetzt und die Bestellbestätigung auf true gesetzt.
     *               Falls ein niedriger Lagerbestand erreicht wurde, wird beim Lieferanten nachbestellt, um das Lager komplett aufzufüllen.
     *               Bei erfolgreicher Bestellabgabe wird auf der Konsole anschliessend eine Nachricht ausgespielt.
     *               In der folgenden Methode wird zudem festgelegt, dass die Bestellung nur positive Werte enthalten darf (Keine Minusbestellungen, ansonsten Fehlermeldung).
     */
    public Bestellung bestellungAufgeben(int sofa, int stuhl) {
        Bestellung bestellung = null;
        if (sofa < 0 || stuhl < 0 || sofa + stuhl == 0) {
            System.out.println("Bitte geben Sie einen positiven Bestellbetrag ein.");
        } else {
            bestellungsNr++;

            bestellung = new Bestellung(bestellungsNr, sofa, stuhl);

            int beschaffungsZeit = lager.gibBeschaffungszeit(bestellung);
            bestellung.setzBeschaffungsZeit(beschaffungsZeit);

            if (beschaffungsZeit == 2) {
                lager.wareLiefern();
                lager.lagerAuffuellen();
            }
            lager.zieheBenoetigteMaterialienVomLagerAb();

            float prodZeit = 0;
            prodZeit += (float) bestellung.gibAnzahlStuehle() * Stuhl.getProduktionsZeit() / 60 / 24;
            prodZeit += (float) bestellung.gibAnzahlSofas() * Sofa.getProduktionsZeit() / 60 / 24;

            float standardLieferZeit = 1;

            bestellung.setzLieferZeit(prodZeit + (float) beschaffungsZeit + standardLieferZeit);

            bestellung.bestellungBestaetigen();
            bestellungen.add(bestellung);
        }
        return bestellung;
    }

    /**
     * Mit dieser Methode werden die Bestellungen der Liste hinzugefügt, welche verarbeitet werden müssen.
     */
    public void bestellungVerarbeiten(Bestellung zuVerarbeitendeBestellung) {
        produktionsManager.fuegeZuVerarbeitendeBestellungenHinzu(zuVerarbeitendeBestellung);
    }

    /**
     * Mit dieser Methode wird die Bestellungsnummer wiedergegeben.
     *
     * @return die Nummer der letzten Bestellung, die aufgegeben wurde (=Totale Anzahl Bestellungen bisher)
     */
    public int gibBestellungsNr() {
        return bestellungsNr;
    }

    /**
     * Mit dieser Methode werden die Bestellungen wiedergegeben.
     *
     * @return ArrayListe bestellungen
     * <p>
     * Anmerkung: Diese Methode dient den Unit-Tests im Rahmen der Testklasse FabrikTest.
     * Sie gibt die Bestellungsinformationen für den Unit-Test zur Methode Bestellung auf- und ausgeben wieder.
     */
    public ArrayList<Bestellung> gibBestellungen() {
        return bestellungen;
    }

    /**
     * Mit dieser Methode werden die detaillierten Informationen zu allen Bestellungen ausgegeben.
     * <p>
     * Anmerkung: Für jede Bestellung aus der Liste bestellungen, gibt die Konsole die unten programmierte Print-Meldung aus.
     * Diese Methode gibt somit alle Informationen (Anzahl Stühle / Anzahl Sofas / Bestellungen Total / Bestellungsnummer)
     * für alle aufgegebenen Bestellungen wieder.
     */
    public void bestellungenAusgeben() {
        System.out.println("\nTotal Bestellungen bisher: " + bestellungsNr);

        for (Bestellung bestellung : bestellungen) {
            System.out.println("\n" + bestellung + "\n");
        }
    }

    /**
     * Mit dieser Methode wird das Lager wiedergegeben.
     *
     * @return Lager
     * <p>
     * Anmerkung: Diese Methode dient den Unit-Tests im Rahmen der Testklasse FabrikTest.
     * Sie gibt die Möglichkeit, Methoden der Klasse Lager aufzurufen
     */
    public Lager getLager() {
        return lager;
    }

    /**
     * Mit dieser Methode wird der Produktionsmanager implementiert.
     */
    public Produktions_Manager gibProduktionsManager() {
      return produktionsManager;
    }
}
