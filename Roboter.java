import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert.
 *
 */
public class Roboter {
    /**
     * Instanzvariablen
     * - warteschlange
     * - name
     * - produktionsZeit
     */
    private LinkedList <Produkt> warteschlange;
    private String name;
    private int produktionsZeit;

    /**
     * Konstruktor
     */
    public Roboter (){

    }
   public void run(){

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

