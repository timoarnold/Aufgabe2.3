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
     * - warteschlange: In der Warteschlange werden alle Produkte gespeichert, die produziert werden sollen
     * - name: Name des Roboters
     * - produktionsZeit: Die Produktionszeit ist die Zeit, die der Roboter zum Produzieren braucht
     */
    private LinkedList <Produkt> warteschlange;
    public String name;
    private int produktionsZeit;

    /**
     * Konstruktor der Klasse Roboter.
     * Hier wird die LinkedList warteschlange sowie der Name der Roboter instanziiert.
     */
    public Roboter(){
        this.name = name;
        this.warteschlange = new LinkedList<Produkt>();
    }

    /**
     * Die Synchronisierungsmethode syncedPrintIn stellt sicher, dass nur ein Thread zeitgleich auf die Systemressource zugreift.
     * @param message: String Nachricht, welche gedruckt werden soll.
     */
    public static void syncedPrintln(String message) {
        synchronized (System.out) {
            System.out.println(message);
        }
    }
 
    /**
     * Die sleep Methode lässt den Thread um die Zeit zeit schlafen
     *
     * @param zeit, welche der Thread schlafen soll
     */
    public static void sleep(int zeit) {
        try {
            Thread.sleep(zeit);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                syncedPrintln(this.name +": nimmt " + naechstesProdukt + " aus der Warteschlange"); //Kommentar von Cha integriert - unsicher bei name
                produziereProdukt(naechstesProdukt);
                naechstesProdukt.naechsteProduktionsStation();
            }
            Roboter.sleep(1000);
        }
    }

    /**
     * In der Methode fuegeProduktHinzu wird ein zu produzierendes Produkt in die LinkedList Warteschlange hinzugefügt.
     *
     * @param produkt Produkt, welches hinzugefügt wird.
     */
    public void fuegeProduktHinzu(Produkt produkt){
        // Vorschlag Cha fürs Terminal: synchronisiertesPrintln("Roboter " + (hier muss Robotername rein = this?) +": hat " + produkt + " zur Warteschlange hinzugefügt");
        this.warteschlange.add(produkt);
    }

     /**
      * Mit der Methode gibNamen wir der Name des Roboters zurückgegeben.
      *
      * @return Namen des Roboters
      */
    public String gibNamen(){
        return name;
    }

    /**
     * In der Methode produziereProdukt wird die Produktion eines Produktes simuliert. Nachdem die Produktion gestartet wurde, wird
     * der Thread für eine Zeit (=Produktionszeit) schlafen gelegt. Anschliessend kommt die Meldung, dass die Produktion
     * abgeschlossen ist.
     *
     * @param produkt steht für das Produkt, welches produziert wird.
     * 
     */
    // ANM Cha: finde die print Texte irgendwie nicht ganz so intuitiv...
    // ausserdem, können wir irgendwo die Produktionszeit definieren? also einen default setzen?
    private void produziereProdukt (Produkt produkt){
        int ProduktionsZeit = produkt.holeProduktionsZeit(this);
        System.out.println(this + "Produktion wird gestartet: " + produkt + "dauert" + produktionsZeit + "ms");
        Roboter.sleep(produktionsZeit);
        System.out.println(this + "Produktion abgeschlossen: " + produkt);
    }

}

