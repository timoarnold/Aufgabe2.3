import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 * 
 * Die Klasse Produkt bildet die Superklasse der beiden Produkte Stuhl & Sofa.
 * Sie enthält globale Variabeln für diese beiden Produkte / Variabeln, welche bei Stuhl & Sofa identisch sind.
 */

public class Produkt {
    /**
    * Instanzvariablen:
    * 
    * - zustand: aktueller Zustand eines Produkts (int).
    * 
    *   Dabei gibt es 4 mögliche Zustände:
    *   Zustand 1 = bestellt
    *   Zustand 2 = in Produktion
    *   Zustand 3 = versandbereit
    *   Zustand 4 = ausgeliefert
    *
    * - produktionsAblauf: Liste, in welcher die Abfolge der Produktionsroboter abgespeichert wird.
    * - produktionsZeit: Hashmap, zur Abspeicherung der Produktionszeiten.
    * - bestellNummer: Zahl, zur Identifikation der Bestellungen.
    */
    
    private int zustand;
    private LinkedList<Roboter> produktionsAblauf;
    private HashMap<Roboter, Integer> produktionsZeit;
    private int bestellNummer;

    /**
     * Konstruktor für Objekte der Klasse Produkt: initialisiert alle Instanzvariablen der Klasse Produkt.
     */
    public Produkt(int bestellNummer){
        zustand = 1;
        produktionsAblauf = new LinkedList<>();
        produktionsZeit = new HashMap<>();
        this.bestellNummer = bestellNummer;
    }

    /**
     * Produktzustand ändern
     * @param neuerZustand: Definiert den neuen Zustand, in den ein Produkt eintritt.
     */
    public void zustandAendern(int neuerZustand)
    {
        zustand = neuerZustand;
    }
    
    /**
     * Gib den aktuellen Zustand eines Produkts wieder.
     * @return den aktuellen Produktzustand
     */
    public int aktuellerZustand()
    {
        return zustand;
    }

    /**
     * Setzt den Produktionsablauf des Produkts.
     *
     */
    public void setzeProduktionsAblauf(LinkedList<Roboter> produktionsAblauf){
        this.produktionsAblauf = produktionsAblauf;
    }

    /**
     * Setze die Produktionszeit für den jeweiligen Roboter.
     * @param produktionsZeit
     */
    public void setzeProduktionsZeit(HashMap<Roboter, Integer> produktionsZeit){
        this.produktionsZeit = produktionsZeit;
    }

    /**
     * Hole die ProduktionsZeit der jeweiligen Roboter
     */
    public int holeProduktionsZeit(Roboter roboter) {
        return produktionsZeit.get(roboter);
    }

    /**
     * Setzt die Roboter gemäss dem Produktionsablauf für die Produktion des Produktes ein. Falls das Produkt alle Roboter durchgelaufen ist, ändert der Zustand auf 3 (Versandbereit).
     */
    public void starteNaechsteProduktionsStation(){
        if(!produktionsAblauf.isEmpty()){
            Roboter naechsterRoboter = produktionsAblauf.poll();
            zustandAendern(2);
            naechsterRoboter.fuegeProduktHinzu(this);
        }
        else{
            System.out.println("[Produkt] " + this + " fertig produziert und bereit zur Auslieferung ");
            zustandAendern(3);
        }
    }

    /**
     * Methode, welche den Produktionsstatus "Versandbereit" zurückgibt.
     * @return zustand
     */
    public boolean istProduziert(){
        return zustand == 3;
    }

    /**
     * Methode, welche die Bestellnummer der zugehörigen Bestellung des Produkts zurückgibt.
     * @return Bestellnummer
     */
    public int getBestellNummer() {
        return bestellNummer;
    }
}
