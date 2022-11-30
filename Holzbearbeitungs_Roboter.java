
/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Klasse Holzbearbeitungs_Roboter erweitert die Klasse Roboter und simuliert den Arbeitsschritt des Holzberarbeitens.
 *
 */

public class Holzbearbeitungs_Roboter extends Roboter {

    /**
     * Konstruktor für die Objekte der Klasse Holzbearbeitungs_Roboter
     */

    public Holzbearbeitungs_Roboter()
    {
        super();
        name = "Holzbearbeitungsroboter1";
    }
    public void run(){
        try{
            // Wartezeit = 2 Tage; Im Programm ist 1 Stunde = 1 Sekunde und somit 1 Tag = 24 sek
            // Somit muss der Lieferant (der Thread) 48 sek oder 48'000 msek warten (schlafen)
            System.out.println("Holzbearbeitung gestartet");
            Thread.sleep(10/60*24*1000);
            System.out.println("Holzbearbeitung beendet");
            //Zustand ändern

        }
        catch(InterruptedException ie){
            System.out.println("Lieferant: Thread Exception!");
            ie.printStackTrace();
        }
    }


}
