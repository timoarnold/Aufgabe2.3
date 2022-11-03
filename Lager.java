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
    private static int maxHolzeinheiten = 1000;
    private static int maxSchrauben = 5000;
    private static int maxFarbeinheiten = 1000;
    private static int maxKartoneinheiten = 1000;
    private static int maxKissen = 100;
    
    //Instanzvariabeln
    private int vorhandeneHolzeinheiten;
    private int vorhandeneSchrauben;
    private int vorhandeneFarbeinheiten;
    private int vorhandeneKartoneinheiten;
    private int vorhandeneKissen;

    private Lieferant lieferant;


    public Lager()
    {
        lieferant = new Lieferant();
    }

    /**
     * Kommentar zu gibBeschaffungszeit
     */
    public int gibBeschaffungszeit (Bestellung kundenBestellung) {
        int beschaffungszeit = 0;
        int benHolzeinheiten = 0;
        int benSchrauben =  0;
        int benFarbeinheiten =  0;
        int benKartoneinheiten =  0;
        int benKissen =  0;
        
        for(Produkt product : kundenBestellung.gibBestellteProdukte()){
            if(product instanceof Stuhl){
                benHolzeinheiten += Stuhl.getHolzeinheiten();
                benSchrauben += Stuhl.getSchrauben();
                benFarbeinheiten +=  Stuhl.getFarbEinheiten();
                benKartoneinheiten +=  Stuhl.getKartoneinheiten();
            }else if(product instanceof Sofa){
                benHolzeinheiten += Sofa.getHolzeinheiten();
                benSchrauben += Sofa.getSchrauben();
                benFarbeinheiten +=  Sofa.getFarbEinheiten();
                benKartoneinheiten +=  Sofa.getKartoneinheiten();
                benKissen += Sofa.getKissen();
            }
        }
        
        if(benHolzeinheiten < vorhandeneHolzeinheiten || benSchrauben < vorhandeneSchrauben || benFarbeinheiten < vorhandeneFarbeinheiten || benKartoneinheiten < vorhandeneKartoneinheiten || benKissen < vorhandeneKissen){
            beschaffungszeit = 2;
        }
        
        else{
            lagerAuffüllen();
        }
        
        return  beschaffungszeit;
        
        }
        

    /**
     * Kommentar zu lagerAuffüllen
     */
    public void lagerAuffüllen () {
        lieferant.wareBestellen(maxHolzeinheiten - vorhandeneHolzeinheiten, maxSchrauben - vorhandeneSchrauben, maxFarbeinheiten - vorhandeneFarbeinheiten, maxKartoneinheiten - vorhandeneKartoneinheiten, maxKissen - vorhandeneKissen);
        
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;
        
        //System Print falls gewollt -->Aktuell keine Zeitverzögerung einprogrammiert. Lager wird direkt gefüllt
        
    }
    
    public boolean bestandNiedrig(){
        float unteresLimit = 4; //bei einem 4tel der max Menge wird der Bestand als niedrig angegeben
        if(maxHolzeinheiten/unteresLimit> vorhandeneHolzeinheiten || maxSchrauben/unteresLimit> vorhandeneSchrauben || maxFarbeinheiten/unteresLimit> vorhandeneFarbeinheiten || maxKartoneinheiten/unteresLimit> vorhandeneKartoneinheiten || maxKissen /unteresLimit> vorhandeneKissen){
            return true;
        }else
        return false;
        
    }
    
    
    /**
     * Kommentar zu lagerBestandAusgeben
     */
    public void lagerBestandAusgeben (){

    }
    
    /**
     * Kommentar zu lagerBestandAusgeben
     */
    public Lieferant gibLieferant(){ //getter Methode um den Lieferant eines Lagers zu erhalten (wird für Testklasse benötigt)
        return this.lieferant;
    }
    
    
    
}
