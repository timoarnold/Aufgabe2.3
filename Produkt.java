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
     * Instanzvariabeln: 
     * 
     * - zustand: Aktueller Zustand eines Produkts (int). 
     * 
     * Anmerkung: Bisher noch int-Wert, der manuell eingegeben werden kann für jeden Produkt-Zustand (bspw. "bestellt = 1")
     */
    
    private int zustand;
    private LinkedList<Roboter> produktionsAblauf;
    private HashMap<Roboter, Integer> produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Produkt: initialisiert alle Instanzvariabeln der Klasse Produkt.
     * @param zustand: Aktueller Zustand eines Produkts (int).
     */
    public Produkt(int zustand)
    {
        this.zustand = zustand;
    }

    /**
     * Produktzustand ändern, wobei:
     * Zustand 1 = bestellt 
     * Zustand 2 = in Produktion
     * Zustand 3 = versandbereit
     * Zustand 4 = versendet
     * @param neuerZustand: Definiert den neuen Zustand, in den ein Produkt eintritt.
     *
     * ANM Timo: Sind wir uns diesen Zuständen sicher? Denke man beginnt mit 0 zu zählen und sollten die Zuständen nicht den
     * nicht die Produktionszustände? eg."Holzberarbeitet, aber noch nicht lakiert" wiedergeben?
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
     */
    public void setzeProduktionsAblauf(LinkedList<Roboter> productionSequence){
        this.produktionsAblauf = produktionsAblauf;
    }

    /**
     * ANM Tim: Gemäss Musterlösung sollte die Methode setze ProduktionsZeit in der Klasse Roboter sein. Andererseits wurde die Methode in der Übung wie hier im Produkt implementiert
     * @param produktionsZeit
     */
    public void setzeProduktionsZeit(HashMap<Roboter, Integer> produktionsZeit){
        this.produktionsZeit = produktionsZeit;
    }

    public int holeProduktionsZeit(Roboter roboter) {
        return produktionsZeit.get(roboter);
    }

    public void naechsteProduktionsStation(){

    }
}
