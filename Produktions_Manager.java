import java.util.LinkedList;

public class Produktions_Manager {
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
     * Konstruktor
     */
    public Produktions_Manager(){

    }

    public void run(){

    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){ //nicht sicher ob void stimmt

    }
}
