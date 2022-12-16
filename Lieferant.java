
/**
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 *
 * Die Klasse Lieferant ermöglicht es Bestellungen an den Lieferanten aufzugeben.
 * Sie wird als Thread implementiert, damit bestellte Teile sollen nach zwei Tagen an das Lager geliefert werden,
 * wobei 1 Stunde = 1 Sekunde ist.
 */

public class Lieferant extends Thread {
    /**
     * Instanzvariablen:
     * istWareGeliefert: Boolean um zu sehen, ob die Ware geliefert worden ist
     */
    private boolean istWareGeliefert;

    /**
     * Die run Methode ist die Hauptmethode des Threads.
     * Sie wird als unendliche Schleife implementiert. Hier wird immer wieder überprüft, ob neue Materialien vom Lager
     * bestellt werden. Werden Produkte bestellt, beträgt die Lieferzeit 48 Sekunden (2 Tage im Programm).
     */
    public void run(){
            ThreadUtil.sleep(2*24*1000);
            System.out.println("Lieferant: Die Ware wurde an das Lager versandt.");
            istWareGeliefert = true;
    }

    /**
     * Mit dieser Methode wird der Boolean zurückgegeben, um zu sehen, ob die Ware geliefert worden ist. Wird für die Testklasse benötigt.
     * @return Boolean, ob ware geliefert worden ist.
     */
    public boolean istWareGeliefert () {
        return istWareGeliefert;
    }
}
