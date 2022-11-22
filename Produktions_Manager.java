import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert.
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
     * Konstruktor der Klasse Produktions_Manager: initialisiert alle Instanzvariabeln der Klasse Produktions_Manager.
     * Bei der Initalisierung der Klasse Produktions_Manager ....
     * @param ... .
     */
    public Produktions_Manager(){

    }

    public void run(){

    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){ //nicht sicher ob void stimmt

    }
}
