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
    * Dabei gibt es 4 mögliche Zustände: 
    * Zustand 1 = bestellt 
    * Zustand 2 = in Produktion
    * Zustand 3 = versandbereit
    * Zustand 4 = ausgeliefert
    * 
    */
    
    private int zustand;
    private LinkedList<Roboter> produktionsAblauf;
    private HashMap<Roboter, Integer> produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Produkt: initialisiert alle Instanzvariabeln der Klasse Produkt.
     * @param zustand: Aktueller Zustand eines Produkts = 1 = bestellt.
     */
    public Produkt()
    {
        zustand = 1;
        produktionsAblauf = new LinkedList<Roboter>();
    }

    /**
     * Produktzustand ändern
     * @param neuerZustand: Definiert den neuen Zustand, in den ein Produkt eintritt.
     *
     * ANM Timo: Sind wir uns diesen Zuständen sicher? Denke man beginnt mit 0 zu zählen und sollten die Zuständen nicht den
     * nicht die Produktionszustände? eg."Holzberarbeitet, aber noch nicht lakiert" wiedergeben?
     * 
     * ANM Cha: Guter Punkt, ich denke schon (laut Jonathan) und auch weil wahrscheinlich 0 "nicht bestellt" wäre?
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
     * ANM Cha: wieso steht einmal productionSequence und einmal produktionsAblauf? Sollte es nicht immer "produktionsablauf" heissen, da es das gleiche sein sollte?
     */
    public void setzeProduktionsAblauf(LinkedList<Roboter> produktionsAblauf){
        this.produktionsAblauf = produktionsAblauf;
    }

    /**
     * ANM Tim: Gemäss Musterlösung sollte die Methode setze ProduktionsZeit in der Klasse Roboter sein. Andererseits wurde die Methode in der Übung wie hier im Produkt implementiert
     * @param produktionsZeit
     * 
     * ANM Cha: Agreed (dass nicht im Diagramm vorhanden) und wir brauchen hier dann noch einen Beschrieb :)
     */
    public void setzeProduktionsZeit(HashMap<Roboter, Integer> produktionsZeit){
        this.produktionsZeit = produktionsZeit;
    }

    /**
     * ANM Cha: Was ist das noch für eine Methode? Beschrieb fehlt, falls wir die brauchen...
     */
    public int holeProduktionsZeit(Roboter roboter) {
        return produktionsZeit.get(roboter);
    }

    public void naechsteProduktionsStation(){
        if(produktionsAblauf.peek() != null){
            Roboter naechsterroboter = produktionsAblauf.poll();
            System.out.println("Produkt: Nächste Produktionsstation " + naechsterroboter.gibNamen());
            zustandAendern(2);
            naechsterroboter.fuegeProduktHinzu(this);
        }
        else{
            System.out.println("Produkt: " + this +" bereit zur Auslieferung ");
            zustandAendern(3);
        }
    }
}
