
/**
 * @author Gruppe 29
 * @version 1.0 (28. Oktober 2022)
 * 
 * Die Klasse Sofa bildet eine Erweiterung / Subklasse der Klasse Produkt. 
 * Sie erbt somit die Funktionalitäten sowie die globalen Variabeln der Klasse Produkt.
 * Zudem enthält sie Variabeln, welche für den Produkttyp <Sofa> einzigartig sind.
 */

public class Sofa extends Produkt {
    /**
     * Instanzvariabeln: Materialien, die zur Herstellung eines Sofas benötigt werden
     *
     * - holzeinheiten: Anzahl Holzeiheiten, welche zur Herstellung eines Sofas benötigt werden (int).
     * - schrauben: Anzahl Schrauben, welche zur Herstellung eines Sofas benötigt werden (int).
     * - farbeinheiten: Anzahl Farbeinheiten, welche zur Herstellung eines Sofas benötigt werden (int).
     * - kartoneinheiten: Anzahl Kartoneinheiten, welche zur Herstellung eines Sofas benötigt werden (int).
     * - produktionsZeit: Produktionszeit in Stunden (int), die zur Produktion eines Sofas nötig ist.
     * - kissen: Anzahl Kissen, welche zur Herstellung eines Sofas benötigt werden (int).
     */ 
    
    private static int holzeinheiten;
    private static int schrauben;
    private static int kissen;
    private static int farbeinheiten;
    private static int kartoneinheiten;
    private static int produktionsZeit;

    /**
     * Konstruktor für Objekte der Klasse Sofa: initialisiert alle Instanzvariabeln (siehe oben) der Klasse Sofa
     * Mit super(1) wird "Zustand" aus der Superklasse Produkt initialisiert
     */
    public Sofa() {
        super(1); 
        holzeinheiten = 4;
        schrauben = 5;
        kissen = 5;
        farbeinheiten = 1;
        kartoneinheiten = 5;
        produktionsZeit = 60;
    }

    /**
     * Gib die Anzahl Holzeinheiten wieder.
     * @return die Anzahl benötigter Holzeinheiten für die Produktion eines Sofas
     */
    public int getHolzeinheiten() {
        return holzeinheiten;
    }
    
    /**
     * Gib die Anzahl Schrauben wieder.
     * @return die Anzahl benötigter Schrauben für die Produktion eines Sofas
     */
    public int getSchrauben() {
        return schrauben;
    }
    
    /**
     * Gib die Anzahl Kissen wieder.
     * @return die Anzahl benötigter Kissen für die Produktion eines Sofas
     */
    public int getKissen() {
        return kissen;
    }
    
    /**
     * Gib die Anzahl Farbeinheiten wieder.
     * @return die Anzahl benötigter Farbeinheiten für die Produktion eines Sofas
     */
    public int getFarbEinheiten() {
        return farbeinheiten;
    }
    
    /**
     * Gib die Anzahl Kartoneinheiten wieder.
     * @return die Anzahl benötigter Kartoneinheiten für die Produktion eines Sofas
     */
    public int getKartoneinheiten() {
        return kartoneinheiten;
    }
    
    /**
     * Gib die Produktionszeit wieder.
     * @return die Produktionszeit für ein Sofa
     */
    public int getProduktionsZeit() {
        return produktionsZeit;
    }
}
