
/** 
 * @author Gruppe 29
 * @version 1.0 (28. Oktober 2022)
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
     */
    public void zustandAendern(int neuerZustand)
    {
        zustand = neuerZustand;
    }
    
    /**
     * Gib den aktuellen Zustand eines Produkts wieder.
     * @return den aktuellen Produktzustand
     */
    public int alktuellerZustand()
    {
        return zustand;
    }
}
