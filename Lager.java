/**
 * @author Gruppe 29
 * @version 2.0 (13. November 2022)
 *
 * Die Klasse Lager beinhaltet die Informationen zu den maximal lagerbaren Materialeinheiten sowie den aktuellen
 * Beständen der Materialien.
 */

public class Lager {
    /**
     * KlassenVariabeln:
     * - maxHolzeinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Holz (int).
     * - maxSchrauben: Anzahl maximal lagerbarer Einheiten Schrauben (int).
     * - maxFarbeinheiten: Anzahl maximal lagerbarer Einheiten Farbe (int).
     * - maxKartoneinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Karton (int).
     * - maxKissen: Anzahl maximal lagerbarer Einheiten Kissen (int).
     *
     * InstanzVariabeln:
     * - vorhandeneHolzeinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Holz (int).
     * - vorhandeneSchrauben: Anzahl aktuell gelagerter Einheiten Schrauben (int).
     * - vorhandeneFarbeinheiten: Anzahl aktuell gelagerter Einheiten Farben (int).
     * - vorhandeneKartoneinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Karton (int).
     * - vorhandeneKissen: Anzahl aktuell gelagerter Einheiten Kissen (int).
     *
     * - lieferant: Beschreibt den Lieferanten, bei welchem die Fabrik Materialien bestellt (Lieferant).
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
    
    private int benoetigteHolzeinheiten;
    private int benoetigteSchrauben;
    private int benoetigteFarbeinheiten;
    private int benoetigteKartoneinheiten;
    private int benoetigteKissen;

    private Lieferant lieferant;


    /**
     * Konstruktor der Klasse Lager: initialisiert alle Instanzvariabeln der Klasse Lager. 
     * Bei Erzeugung eines Lagers wird auch ein zugehöriger Lieferant instanziert.
     */
    public Lager()
    {   
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;
        
        lieferant = new Lieferant();
    }

    /**
     * Kontrolliert, ob die benötigten Materialien für die Kundenbestellung im Lager vorhanden sind und berechnet die zugehörige Beschaffungszeit.
     * Die Beschaffungszeit wird anschliessend ausgegeben.
     * @param kundenBestellung: Die Inhalte einer aufgegebenen Kundenbestellung. 
     * @return die Beschaffungszeit, welche für die Kundenbestellung benötigt wird.
     * 
     * Anmerkung: Falls zu wenig Material vorhanden ist, wird das Lager automatisch aufgefüllt. Jeff fügt hier noch was zu
     */
    
    public int gibBeschaffungszeit (Bestellung kundenBestellung) {
        int beschaffungszeit = 0;
        
        for(Produkt product : kundenBestellung.liefereBestellteProdukte()){
            if(product instanceof Stuhl){
                benoetigteHolzeinheiten += Stuhl.getHolzeinheiten();
                benoetigteSchrauben += Stuhl.getSchrauben();
                benoetigteFarbeinheiten += Stuhl.getFarbEinheiten();
                benoetigteKartoneinheiten += Stuhl.getKartoneinheiten();
            }else if(product instanceof Sofa){
                benoetigteHolzeinheiten += Sofa.getHolzeinheiten();
                benoetigteSchrauben +=Sofa.getSchrauben();
                benoetigteFarbeinheiten += Sofa.getFarbEinheiten();
                benoetigteKartoneinheiten += Sofa.getKartoneinheiten();
                benoetigteKissen += Sofa.getKissen();
            }
        }
        
        if(istBestandNiedrig()) {
            beschaffungszeit = 2;
        }
        
        return beschaffungszeit;
        
    }
    
    /**
     * Kontrolliert, ob der aktuelle Lagerbestand unter einem festgelegten Minimalbetrag liegt.
     * Liegt der Bestand unter einem 4tel der max. Menge, dann wird der Lagerbestand als niedrig festgelegt (true).
     * 
     * @return true, falls Lagerbestand niedrig / false, sonst.
     */
    private boolean istBestandNiedrig(){
        float unteresLimit = 4; //bei einem 4tel der max Menge wird der Bestand als niedrig angegeben
        return maxHolzeinheiten / unteresLimit > vorhandeneHolzeinheiten 
        || maxSchrauben / unteresLimit > vorhandeneSchrauben 
        || maxFarbeinheiten / unteresLimit > vorhandeneFarbeinheiten 
        || maxKartoneinheiten / unteresLimit > vorhandeneKartoneinheiten 
        || maxKissen / unteresLimit > vorhandeneKissen; 
    }
    
    public void zieheBenoetigteMaterialienVomLagerAb() {
        vorhandeneHolzeinheiten -= benoetigteHolzeinheiten;
        vorhandeneSchrauben -= benoetigteSchrauben;
        vorhandeneFarbeinheiten -= benoetigteFarbeinheiten;
        vorhandeneKartoneinheiten -= benoetigteKartoneinheiten;
        vorhandeneKissen -= benoetigteKissen;
    }

    /**
     * Füllt die im Lager vorhandenen Materialien auf ihre Maximalwerte aus, sobald die Lieferung des Lieferanten eingetroffen ist.
     * 
     * Anmerkung: mit dieser Methode werden die Werte vorhandener Materialien in der Software wieder auf das Max. gesetzt.
     */
    public void lagerAuffuellen () {

        int zuBestellendeHolzeinheiten = maxHolzeinheiten - vorhandeneHolzeinheiten;
        int zuBestellendeSchrauben = maxSchrauben - vorhandeneSchrauben;
        int zuBestellendeFarbeinheiten = maxFarbeinheiten - vorhandeneFarbeinheiten;
        int zuBestellendeKartoneinheiten = maxKartoneinheiten - vorhandeneKartoneinheiten;
        int zuBestellendeKissen = maxKissen - vorhandeneKissen;

        lieferant.wareBestellen(zuBestellendeHolzeinheiten, zuBestellendeSchrauben, zuBestellendeFarbeinheiten, zuBestellendeKartoneinheiten, zuBestellendeKissen);

        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;

        System.out.println("Die Materialbestellung wurde dem Lieferanten zugestellt. Akutell wird diese unverzüglich geliefert.");
    }
        
    /**
     * Druckt den aktuellen Lagerbestand (vorhandene Materialien im Lager) auf der Konsole aus.
     */
    public void lagerBestandAusgeben (){
        System.out.println("Folgende Materialien befinden sich aktuell im Lager:");
        
        System.out.println("Holzeinheiten: " + vorhandeneHolzeinheiten);
        System.out.println("Schrauben: " + vorhandeneSchrauben);
        System.out.println("Farbeinheiten: " + vorhandeneFarbeinheiten);
        System.out.println("Kartoneinheiten: " + vorhandeneKartoneinheiten);
        System.out.println("Kissen: " + vorhandeneKissen);
    }
    
    /**
     * Getter-Methode, um den Lieferanten eines Lagers zu erhalten. 
     * @return den Lieferanten des Lagers.
     * 
     * Anmerkung: Diese Methode wird für die Testklasse "LagerTest" benötigt,um den Lieferanten anzusprechen und dessen Methodenergebnis zu testen.
     */
    public Lieferant gibLieferant(){ 
        return this.lieferant;
    }
    
    
    
}
