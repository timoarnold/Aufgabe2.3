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
     * Die run Methode des Threats
     */
    public void run(){
        
    }
    
    /**
     * Hier werden Bestellungen der Liste zuVerarbeitendeBestellungen hinzugefügt 
     */
    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){ //nicht sicher ob void stimmt
        zuVerarbeitendeBestellungen.add(bestellung);
    }
    
    // müsste hier nicht auch noch die Liste bestellungenInProduktion angefügt werden? wie für die zuVerarbeitendeBestellungen? Um Bestellungen hinzuzufügen?
    
}
