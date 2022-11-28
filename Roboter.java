import java.util.LinkedList;
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Produktions_Manager arbeitet neu eintreffende Bestellung ab und leitet diese den Robotern zur Produktion weiter.
 * Sie wird als Thread implementiert.
 *
 */
public class Roboter extends Thread {
    /**
     * Instanzvariablen
     * - warteschlange: In der Warteschlange werden alle Produkte gespeichert, die produziert werden sollen
     * - name: Name des Roboters
     * - produktionsZeit: Die Produktionszeit ist die Zeit, die der Roboter zum Produzieren braucht
     */
    private LinkedList <Produkt> warteschlange;
    private String name;
    private int produktionsZeit;

    /**
     * Konstruktor der Klasse Roboter. Hier wird die LinkedList warteschlange instanziert.
     * 
     * ANM Cha: Müssen wir hier nicht den Roboter an sich isntanzieren?
     * Laut Definition soll ein neue Objekt dieser Klasse erstellt werden und das wäre der Roboter oder und nicht die Liste?
     * @param name des Roboters ?
     * Und linked list produkt warteschlange als neue linkedlist oben instanzieren?
     * 
     */
    public Roboter(){
        warteschlange = new LinkedList<Produkt>();
    }

    // ANM Cha: habe hier nochmals synchronisiertesPrintln hinzugefügt, damit immer wieder der Status geprintet wird (wie im Produktionsmanager auch)
    // Beschrieb noch analog zu PM hinzufügen
    private void synchronisiertesPrintln(String output){
        synchronized (System.out){
            System.out.println(output);
        }        
    }
 
    /**
     * Die sleep Methode lässt den Thread um die Zeit zeit schlafen
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
            // ANM Cha: warum kommt dieser poll vor them if? wird nicht zuerst mit dem !_ null gecheggt, ob ein nächstes Produkt da ist 
            // und erst dann nimmt es das nächste raus mit der poll Funktion?
            Produkt naechstesProdukt = warteschlange.poll();
            if(naechstesProdukt != null){
                // Vorschlag Cha fürs Terminal: synchronisiertesPrintln("Roboter " + this +": nimmt " + produkt + " aus der Warteschlange");
                produziereProdukt(naechstesProdukt);
                naechstesProdukt.naechsteProduktionsStation();
            }
            Roboter.sleep(1000); //Wie lange soll er hier schlafen?
        }
    }

    /**
     * In der Methode fuegeProduktHinzu wird ein zu produzierendes Produkt in die LinkedList Warteschlange hinzugefügt.
     * @param produkt Produkt, welches hinzugefügt wird.
     */
    public void fuegeProduktHinzu(Produkt produkt){
        // Vorschlag Cha fürs Terminal: synchronisiertesPrintln("Roboter " + this +": hat " + produkt + " zur Warteschlange hinzugefügt");
        this.warteschlange.add(produkt);
    }

    /**
     * setzteProduktionsZeit ist doppelt implementiert. Vgl. Kommentar in Produkt
     * @return
     */
    //public void setzteProduktionsZeit(int zeit){

    //}

 // Anm Tim: verstehe nicht genau, wofür die Methode gibNamen benötigt wird...
    public String gibNamen(){
        return name;
    }

    /**
     * In der Methode produziereProdukt wird die Produktion simuliert. Nachdem die Produktion gestartet wurde, wird
     * der Thread für eine Zeit (=Produktionszeit) schlafen gelegt. Anschliessend kommt die Meldung, dass die Produktion
     * abgeschlossen ist.
     * @param produkt steht für das Produkt, welches produziert wird.
     */
    private void produziereProdukt (Produkt produkt){
        int ProduktionsZeit = produkt.holeProduktionsZeit(this);
        System.out.println(this + "Produktion wird gestartet: " + produkt + "für" + produktionsZeit + "ms");
        Roboter.sleep(produktionsZeit);
        System.out.println(this + "Produktion abgeschlossen: " +produkt);
    }

}

