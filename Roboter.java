import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert.
 */
public class Roboter extends Thread {
    /**
     * Instanzvariablen:
     *
     * - warteschlange: In der Warteschlange werden alle Produkte gespeichert, die produziert werden sollen.
     * - name: Name des Roboters.
     */
    private LinkedList <Produkt> warteschlange;
    private String name;

    /**
     * Konstruktor der Klasse Roboter.
     * Hier wird die LinkedList warteschlange sowie der Name der Roboter instanziiert.
     */
    public Roboter(String name){
        this.name = name;
        warteschlange = new LinkedList<>();
    }

    /**
     * Die run Methode ist die Hauptmethode des Threads. 
     * Sie wird als unendliche Schleife implementiert. Hier wird immer wieder überprüft, ob neue Produkte,
     * welche produziert werden müssen, eingetroffen sind. Sollte ein Produkt in der Warteschlange sein, so wird dieses
     * im Roboter produziert.
     */
    @Override
    public void run(){
        while (true){
            Produkt naechstesProdukt = warteschlange.poll();
            if(naechstesProdukt != null){
                produziereProdukt(naechstesProdukt);
                naechstesProdukt.starteNaechsteProduktionsStation();
            }
            ThreadUtil.sleep(1000);
        }
    }

    /**
     * In der Methode fuegeProduktHinzu wird ein zu produzierendes Produkt in die LinkedList Warteschlange hinzugefügt.
     *
     * @param produkt Produkt, welches hinzugefügt wird.
     */
    public void fuegeProduktHinzu(Produkt produkt){
        this.warteschlange.add(produkt);
    }

     /**
      * Mit der Methode gibNamen wird der Name des Roboters zurückgegeben.
      *
      * @return Namen des Roboters
      */
    public String gibName(){
        return name;
    }
    
    /**
     * Mit dieser Methode wird der Produktionsstatus des Roboters zurückgegeben.
     * 
     * @return Produktionsstatus des Roboters.
     */
    public String gibStatus() {
      if(warteschlange.isEmpty()) {
        return "Nicht in Produktion";
      }
      
      return "In Produktion";
    }
    
    /**
     * Diese Methode gibt die Liste aller Produkte, die in der Warteschlange sind.
     * 
     * @return Liste aller Produkte in der Warteschlange.
     */
    public LinkedList<Produkt> gibWarteschlange() {
      return warteschlange;
    }

    /**
     * In der Methode produziereProdukt wird die Produktion eines Produktes simuliert. Nachdem die Produktion gestartet wurde, wird
     * der Thread für eine Zeit (=Produktionszeit) schlafen gelegt. Anschliessend kommt die Meldung, dass die Produktion
     * abgeschlossen ist.
     *
     * @param produkt steht für das Produkt, welches produziert wird.
     * 
     */
    private void produziereProdukt (Produkt produkt){
        int produktionsZeit = produkt.holeProduktionsZeit(this);
        ThreadUtil.syncedPrintln("[" + this.gibName() + "]" + " Produktion wird gestartet: " + produkt + " mit Bestellnummer " + produkt.getBestellNummer() + " dauert " + produktionsZeit + " min");
        ThreadUtil.sleep((int)rechneProduktionsZeitInMillisekundenUm(produktionsZeit));
        ThreadUtil.syncedPrintln("[" + this.gibName() + "]" + " Produktion abgeschlossen: " + produkt + " mit Bestellnummer " + produkt.getBestellNummer());
    }

    /**
     * In dieser methode wird die Produktionszeit der Roboter (in Minuten) in Millisekunden umgerechnet nach dem Schema: 1 Stunde = 1 Sekunde.
     * @param produktionsZeit
     * @return umgerechnete Produktionszeit.
     */
    private float rechneProduktionsZeitInMillisekundenUm (int produktionsZeit) {
        return (float)produktionsZeit/60*1000;
    }
}

