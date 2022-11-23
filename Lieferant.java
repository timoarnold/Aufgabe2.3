
/**
 * @author Gruppe 29
 * @version 3.0 (20. November 2022)
 *
 * Die Klasse Lieferant ermöglicht es Bestellungen an den Lieferanten aufzugeben.
 * Bestellte Teile sollen erst in zwei Tagen an das Lager geliefert werden, wobei 1 Stunde = 1 Sekunde ist.
 */

public class Lieferant extends Thread {
    private Lager lager;
    
    public Lieferant (Lager lager)
    {
        super();
        this.lager=lager;
    }

    /**
    * Diese Methode nimmt die zu bestellenden Einheiten entgegen.
    * 
    * @param holzEinheiten: Holzeinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param schrauben: Schrauben, welche im Lager gehalten & zur Produktion benötigt werden
    * @param farbEinheiten: Farbeinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param kartonEinheiten: Kartoneinheiten, welche im Lager gehalten & zur Produktion benötigt werden
    * @param kissen: Kissen, welche im Lager gehalten & zur Produktion benötigt werden
    * @return: Setze auf true, falls eine Bestellung vom Lager eingegangen ist.
    */  
   
   // neu Cha: gemäss Vorlage, kommt das weg  
   //public boolean wareBestellen (int holzEinheiten, int schrauben, int farbEinheiten, int kartonEinheiten, int kissen) {
        //return true;
    //}

    public void run(){
        try{
            // Methode oben beschreiben
            // Wartezeit = 2 Tage; Im Programm ist 1 Stunde = 1 Sekunde und somit 1 Tag = 24 sek
            // Somit muss der Lieferant (der Thread) 48 sek oder 48'000 msek warten (schlafen)
            Thread.sleep(48000);
            System.out.println("Lieferant: Die Ware wurde an das Lager versandt.");
            lager.wareLiefern();
        }
        catch(InterruptedException ie){
            System.out.println("Lieferant: Thread Exception!");
            ie.printStackTrace();
        }

    }
}
