import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * @author Gruppe 29
 * @version 2.0 (13. November 2022)
 * 
 * Die Test-Klasse FabrikTest verwaltet alle Unit-Tests der Software. 
 */
public class FabrikTest
{
    private Fabrik fabrik; 

    /**
     * Vor jedem Unit-Test der Klasse Fabrik und deren Inhalten, wird eine neue Fabrikinstanz erstellt.
     */
    @BeforeEach
    public void setUp()
    {
       fabrik = new Fabrik(); 
    }

    /**
     * Anweisungen, welche nach jedem Unit-Test ausgeführt werden. 
     * In diesem Fall: (Noch) keine.
     */
    @AfterEach
    public void tearDown()
    {
        
    }
    
    /**
     * Testet, ob die richtige Bestellnummer ausgegeben wird, wenn Instanz Fabrik 
     * erzeugt und 2 Testbestellungen aufgegeben werden.
     */
    @Test
    public void TestBestellungsNummer(){
        //Arrange: Siehe BeforeEach
        
        //Act: Zwei Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(2,3);
        fabrik.bestellungAufgeben(1,1);

        //Assert: Check, ob Ergebnis == erwartetes Ergebnis
        assertEquals(2, fabrik.gibBestellungsNr());
    }
    
    /**
     * Hier wird getestet, ob die erste (Index 0) und die zweite (Index 1) Bestellung der ArrayList bestellungen den Erwartungen entspricht.
     * 
     * Merke: Testfabrik.gibBestellungen().get(0).toString() entspricht System.out.println(eineBestellung) aus Fabrik.bestellungAusgeben
     */
    
    @Test
    public void TestBestellungAusgeben(){
        //Arrange: Siehe BeforeEach
        
        //Act: Zwei Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(2,3);
        fabrik.bestellungAufgeben(6,6);
        
        //Assert: Check, ob Ausgabe der Bestellung == erwartete / korrekte Ausgabe
        assertEquals("Bestellnummer:"+1+"\nSofas bestellt:"+2+"\nStühle bestellt:"+3+"\nIhre Lieferzeit beträgt:1.0Tage, 4.0Stunden",fabrik.gibBestellungen().get(0).toString());
        assertEquals("Bestellnummer:"+2+"\nSofas bestellt:"+6+"\nStühle bestellt:"+6+"\nIhre Lieferzeit beträgt:1.0Tage, 9.0Stunden",fabrik.gibBestellungen().get(1).toString());
    }
    
    /**
     * Hier wird getestet, ob Bestellungen korrekt aufgegeben werden können.
     * 
     * Merke:BestellnummerGenerator wird nach diesem Test auf 1 zurückgesetzt, damit die Bestellnummern in weiteren Unit-Tests erneut 
     * von Anfang an hochzählen können. 
     */
    @Test
    public void TestBestellungAufgeben(){
        //Arrange: Siehe BeforeEach
        
        //Act: Testbestellung wird aufgegeben
        fabrik.bestellungAufgeben(4,7);
        
        
        //Assert: Check, ob die richtige Anzahl Stühle und Sofas ausgegeben wird
        assertEquals(4, fabrik.gibBestellungen().get(0).gibAnzahlSofas());
        assertEquals(7, fabrik.gibBestellungen().get(0).gibAnzahlStuehle());
        
        Bestellung.resetBestellnummerGenerator();
    }
    
    /**
     * Hier wird getestet, ob mehrere Bestellungen korrekt aufgegeben und ausgegeben werden können.
     * Dazu wird die zweite Bestellung auf die Korrektheit ihrer Werte (Stühle & Sofas) geprüft.
     * 
     * Merke:BestellnummerGenerator wird nach diesem Test auf 1 zurückgesetzt, damit die Bestellnummern in weiteren Unit-Tests erneut 
     * von Anfang an hochzählen können. 
     */
    @Test
    public void TestMehrereBestellungenAufgeben(){
        //Arrange: Siehe BeforeEach
        
        //Act: Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(4,7);
        fabrik.bestellungAufgeben(3,2);
        fabrik.bestellungAufgeben(9,5);
        
        assertEquals(1,fabrik.gibBestellungen().get(0).gibBestellNummer());
        assertEquals(2,fabrik.gibBestellungen().get(1).gibBestellNummer());
        assertEquals(3,fabrik.gibBestellungen().get(2).gibBestellNummer());
        
        //Assert: Check, ob die richtige Anzahl Stühle und Sofas ausgegeben werden
        assertEquals(3, fabrik.gibBestellungen().get(1).gibAnzahlSofas());
        assertEquals(2, fabrik.gibBestellungen().get(1).gibAnzahlStuehle());
        
        Bestellung.resetBestellnummerGenerator();
    }
    
    /**
     * Hier wird getestet, ob eine Bestellung nach der Aufgabe bestätigt wird (true).
     * 
     * Merke:BestellnummerGenerator wird nach diesem Test auf 1 zurückgesetzt, damit die Bestellnummern in weiteren Unit-Tests erneut 
     * von Anfang an hochzählen können. 
     */
    @Test
    public void TestBestellBestätigung(){
        //Arrange: Siehe BeforeEach
        
        //Act: Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(4,7);
        fabrik.bestellungAufgeben(5,3);
        fabrik.bestellungAufgeben(2,1);
        
        for (Bestellung bestellung : fabrik.gibBestellungen()) {
            assertEquals(true, bestellung.gibBestellBestaetigung());
        }
        
        Bestellung.resetBestellnummerGenerator();
    }
    
}

