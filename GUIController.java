import java.util.ArrayList;
import java.util.List;

/**
 * Der GUIController ist die Schnittstelle zwischen der GUI und dem Modell Fabrik. 
 * Er hört auf Maus- und Tastaturereignisse, die vom GUI ausgelöst werden und teilt diese der Fabrik mit. 
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUIController {
  
  /**
   * Instanzvariablen:
   * 
   * - fabrik: Instanzvariable vom Type Fabrik, die Bestellungen entgegen nimmt und verwaltet.
   * - lager: Das zur Fabrik gehörende Lager (jeweils eines).
   * - bestellung: Die Bestellung, welche vom Produktionsmanager verabeitet wird.
   * - produktionsManager: Der Manager, welcher neu eintreffende Bestellungen verarbeitet und den jeweiligen Robotern zuweist.
   * 
   */
    private Fabrik fabrik;
    private Lager lager;
    private Bestellung bestellung;
    private Produktions_Manager produktionsManager;

    /**
     * GUIController für die Fabrik wird instanziert
     * 
     * @param fabrik: die Fabrik wird initialisiert
     */
    public GUIController(Fabrik fabrik){
        this.fabrik = fabrik;
        lager = fabrik.getLager();
        produktionsManager = fabrik.gibProduktionsManager();
    }
    
    /**
     * Diese Methode nimmt die Anzahl Stühle und Sofas, die von der Kundin oder
     * vom Kunden im GUI eingegeben werden, entgegen und leitet diese Information der Fabrik weiter.
     * 
     * @param sofa: Anzahl Sofas die im GUI eingeben und bestellt werden.
     * @param stuhl: Anzahl Stühle die im GUI eingeben und bestellt werden.
     */
    public void onOrder(int sofa, int stuhl){
        bestellung = fabrik.bestellungAufgeben(sofa, stuhl);
        fabrik.bestellungVerarbeiten(bestellung);
        fabrik.bestellungenAusgeben();
    }

    /**
     * In der Methode gibBestellBestaetigung wird geprüft, ob die Eingabe valide ist. Falls ja, wird eine Bestellbestätigung
     * wiedergegeben.
     * 
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
     * Diese Methode gibt die Anzahl Bestellungen zurück, die im GUI dargestellt werden soll.
     * 
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
     * Mit dieser Methode werden die Informationen aller bisherigen erfolgreichen Bestellungen zurückgegeben,
     * die im GUI dargestellt werden soll. 
     * 
     * @return Bestellinformationen der bisherigen Bestellungen.
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
     * Diese Methode gibt die Informationen zum Lagerbestand zurück, die im GUI angezeigt werden soll.
     * 
     * @return Informationen zum Lagerbestand als String
     */
    public String gibLagerInformationen(){
        return lager.toString();
    }
    
    /**
     * Mit dieser Methode werden die Produktionsstatus-Informationen der einzelnen Roboter züruckgegeben,
     * die im GUI angezeigt werden soll. 
     * 
     * @return gibt die Produktionsstatus der einzelnen Roboter.
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


