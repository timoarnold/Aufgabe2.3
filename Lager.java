/**
 * @author Gruppe 29
 * @version 2.0 (14. November 2022)
 *
 * Die Klasse Lager beinhaltet die Informationen zu den maximal lagerbaren Materialeinheiten sowie den aktuellen
 * Beständen der Materialien.
 */

public class Lager {
    /**
     * KlassenVariabeln:
     * @param maxHolzeinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Holz (int).
     * @param maxSchrauben: Anzahl maximal lagerbarer Einheiten Schrauben (int).
     * @param maxFarbeinheiten: Anzahl maximal lagerbarer Einheiten Farbe (int).
     * @param maxKartoneinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Karton (int).
     * @param maxKissen: Anzahl maximal lagerbarer Einheiten Kissen (int).
     *
     * InstanzVariabeln:
     * @param vorhandeneHolzeinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Holz (int).
     * @param vorhandeneSchrauben: Anzahl aktuell gelagerter Einheiten Schrauben (int).
     * @param vorhandeneFarbeinheiten: Anzahl aktuell gelagerter Einheiten Farben (int).
     * @param vorhandeneKartoneinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Karton (int).
     * @param vorhandeneKissen: Anzahl aktuell gelagerter Einheiten Kissen (int).
     *
     * @param lieferant:
    */

    //Klassenvariabeln
    private static int maxHolzeinheiten;
    private static int maxSchrauben;
    private static int maxFarbeinheiten;
    private static int maxKartoneinheiten;
    private static int maxKissen;
    
    //Instanzvariabeln
    private int vorhandeneHolzeinheiten;
    private int vorhandeneSchrauben;
    private int vorhandeneFarbeinheiten;
    private int vorhandeneKartoneinheiten;
    private int vorhandeneKissen;

    private Lieferant lieferant;


    public Lager(int maxHolzeinheiten, int maxSchrauben , int maxFarbeinheiten, int maxKartoneinheiten, int maxKissen)
    {
        this.maxHolzeinheiten = 1000;
        this.maxSchrauben = 5000;
        this.maxFarbeinheiten = 1000;
        this.maxKartoneinheiten = 1000;
        this.maxKissen = 100;
    }

    public int gibBeschaffungszeit (Bestellung kundenBestellung) {
        int beschaffungszeit = 0;
        
        //if(product instanceof Stuhl){
            //
        //}else if(product instanceof Sofa){
            //
        //}
        
        return beschaffungszeit;
    }
    
    /**
     * Kommentar zu gibBeschaffungszeit
     */

    public void lagerAuffüllen () {
        //if(vorhandeneHolzeinheiten==maxHolzeinheiten){
            //
        //}

    }
    
    /**
     * Kommentar zu lagerAuffüllen
     */

    public void lagerBestandAusgeben (){

    }
    /**
     * Kommentar zu lagerBestandAusgeben
     */
}
