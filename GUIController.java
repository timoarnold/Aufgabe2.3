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
    private Fabrik fabrik;
    private Lager lager;
    private Bestellung bestellung;
    
    public GUIController(Fabrik fabrik){
        this.fabrik = fabrik;
        lager = fabrik.getLager();
    }
    
    public void onOrder(int sofa, int stuhl){
        // Bestellung bestellung = fabrik1.bestellungAufgeben(sofa, stuhl);
        bestellung = fabrik.bestellungAufgeben(sofa, stuhl);
        fabrik.bestellungVerarbeiten(bestellung);
        fabrik.bestellungenAusgeben();
        // Übung: return order.getOrderStatus();
        // return fabrik1.bestellungenAusgeben();
    }

    public String gibBestellBestaetigung(){
        String bestellBestaetigung = "";

        if (bestellung == null) {
            return "Bitte geben Sie einen positiven Bestellbetrag ein.";
        }

        if (bestellung.gibBestellBestaetigung()) {
            bestellBestaetigung = "Bestellung erfolgreich aufgegeben!";
        }
        return bestellBestaetigung;
    }

    public String gibAnzahlBestellungen(){
        String anzahlBestellungen = "";

        if ((bestellung != null) && (bestellung.gibBestellBestaetigung())){
            return String.valueOf(bestellung.gibBestellNummer());
        }

        return anzahlBestellungen;
    }

    public String gibBestellInformationen(){
        String bestellInformationen = "";

        if ((bestellung != null) && (bestellung.gibBestellBestaetigung())){
            bestellInformationen = "<br/>Total Bestellungen bisher: " + bestellung.gibBestellNummer();
            for (Bestellung bestellung : fabrik.gibBestellungen()) {
                bestellInformationen += "<br/>" + bestellung;
            }
        }

        return bestellInformationen;
    }

    public String gibLagerInformationen(){
        return lager.toString();

    }
}


