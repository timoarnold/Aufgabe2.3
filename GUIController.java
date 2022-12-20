// stimmt dieser GUIController- Beschrieb? :D
/**
 * Der GUIController macht die andere Hälfte der Komponentenschnittstelle aus und
 * ist hauptsächlich die Interaktionshälfte.
 * Er kümmert sich um Maus- und Tastaturereignisse.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUIController {
    private Fabrik fabrik1;
    
    public GUIController(Fabrik fabrik1){
        this.fabrik1 = fabrik1;
    }
    
    //public String onOrder(int sofa, int stuhl){
    //    Bestellung bestellung = fabrik1.bestellungAufgeben(sofa, stuhl);
        // Übung: return order.getOrderStatus();
    //    return bestellung.bestellungenAusgeben();
    //}

    //public String gibtZustand(){
        // Übung: return bakery.getStatus()
    //    return fabrik.gibBestellungen();
    //}
}
