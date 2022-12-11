/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 * 
 * Die Klasse Lager beinhaltet die Informationen zu den maximal lagerbaren Materialeinheiten sowie den aktuellen
 * Beständen der Materialien.
 */

public class Lager {
    /**
     * KlassenVariablen:
     * - maxHolzeinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Holz (int).
     * - maxSchrauben: Anzahl maximal lagerbarer Einheiten Schrauben (int).
     * - maxFarbeinheiten: Anzahl maximal lagerbarer Einheiten Farbe (int).
     * - maxKartoneinheiten: Anzahl maximal lagerbarer Einheiten des Rohstoffs Karton (int).
     * - maxKissen: Anzahl maximal lagerbarer Einheiten Kissen (int).
     *
     * InstanzVariablen:
     * - vorhandeneHolzeinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Holz (int).
     * - vorhandeneSchrauben: Anzahl aktuell gelagerter Einheiten Schrauben (int).
     * - vorhandeneFarbeinheiten: Anzahl aktuell gelagerter Einheiten Farben (int).
     * - vorhandeneKartoneinheiten: Anzahl aktuell gelagerter Einheiten des Rohstoffs Karton (int).
     * - vorhandeneKissen: Anzahl aktuell gelagerter Einheiten Kissen (int).
     *
     * - benoetigteHolzeinheiten; Anzahl Einheiten des Rohstoffs Holz (int), welche für die Produktion der Bestellung benötigt werden.
     * - benoetigteSchrauben; Anzahl Einheiten Schrauben (int), welche für die Produktion der Bestellung benötigt werden.
     * - benoetigteFarbeinheiten; Anzahl Einheiten Farben (int), welche für die Produktion der Bestellung benötigt werden.
     * - benoetigteKartoneinheiten; Anzahl Einheiten Karton (int), welche für die Produktion der Bestellung benötigt werden.
     * - benoetigteKissen; Anzahl Einheiten Kissen (int), welche für die Produktion der Bestellung benötigt werden.
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
     * Konstruktor der Klasse Lager: initialisiert alle Instanzvariablen der Klasse Lager.
     * Bei Erzeugung eines Lagers wird auch ein zugehöriger Lieferant instanziiert.
     */
    public Lager() {
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;

        benoetigteHolzeinheiten = 0;
        benoetigteSchrauben = 0;
        benoetigteFarbeinheiten = 0;
        benoetigteKartoneinheiten = 0;
        benoetigteKissen = 0;

        lieferant = new Lieferant();
    }

    /**
     * Berechnet, wieviele Materialen für die Kundenbestellung benötigt werden und gibt die Beschaffungszeit zurück je nach Bestand des Lagers.
     *
     * @param kundenBestellung: Die Inhalte einer aufgegebenen Kundenbestellung.
     * @return Beschaffungszeit, welche für die Kundenbestellung benötigt wird.
     */
    public int gibBeschaffungszeit(Bestellung kundenBestellung) {
        int beschaffungszeit = 0;

        for (Produkt product : kundenBestellung.liefereBestellteProdukte()) {
            if (product instanceof Stuhl) {
                benoetigteHolzeinheiten += Stuhl.getHolzeinheiten();
                benoetigteSchrauben += Stuhl.getSchrauben();
                benoetigteFarbeinheiten += Stuhl.getFarbEinheiten();
                benoetigteKartoneinheiten += Stuhl.getKartoneinheiten();
            } else if (product instanceof Sofa) {
                benoetigteHolzeinheiten += Sofa.getHolzeinheiten();
                benoetigteSchrauben += Sofa.getSchrauben();
                benoetigteFarbeinheiten += Sofa.getFarbEinheiten();
                benoetigteKartoneinheiten += Sofa.getKartoneinheiten();
                benoetigteKissen += Sofa.getKissen();
            }
        }

        if (istBestandNiedrig()) {
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
    private boolean istBestandNiedrig() {
        float unteresLimit = 4;
        return maxHolzeinheiten / unteresLimit > vorhandeneHolzeinheiten
                || maxSchrauben / unteresLimit > vorhandeneSchrauben
                || maxFarbeinheiten / unteresLimit > vorhandeneFarbeinheiten
                || maxKartoneinheiten / unteresLimit > vorhandeneKartoneinheiten
                || maxKissen / unteresLimit > vorhandeneKissen;
    }

    /**
     * Zieht die benötigten Materialien für die Kundenbestellung von den vorhandenen Materialien im Lager ab.
     */
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
    public void lagerAuffuellen() {
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;
    }

    /**
     * Druckt den aktuellen Lagerbestand (vorhandene Materialien im Lager) auf der Konsole aus.
     */
    public void lagerBestandAusgeben() {
        System.out.println("Folgende Materialien befinden sich aktuell im Lager:");
        System.out.println("Holzeinheiten: " + vorhandeneHolzeinheiten);
        System.out.println("Schrauben: " + vorhandeneSchrauben);
        System.out.println("Farbeinheiten: " + vorhandeneFarbeinheiten);
        System.out.println("Kartoneinheiten: " + vorhandeneKartoneinheiten);
        System.out.println("Kissen: " + vorhandeneKissen);
    }

    /**
     * Getter-Methode, um den Lieferanten eines Lagers zu erhalten.
     *
     * @return den Lieferanten des Lagers.
     *
     * Anmerkung: Diese Methode wird für die Testklasse "FabrikTest" benötigt, um den Lieferanten anzusprechen und dessen Methodenergebnis zu testen.
     */
    public Lieferant gibLieferant() {
        return lieferant;
    }

    /**
     * Bestellt die benötigten Ressourcen beim Lieferanten
     */
    public void wareLiefern() {
        System.out.println("Die Materialbestellung wurde dem Lieferanten zugestellt.");
        lieferant.start();
    }

}
