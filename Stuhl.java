
/**
 * @author Gruppe 29 
 * @version 1.0 (28. Oktober 2022)
 * 
 * Die Klasse Stuhl bildet eine Erweiterung / Subklasse der Klasse Produkt. 
 * Sie erbt somit die Funktionalitäten sowie die globalen Variabeln der Klasse Produkt.
 * Zudem enthält sie Variabeln, welche für den Produkttyp <Stuhl> einzigartig sind.
 */

public class Stuhl extends Produkt {
    /**
     * Instanzvariabeln: Materialien, die zur Herstellung eines Stuhl benötigt werden
     *
     * - holzeinheiten: Anzahl Holzeiheiten, welche zur Herstellung eines Stuhls benötigt werden (int).
     * - schrauben: Anzahl Schrauben, welche zur Herstellung eines Stuhls benötigt werden (int).
     * - farbeinheiten: Anzahl Farbeinheiten, welche zur Herstellung eines Stuhls benötigt werden (int).
     * - kartoneinheiten: Anzahl Kartoneinheiten, welche zur Herstellung eines Stuhls benötigt werden (int).
     * - produktionsZeit: Produktionszeit in Stunden, die zur Produktion eines Stuhls nötig ist (int).
     */ 
    private static int holzeinheiten;
    private static int schrauben;
    private static int farbeinheiten;
    private static int kartoneinheiten;
    private static int produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Stuhl: initialisiert alle Instanzvariabeln (siehe oben) der Klasse Stuhl
     * Mit super(1) wird "Zustand" aus der Superklasse Produkt initialisiert
     */
    public Stuhl() {
        super (1);
        holzeinheiten = 2;
        schrauben = 10;
        farbeinheiten = 2;
        kartoneinheiten = 1;
        produktionsZeit = 22;
    }
    
    /**
     * Gib die Anzahl Holzeinheiten wieder.
     * @return die Anzahl benötigter Holzeinheiten für die Produktion eines Stuhls
     */
    public int getHolzeinheiten() {
        return holzeinheiten;
    }
    
    /**
     * Gib die Anzahl Schrauben wieder.
     * @return die Anzahl benötigter Schrauben für die Produktion eines Stuhls
     */
    public int getSchrauben() {
        return schrauben;
    }
    
    /**
     * Gib die Anzahl Farbeinheiten wieder.
     * @return die Anzahl benötigter Farbeinheiten für die Produktion eines Stuhls
     */
    public int getFarbEinheiten() {
        return farbeinheiten;
    }
    
    /**
     * Gib die Anzahl Kartoneinheiten wieder.
     * @return die Anzahl benötigter Kartoneinheiten für die Produktion eines Stuhls
     */
    public int getKartoneinheiten() {
        return kartoneinheiten;
    }
    
    /**
     * Gib die Produktionszeit wieder.
     * @return die Produktionszeit für einen Stuhl
     */
    public int getProduktionsZeit() {
        return produktionsZeit;
    }
}
