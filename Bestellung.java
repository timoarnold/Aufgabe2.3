import java.util.ArrayList;
/**
 * @author Gruppe 29
 * @version 1.0 (28. Oktober 2022)
 * 
 * Die Klasse Bestellung verwaltet die Array-Liste, in der alle über die Fabrik bestellten
 * Produkte gespeichert werden. Dies können Sofas oder Stühle sein.
 */

public class Bestellung {
    /** 
     * InstanzVariabeln:
     * 
     * - Liste bestellteProdukte: Liste alle Produkte, die bestellt wurden.
     * - bestellBestaetigung: Indikator, ob eine Bestellung erfolgreich bestätigt wurde oder nicht (boolean).
     * - beschaffungsZeit: Lieferzeit (in Tagen) für die Produkte (int).
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
    private int bestellNummer;
    private int anzahlStuehle;
    private int anzahlSofas;
    
    /**
     * Konstruktor der Klasse Bestellung: initialisiert alle Instanzvariabeln der Klasse Bestellung. 
     * Bei der Initalisierung der Klasse Bestellung wird auch gleichzeitig die ArrayList "bestellteProdukte" mit der Anzahl an bestellten Stühlen und Sofas aufgefüllt.
     * 
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
     * @return die Bestellnummer, die Anzahl Stühle und die Anzahl Sofas in der Form des nachfolgend definierten Strings
     * 
     * Anmerkung: Wandelt die Konsolenausgabe der Methode bestellungenAusgeben in die Form String um, 
     * damit diese im Unit-Test auf Übereinstimmung getestet werden kann.
     */
    public String toString() {
        return "Bestellnummer:" + bestellNummer + "\nStühle bestellt:" + anzahlStuehle + "\nSofas bestellt:" + anzahlSofas;
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
     * !!! Anschauen, gibt noch den Speicherort aus, aber immerhin erkennt es die Stühle und Sofas.
     * Beschrieb Methode
     */
    public void liefereBestellteProdukte(){
        System.out.println("Total bestellte Produkte bisher:");
        
        for(Produkt einProdukt: bestellteProdukte) {
            
            System.out.println(einProdukt);
            
        }
    }
    
    /**
     * Kommentar zu Methode
     */
    public void setzeLieferzeit(float lieferZeit){
        //
    }
    
    /**
     * Methodenkommentar
     */
    //public float gibLieferzeit(){
        //return lieferZeit;
    //}
}
