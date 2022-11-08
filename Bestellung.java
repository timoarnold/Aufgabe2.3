import java.util.ArrayList;
/**
 * @author Gruppe 29
 * @version 2.0 (13. November 2022)
 * 
 * Die Klasse Bestellung verwaltet die Array-Liste, in der alle über die Fabrik bestellten
 * Produkte gespeichert werden. Dies können Sofas oder Stühle sein.
 */

public class Bestellung {
    /** 
     * InstanzVariabeln:
     * 
     * - Liste bestellteProdukte: Liste aller Produkte, die bestellt wurden.
     * - bestellBestaetigung: Indikator, ob eine Bestellung erfolgreich bestätigt wurde oder nicht (boolean).
     * - beschaffungsZeit: Beschaffungszeit (in Tagen) für die Produkte (int).
     * - lieferZeit: Lieferzeit (in Tagen) für die jeweiligen Bestellungen (float).
     * - bestellNummer: Nummer einer Bestellung bei Empfang (int).
     * - anzahlStuehle: Anzahl Stühle, die in einer Bestellung nachgefragt wurden (int).
     * - anzahlSofas: Anzahl Sofas, die in einer Bestellung nachgefragt wurden (int).
     * 
     * Klassenvariabeln: 
     * 
     * - BestellnummerGenerator: Generiert bei der ersten Bestellung die Nummer 1, danach wird bei jeder Bestellung +1 zu dieser Zahl addiert. 
     * 
     * Anmerkung: Dies ergibt die Bestellnummer-Variable für jede Bestellung (damit nicht nur die Bestellungsanzahl Total ausgegeben wird)
     * Hier direkt auf 1 initialisiert, damit Bestellung 1 = 1. Danach bei jeder neuen Bestellung plus 1 (Siehe "++" im Konstruktor).
     */
    
    //Klassenvariablen:
    private static int BestellnummerGenerator=1;
    
    //Intanzvariablen:
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung;
    private int beschaffungsZeit;
    private float lieferZeit; 
    private int bestellNummer;
    private int anzahlStuehle;
    private int anzahlSofas;
    
    /**
     * Konstruktor der Klasse Bestellung: initialisiert alle Instanzvariabeln der Klasse Bestellung. 
     * Bei der Initalisierung der Klasse Bestellung wird auch gleichzeitig die ArrayList "bestellteProdukte" mit der Anzahl an bestellten Stühlen und Sofas aufgefüllt.
     * @param anzahlSofas: Anzahl bestellter Sofas einer Bestellung.
     * @param anzahlStuehle: Anzahl bestellter Stühle einer Bestellung.
     */
    
    public Bestellung(int anzahlStuehle, int anzahlSofas) {
        bestellteProdukte = new ArrayList<Produkt>();
        
        for (int i = 0; i < anzahlStuehle; i++){
        bestellteProdukte.add(new Stuhl());
        }
        
        for (int i = 0; i < anzahlSofas; i++){
        bestellteProdukte.add(new Sofa());
        }
        
        bestellBestaetigung = false;
        beschaffungsZeit = 2;
        bestellNummer = BestellnummerGenerator++;
        this.anzahlStuehle = anzahlStuehle;
        this.anzahlSofas = anzahlSofas;
    }

    /**
     * Bestätigt die Bestellung (true).
     * 
     * Anmerkung: Falls noch nicht bestätigt, bleibt diese Variabel 'false'.
     */
    
    public void bestellungBestaetigen() {
        bestellBestaetigung = true;
    }
    
    /**
     * Gib die bestellBestaetigung wieder. 
     * @return Bestellbestätigung
     */
    public boolean gibBestellBestaetigung() {
        return bestellBestaetigung;
    }
    
    /**
     * Frage Flo: Was wollen wir hier machen, Maschinen und Produktion ist ja noch nicht implementiert.
     * 
     * Liefert eine fertig produzierte und zum Versand bereite Kundenbestellung aus. 
     * Aktuell gibt diese Methode nur alle bisher bestellten Produkte aus.
     * 
     * 
     * Anmerkung: Noch nicht fertig implementiert, dient noch als Platzhalten für eine künftige Implementation sobald Produktion & Maschinen eingerichtet.
     */
    public void liefereBestellteProdukte(){
        System.out.println("Total bestellte Produkte bisher:");
        
        for(Produkt einProdukt: bestellteProdukte) {
            
            System.out.println(einProdukt);
            
        }
    }
    
    /**
     * Setze die jeweilige Beschaffungszeit in Abstimmung mit den Lieferanten.
     * @param neueBeschaffungsZeit: Neu gesetzte Zahl für die Beschaffungszeit. 
     */
    public void setzBeschaffungsZeit(int neueBeschaffungsZeit) {
        beschaffungsZeit = neueBeschaffungsZeit; 
    }
    
    /**
     * Gib die Beschaffungszeit wieder.
     * @return die aktuell gesetzte Beschaffungszeit
     */
    public int gibBeschaffungszeit() {
        return beschaffungsZeit;
    }
   
    /**
     * Gib die Bestellnummer wieder.
     * @return Nummer einer Bestellung
     */
    public int gibBestellNummer() {
        return bestellNummer;
    }
    
    /**
     * Gib die Liste der Bestellten Produkte wieder.
     * @return Liste der Produkte in der Bestellung
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return bestellteProdukte;
    }
    
    /**
     * Gib die Anzahl Stuehle wieder.
     * @return die Anzahl Stühle in einer Bestellung
     */
    public int gibAnzahlStuehle() {
        return anzahlStuehle;
    }
    
    /**
     * Gib die Anzahl Sofas wieder.
     * @return die Anzahl Sofas in einer Bestellung
     */
    public int gibAnzahlSofas() {
        return anzahlSofas;
    }
    
    /**
     * Wandelt unterschiedliche Typen in den Typ String um.
     * @return die Bestellnummer, die Anzahl Stühle, die Anzahl Sofas sowie die zugehörige Lieferzeit in der Form des nachfolgend definierten Strings
     * 
     * Anmerkung: Wandelt die Konsolenausgabe der Methode bestellungenAusgeben in die Form String um, 
     * damit diese im Unit-Test auf Übereinstimmung getestet werden kann.
     */
    public String toString() {
        return "Bestellnummer:" + bestellNummer
        + "\nStühle bestellt:" + anzahlStuehle
        + "\nSofas bestellt:" + anzahlSofas
        + "\nIhre Leiferzeit beträgt:" + this.genaueZeit(lieferZeit);
    }
    
    /**
     * Setze den Bestellnummergenerator (Klassenvariable) auf 0 zurück.
     * 
     * Amnmerkung: Dies dient u. A. zum Unit-Testing.
     */
    public static void resetBestellnummerGenerator() {
        BestellnummerGenerator = 1;
    }
    
    /**
     * Setze die aktuelle Lieferzeit einer Bestellung.
     */
    public void setzLieferZeit(float lieferZeit){
        this.lieferZeit = lieferZeit;
    }
    
    /**
     * Berechne die Lieferzeit einer Bestellung in Tagen und Stunden. 
     * @return die berechnete Lieferzeit einer Bestellung in Tagen und Stunden
     * 
     * Anmerkung: Stunden werden jeweils aufgerundet, um dem Kunden keine zu kurze Lieferzeit zu versprechen.
     */
    public String genaueZeit(float lieferZeit){
        String genaueZeit = Math.floor(lieferZeit)+"Tage, ";
        genaueZeit += Math.ceil(lieferZeit%1 *24) + "Stunden"; //wird immer aufgerundet
        //minuten werden (noch) nicht berechnet
        return genaueZeit;
    }
    
    /**
     * Gib die Lieferzeit einer Bestellung.
     * @return Lieferzeit einer Bestellung
     */
    
    // Feedback Cha: Achtung Schreibweise von Lieferzeit --> LieferZeit (bei gibLieferzeit())
    
    public float gibLieferzeit(){
        return lieferZeit;
    }
}
