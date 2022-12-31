import java.util.ArrayList;
import java.util.List;

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
    private Produktions_Manager produktionsManager;

    /**
     * GUIController für die Fabrik wird instanziert
     * @param Fabrik: die Fabrik wird initialisiert
     */
    public GUIController(Fabrik fabrik){
        this.fabrik = fabrik;
        lager = fabrik.getLager();
        produktionsManager = fabrik.gibProduktionsManager();
    }

    /**
     * Die Methode onOrder gibt eine Bestellung auf, welche verarbeitet wird und schliesslich kann die Bestellung aus-
     * gegeben werden.
     */
    public void onOrder(int sofa, int stuhl){
        bestellung = fabrik.bestellungAufgeben(sofa, stuhl);
        fabrik.bestellungVerarbeiten(bestellung);
        fabrik.bestellungenAusgeben();
    }

    /**
     * In der Methode gibBestellBestaetigung wird geprüft, ob die Eingabe valide ist. Falls ja, wird eine Bestellbestätigung
     * wiedergegeben
     * @return gibt ene Bestätigung der Bestellung
     */
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

    /**
     * Die Methode gibAnzahlBestellungen gibt eine Anzahl vorgenommener Bestellungen wieder.
     * @return gibt die Anzahl Bestellungen
     */
    public String gibAnzahlBestellungen(){
        String anzahlBestellungen = "";
        if ((bestellung != null) && (bestellung.gibBestellBestaetigung())){
            return String.valueOf(bestellung.gibBestellNummer());
        }
        return anzahlBestellungen;
    }

    /**
     * Die Methode gibBestellInformationen gibt detaillierte Informationen zur Bestellung.
     * @return gibt Informationen zur Bestellung
     */
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

    /**
     * Die Methode gibt Informationen zum Lager aus.
     * @return gibt Informationen zum Lager als String
     */
    public String gibLagerInformationen(){
        return lager.toString();
    }

    /**
     * Die Methode gibProduktionsStatus ermöglicht, den Status der einzelnen Roboter nach einer Bestellung abzurufen
     * @return gibt den Status der Roboter in der Produktion
     */
    public String gibProduktionsStatus() {
      Roboter holzRoboter = produktionsManager.getHolzRoboter();
      Roboter montageRoboter = produktionsManager.getMontageRoboter();
      Roboter verpackungsRoboter = produktionsManager.getVerpackungsRoboter();
      Roboter lackierRoboter = produktionsManager.getLackierRoboter();
      
      List<Roboter> roboters = new ArrayList<>();
      roboters.add(holzRoboter);
      roboters.add(montageRoboter);
      roboters.add(verpackungsRoboter);
      roboters.add(lackierRoboter);
      
      String produktionsStatus = "";
      
      for (Roboter roboter : roboters) {
        produktionsStatus += roboter.gibName() + "<br/>";
        produktionsStatus += "Status: " + roboter.gibStatus() + "<br/>";
        produktionsStatus += "Anzahl Produkte in der Warteschlange: " + roboter.gibWarteschlange().size() + "<br/>";
        produktionsStatus += "<br/>" + "<br/>";
      }
      
      return produktionsStatus;
    }
}


