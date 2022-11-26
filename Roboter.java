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
     * - warteschlange
     * - name
     * - produktionsZeit
     */
    private LinkedList <Produkt> warteschlange;
    private String name;
    private int produktionsZeit;

    /**
     * Konstruktor der Klasse Roboter. Hier wird die LinkedList warteschlange instanziert.
     */
    public Roboter(){
        warteschlange = new LinkedList<Produkt>();
    }

    public static void sleep(int zeit) {
        try {
            Thread.sleep(zeit);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Die run Methode wird als unendliche Schleife implementiert. Hier wird immerwieder überprüft, ob neue Produkte,
     * welche produziert werden müssen, eingetroffen sind. Sollte ein Produkt in der Warteschlange sein, so wird dieses
     * im Roboter produziert.
     */
    @Override
    public void run(){
        while (true){
            Produkt naechstesProdukt = warteschlange.poll();
            if(naechstesProdukt != null){
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

