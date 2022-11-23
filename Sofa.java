
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
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
    
    private static int holzeinheiten = 4;
    private static int schrauben = 5;
    private static int kissen = 5;
    private static int farbeinheiten =1;
    private static int kartoneinheiten = 5;
    private static int produktionsZeit = 60;

    /**
     * Konstruktor für Objekte der Klasse Sofa.
     * Mit super(1) wird "Zustand" aus der Superklasse Produkt initialisiert
     */
    public Sofa() {
        super(1); 
    }

    /**
     * Gib die Anzahl Holzeinheiten wieder.
     * @return die Anzahl benötigter Holzeinheiten für die Produktion eines Sofas
     */
    public static int getHolzeinheiten() {
        return holzeinheiten;
    }
    
    /**
     * Gib die Anzahl Schrauben wieder.
     * @return die Anzahl benötigter Schrauben für die Produktion eines Sofas
     */
    public static int getSchrauben() {
        return schrauben;
    }
    
    /**
     * Gib die Anzahl Kissen wieder.
     * @return die Anzahl benötigter Kissen für die Produktion eines Sofas
     */
    public static int getKissen() {
        return kissen;
    }
    
    /**
     * Gib die Anzahl Farbeinheiten wieder.
     * @return die Anzahl benötigter Farbeinheiten für die Produktion eines Sofas
     */
    public static int getFarbEinheiten() {
        return farbeinheiten;
    }
    
    /**
     * Gib die Anzahl Kartoneinheiten wieder.
     * @return die Anzahl benötigter Kartoneinheiten für die Produktion eines Sofas
     */
    public static int getKartoneinheiten() {
        return kartoneinheiten;
    }
    
    /**
     * Gib die Produktionszeit wieder.
     * @return die Produktionszeit für ein Sofa
     */
    public static int getProduktionsZeit() {
        return produktionsZeit;
    }
}
