import java.util.LinkedList;

/**
 * Beschrieb der Klasse noch final anschauen/hinzufügen
 * In dieser Klasse ist der Produktionsmanager implementiert. 
 * Die Klasse ist als Thread implementiert, damit sie immer wieder neu eintreffende Bestellungen abarbeiten und den Robotern zum Produzieren geben kan.
 */
public class Produktions_Manager extends Thread {
    /**Instanzvariablen
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
     * Zwei LinkedLists wurden implementiert, um die zu verarbeitende Bestellungen und die Bestellungen in Produkttion zu verwalten.
     */
    public Produktions_Manager(){

    }

    public void run(){

    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){ //nicht sicher ob void stimmt

    }
}
