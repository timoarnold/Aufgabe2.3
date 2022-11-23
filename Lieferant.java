
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Lieferant ermöglicht es Bestellungen an den Lieferanten aufzugeben.
 * Bestellte Teile sollen erst in zwei Tagen an das Lager geliefert werden, wobei 1 Stunde = 1 Sekunde ist.
 */

public class Lieferant extends Thread {
    private Lager lager;
    
    /**
     * Konstruktor
     */
    public Lieferant (Lager lager)
    {
        super();
        this.lager=lager;
    }

    public void run(){
        try{
            // Methode oben beschreiben
            // Wartezeit = 2 Tage; Im Programm ist 1 Stunde = 1 Sekunde und somit 1 Tag = 24 sek
            // Somit muss der Lieferant (der Thread) 48 sek oder 48'000 msek warten (schlafen)
            Thread.sleep(2*24*1000);
            System.out.println("Lieferant: Die Ware wurde an das Lager versandt.");
            lager.wareLiefern();
        }
        catch(InterruptedException ie){
            System.out.println("Lieferant: Thread Exception!");
            ie.printStackTrace();
        }

    }
}
