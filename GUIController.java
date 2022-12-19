
/**
 * Beschrieb noch einfügen.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUIController {
    private Fabrik fabrik1;
    
    public GUIController(Fabrik fabrik1){
        this.fabrik1 = fabrik1;
    }
    
    // da ist was falsch... zudem weiss ich gerade nicht wo wir eine ähnliche Methode zur getBestellBestätigung haben
    public String onOrder(int stuhl, int sofa){
        Bestellung bestellung = fabrik.bestellungAufgeben(stuhl, sofa);
        return fabrik.getBestellungAusgeben();
    }

    public String gibtZustand(){
        return fabrik1.getStatus();
    }
}
