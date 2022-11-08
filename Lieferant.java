
/**
 * @author Gruppe 29
 * @version 2.0 (13. November 2022)
 *
 * Die Klasse Lieferant ermöglicht es Bestellungen an den Lieferanten aufzugeben.
 */

public class Lieferant {
    
    /**
     * Instanzvariabeln: bisher keine.
     */
    
    /**
    * Vorschlag Cha, dass die sich auch selbst aufruft durch run methode:
    * Diese Methode nimmt die zu bestellenden Einheiten entgegen und ruft diese sich selbst auch auf (run methode).
    * 
    * @param holzEinheiten: Holzeinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param schrauben: Schrauben, welche im Lager gehalten & zur Produktion benötigt werden
    * @param farbEinheiten: Farbeinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param kartonEinheiten: Kartoneinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param kissen: Kissen, welche im Lager gehalten & zur Produktion benötigt werden
    * @return: Setze auf true, falls eine Bestellung vom Lager eingegangen ist.
    */

    /** Feedback Cha
    * falls wir bei dem Lager die Einheiten abgeändert haben zu --> zuBestellendeHolzeinheiten etc, dann können wir diese nun abrufen (und nur diese...)
    * Vorschlag eine run Methode zu implementieren, damit das automatisch ausgelöst wird
    *
    * public boolean wareBestellen (int zuBestellendeHolzeinheiten, int zuBestellendeSchrauben, int zuBestellendeFarbeinheiten,
    * int zuBestellendeKartoneinheiten,int zuBestellendeKissen) {
    *    start();   
    *    return true;
    * }
    */
    
    public boolean wareBestellen (int holzEinheiten, int schrauben, int farbEinheiten,int kartonEinheiten,int kissen) {
        
        return true;
    }

}
