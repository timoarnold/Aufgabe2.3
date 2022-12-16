
/**
 * Beschrieb einfügen.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUIController
{
    private Fabrik fabrik;
    
    public GUIController(Fabrik fabrik){
        this.fabrik = fabrik;
    }
    
    // da ist was falsch... zudem weiss ich gerade nicht wo wir eine ähnliche Methode zur getBestellBestätigung haben
    public String onOrder(int stuhl, int sofa){
        Bestellung bestellung = fabrik.bestellungAufgeben(stuhl, sofa);
        return bestellung.getBestellungAusgeben();
    }
    
    // da auch wo faben wir so eine getter Methode?
    public String onStatus(){
        return fabrik.getStatus();
    }
}
