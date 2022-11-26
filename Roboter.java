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

    public Roboter(){
        warteschlange = new LinkedList<>();
    }

    public static void sleep(int zeit) {
        try {
            Thread.sleep(zeit);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    public void fuegeProduktHinzu(Produkt produkt){
        this.warteschlange.add(produkt);
    }

    /**
     * setzteProduktionsZeit ist doppelt implementiert. Vgl. Kommentar in Produkt
     * @return
     */
    //public void setzteProduktionsZeit(int zeit){

    //}

    public String gibNamen(){
        return name;
    }

    private void produziereProdukt (Produkt produkt){
        int ProduktionsZeit = produkt.holeProduktionsZeit(this);
        System.out.println(this + "Produktion wird gestartet: " + produkt + "für" + produktionsZeit + "ms");
        Roboter.sleep(produktionsZeit);
        System.out.println(this + "Produktion abgeschlossen: " +produkt);
    }

}

