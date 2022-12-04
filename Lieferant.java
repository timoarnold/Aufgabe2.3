
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Lieferant ermöglicht es Bestellungen an den Lieferanten aufzugeben.
 * Sie wird als Thread implementiert, damit bestellte Teile sollen nahc zwei Tagen an das Lager geliefert werden,
 * wobei 1 Stunde = 1 Sekunde ist.
 */

public class Lieferant extends Thread {
    //ANM Timo: für Testing, damit geprüft werden kann, ob Ware geliefert werden kann.
    private boolean istWareGeliefert;

    /**
     * Die run Methode ist die Hauptmethode des Threads.
     * Sie wird als unendliche Schleife implementiert. Hier wird immer wieder überprüft, ob neue Materialien vom Lager
     * bestellt werden. Werden Produkte bestellt, beträgt die Lieferzeit 48 Sekunden (2 Tage im Programm).
     */
    public void run(){
            // Methode oben beschreiben
            // Wartezeit = 2 Tage; Im Programm ist 1 Stunde = 1 Sekunde und somit 1 Tag = 24 sek
            // Somit muss der Lieferant (der Thread) 48 sek oder 48'000 msek warten (schlafen)
            ThreadUtil.sleep(2*24*1000);
            System.out.println("Lieferant: Die Ware wurde an das Lager versandt.");
            istWareGeliefert = true;
    }
    public boolean istWareGeliefert () {
        return istWareGeliefert;
    }
}
