import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert.
 *
 */
public class Roboter extends Thread {
    /**
     * Instanzvariablen
     * - warteschlange
     * - name
     * - produktionsZeit
     */
    private LinkedList <Produkt> warteschlange;
    private String name;
    private int produktionsZeit;



    public void run(){

    }

    /**
     * Die Methode starteProduktion löst die Produktion aus und teilt jedem Produkt der Bestelllung die Roboter in richtiger
     * Reihenfolge zu.
     * @param bestellung: Bestellungen, welche aufgegeben wurden
     */
    public void starteProduktion(Bestellung bestellung){
        this.warteschlange = new LinkedList<>();

    }

    public void fuegeProduktHinzu(Produkt produkt){

    }

    public void setzteProduktionsZeit(int zeit){

    }

    public String gibNamen(){
        return name;
    }

    public void produziereProdukt (Produkt produkt){

    }

}

