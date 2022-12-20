
/**
 * Beschrieb noch einfügen.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUIController {
    private Fabrik fabrik;
    
    public GUIController(Fabrik fabrik){
        this.fabrik = fabrik;
    }
    
    public String onOrder(int sofa, int stuhl){
        Bestellung bestellung = fabrik.bestellungAufgeben(sofa, stuhl);
        // Übung: return order.getOrderStatus();
        return fabrik.bestellungenAusgeben();
    }

    public String gibtZustand(){
        // Übung: return bakery.getStatus()
        return fabrik.gibBestellungen();
    }
}
