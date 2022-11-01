import java.util.ArrayList;
import java.io.*;
/**
 * @author Gruppe 29
 * @version 1.0 (28. Oktober 2022)
 * 
 * Die Klasse Fabrik bildet die Schnittstelle zwischen Kund:innen und Produktion.
 * Sie nimmt Bestellungen entgegen und verwaltet diese.
 */
public class Fabrik {
    /** 
     * Instanzvariabeln:
     * 
     * - bestellungen: Array-Liste, in der alle eingegangenen Bestellungen als Typ <Bestellung> abgespeichert werden.
     * - bestellungsNr: Nummer, welche jeder Bestellung aufsteigend zugeordnet wird, beginnend bei 1 (int).
     */
   
    private ArrayList<Bestellung> bestellungen; 
    private int bestellungsNr;

    /**
     * Konstruktor für Objekte der Klasse Fabrik: Hier werden die Instanzvariabeln (siehe oben) initialisiert.
     */
    
    public Fabrik() {
        bestellungen = new ArrayList<Bestellung>();
        bestellungsNr = 0;
    }

    /**
     * Ermöglichst den Einstieg ins Programm
     * - weiterBestellen: Gibt an, ob weiterbestellt wird oder nicht.
     * - validerInput: Gibt an, ob die Bestelleingabe valide ist oder nicht.
     * 
     * Anmerkung: 
     * Durch die Main-Methode wird ein Dioalogsystem aufgerufen, in welcher der User Bestellungen für Sofas und Stühle aufgeben kann
     * (Durchführung der Methode bestellungAufgeben).
     * Der User kann nach einer Bestellung entscheiden, ob er weiter bestellen möchte.
     * Sobald sich der User entscheidet, nicht mehr weiterzubestellen, wird eine Zusammenfassung der Bestellungen ausgegeben 
     * (Durchführung der Methode bestellungsAusgeben).
     * Ausserdem die Inputs des Users überprüft, sodass die geforderten Informationen angegeben werden.
     */
    
    public static void main(String[] args) {
        
        System.out.println("Ausgabe aus der main()-Methode:");
        Fabrik fabrik= new Fabrik();
        
        boolean weiterBestellen = true;
        boolean validerInput = true;
        
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Willkommen bei AEKI");
        
        while(weiterBestellen){
            int anzahlSofas;
            int anzahlStühle;
            String weiterBestellenString;
            
            try{
                if(validerInput){
                    System.out.println("Geben Sie die Anzahl Sofas an, welche Sie bestellen möchten: ");
                    anzahlSofas = Integer.parseInt(infile.readLine().trim());
                    System.out.println("Geben Sie die Anzahl Stühle an, welche Sie bestellen möchten: ");
                    anzahlStühle = Integer.parseInt(infile.readLine().trim());
                    fabrik.bestellungAufgeben(anzahlSofas, anzahlStühle);
                }
                System.out.print("Möchten Sie weiter bestellen? (ja/nein)");
                weiterBestellenString = infile.readLine();
                if(weiterBestellenString.equals("ja")){
                    validerInput = true;
                } 
                else if(weiterBestellenString.equals("nein")){
                    weiterBestellen = false;
                    validerInput = true;
                }
                else{
                    System.out.println("Invalider Input. Bitte geben Sie ja oder nein ein.");
                    validerInput = false;
                }
            } 
            catch(Exception E){
                System.out.println("Invalider Input. Bitte geben Sie eine Zahl ein.");
            }
        }
        fabrik.bestellungenAusgeben();
    }
        
    
    /** 
     * Bestellung aufgeben.
     * @param sofa: Anzahl Sofas, die in einer Bestellung bestellt wurden.
     * @param stuhl: Anzahl Stühle, die in einer Bestellung bestellt wurden.
     * 
     * Anmerkung: Durch bestellungAufgeben wird eine neue Instanz der Klasse Bestellung erstellt, die Bestellung bestätigt und in der Array "bestellungen" gespeichert. 
     * Bei jeder erfolgreichen Bestellausgabe, wird auf der Konsole eine Message ausgespielt.
     * In der folgenden Methode wird zudem festgelegt, dass die Bestellung nur positive Werte enthalten darf (Keine Minusbestellungen, sonst Fehlermeldung).
     */
    public void bestellungAufgeben(int sofa, int stuhl) {
          if (sofa<0 || stuhl<0 || sofa+stuhl==0){
               System.out.println("Bitte geben sie eine positiven Bestellbetrag ein");
           }
           else {
               bestellungsNr++;
               
               Bestellung bestellung = new Bestellung(sofa, stuhl);
               bestellung.bestellungBestaetigen();
               bestellungen.add(bestellung);
           
               System.out.println("Bestellung erfolgreich aufgegeben");
           }
    }
    
    /**
     * Gib die Bestellungsnummer wieder.
     * @return die Nummer der letzten Bestellung, die aufgegeben wurde (=Totale Anzahl Bestellungen bisher)
     */
    public int gibBestellungsNr() {
        return bestellungsNr;
    }
    
    /**
     * Gib die Bestellungen wieder.
     * @return ArrayListe bestellungen
     * 
     * Anmerkung: Diese Methode dient den Unit-Tests im Rahmen der Testklasse FabrikTest.
     * Sie gibt die Bestellungsinformationen für den Unit-Test zur Methode Bestellung auf- und ausgeben wieder.
     */
    public ArrayList<Bestellung> gibBestellungen() {
        return bestellungen;
    }
   
    /**
     * Gib die Bestellungen inkl. Details wieder.
     * 
     * Anmerkung: Für jede Bestellung aus der Liste bestellungen, gibt die Konsole die unten programmierte Print-Meldung aus. 
     * Diese Methode gibt somit alle Informationen (Anzahl Stühle / Anzahl Sofas / Bestellungen Total / Bestellungsnummer) 
     * für alle aufgegebenen Bestellungen wieder.
     */
    public void bestellungenAusgeben() {

        System.out.println("Total Bestellungen bisher:"+bestellungsNr);
        
        for(Bestellung eineBestellung: bestellungen) {
            
            System.out.println(eineBestellung);
            
        }
    }
    
    /**
     * Gib die Informationen einer spezifischen Bestellung wieder.
     * @param spannendeBestellungNr: Nummer einer einzelnen, ausgegebenen Bestellung.
     *   
     * Anmerkung: Dazu muss diese Methode mit der gewünschten Bestellungsnummer aufgerufen werden.
     */
    public void bestellungAusgeben(int spannendeBestellungNr) {
        
        
        System.out.println("Details der Bestellung mit der Nummer:" + spannendeBestellungNr);
        
        for(Bestellung eineBestellung: bestellungen) {
            
            if(spannendeBestellungNr==eineBestellung.gibBestellNummer()){
            System.out.println(eineBestellung);
            }
    
        }
    
    }
}