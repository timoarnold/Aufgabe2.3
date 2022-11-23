import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert, damit sie immer wieder neu eintreffende Bestellungen abarbeiten und den Robotern zum Produzieren geben kann.
 *
 */

public class Produktions_Manager extends Thread {
    /**Instanzvariablen:
     *
     * - holzRoboter
     * - montageRoboter
     * - lackierRoboter
     * - verpackungsRoboter
     * - meineFabrik
     * - meinLager
     * - zuVerarbeitendeBestellungen
     * - bestellungenInProduktion
     */
    
    private Holzbearbeitungs_Roboter holzRoboter;
    private Montage_Roboter montageRoboter;
    private Lackier_Roboter lackierRoboter;
    private Verpackungs_Roboter verpackungsRoboter;
    
    private Fabrik meineFabrik;
    private Lager meinLager;
    
    private LinkedList <Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList <Bestellung> bestellungenInProduktion;

    /**
     * Konstruktor für die Klasse Produktionsmanager
     * Hier sind alle Roboter als Threads instanziert und werden gestartet.
     * Zwei LinkedLists wurden implementiert, um die zu verarbeitende Bestellungen und die Bestellungen in Produktion zu verwalten.
     */
    public Produktions_Manager(Fabrik meineFabrik, Lager meinLager){
        zuVerarbeitendeBestellungen = new LinkedList<Bestellung>();
        bestellungenInProduktion = new LinkedList<Bestellung>();
    
        this.meineFabrik = meineFabrik;
        this.meinLager = meinLager;
    
        holzRoboter = new Holzbearbeitungs_Roboter("Holzroboter");
        montageRoboter = new Montage_Roboter("Montageroboter");
        lackierRoboter = new Lackier_Roboter("Lackierroboter");
        verpackungsRoboter = new Verpackungs_Roboter("Verpackungsroboter");
    
        holzRoboter.start();
        montageRoboter.start();
        lackierRoboter.start();
        verpackungsRoboter.start();
    }

    /**
     * Die run Methode des Threats prüft immer wieder, ob eine neue Bestellung eingetroffen ist.
     * Bestellungen werden dann aus der Liste der zu verarbeitenden Bestellungen rausgenommen 
     * und in die Liste der zu produzierenden Bestellungen (bestellungenInProduktion) gespeichert.
     * Wenn im Lager genügend Material vorhanden ist, wird somit die Produktion gestartet.
     * 
     * Zudem wird bei der Produktion geprüft, ob eine Bestellung abgeschlossen ist.
     * Wenn ja, wird die Bestellung von der zu produzierenden Bestellungen gelöscht.
     * Gleichzeitig wird  in der Klasse Bestellung festgehalten, dass die Produkte produziert und bereit auszuliefern sind.
     * 
     * Schliesslich soll der Thread um die Zeit zeit schlafen
     * @param zeit die der Thread schlafen soll
     */
    // Frage Cha: kann man das für die Zeit so integriert in der run Methode lassen? kann die Zeit schon definiert werden? zB 100?
    public void run(){
        while(true){
            // ist neue Bestellung eingetroffen, dann
            // hole die nächste Bestellung und starte die Produktion
            // wenn alle Produkte produziert sind, dann
                // if(alleProdukteProduziert){
                // bestellungenInProduktion.remove(bestellung);
                // bestellung.setzeAlleProdukteProuziert();
                //}
            // dann lass den Thread eine kurze Weile schlafen
        try{
            Thread.sleep(zeit);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
    }
    
    /**
     * Hier werden Bestellungen der Liste zuVerarbeitendeBestellungen hinzugefügt 
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){ //nicht sicher ob void stimmt
        zuVerarbeitendeBestellungen.add(bestellung);
    }
    
    // müsste hier nicht auch noch die Liste bestellungenInProduktion angefügt werden? wie für die zuVerarbeitendeBestellungen? Um Bestellungen hinzuzufügen?
    
    /**
     * In der Methode starteProduktion wird jedem Produkt der Bestellung
     * die entsprechenden Roboter zugewiesen und die Produktion dadurch gestartet.
     */
   private void starteProduktion(Bestellung bestellung){
        // Cha: hier muss jedem Produkt ein Roboter alloziert werden
    }
    
    /**
     * In der Methode alloziereRoboter werden für jedes Produkt die entsprechenden Roboter in der richtigen Reihenfolge festgelegt.
     * Die Information zur Reihenfolge wird im Produkt selbst gespeichert.
     */
   private void alloziereRoboter(Produkt produkt){
        LinkedList<Roboter> bearbeitungsReihenfolge = new LinkedList<Roboter>();
        // Cha: hier muss die Reihenfolge der Roboter festgelegt werden
        // if(){
            // if das Produkt Stuhl ist dann --> Reihenfolge der Roboter für Stuhl auflisten
        // }
        // else if(){
            // else if Produkt Sofa --> Reihenfolge der Roboter für Sofa auflisten
        //}
    }
}
