import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 *
 * Die Test-Klasse FabrikTest verwaltet alle Unit-Tests der Software.
 */
public class FabrikTest {
    private Fabrik fabrik;

    /**
     * Vor jedem Unit-Test der Klasse Fabrik und deren Inhalten wird eine neue Fabrikinstanz erstellt.
     */
    @BeforeEach
    public void setUp() {
        fabrik = new Fabrik();
    }

    /**
     * Anweisungen, welche nach jedem Unit-Test ausgeführt werden.
     * In diesem Fall: (Noch) keine.
     */
    @AfterEach
    public void tearDown() {

    }

    /**
     * Testet, ob die richtige Bestellnummer ausgegeben wird, wenn Instanz Fabrik
     * erzeugt und 2 Testbestellungen aufgegeben werden.
     */
    @Test
    public void TestBestellungsNummer() {
        //Arrange: Siehe BeforeEach

        //Act: Zwei Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(2, 3);
        fabrik.bestellungAufgeben(1, 1);

        //Assert: Check, ob Ergebnis == erwartetes Ergebnis
        assertEquals(2, fabrik.gibBestellungsNr());
    }

    /**
     * Testet, ob nach Überschreitung des festgelegten Minimalbetrags des Lagers, die Beschaffungszeit auf zwei Tage festgelegt und somit die Lieferzeit um zwei Tage erhöht wird.
     */
    @Test
    public void TestBestellungAufgebenWennWenigMaterial() {
        //Arrange: Siehe BeforeEach

        //Act: Eine Testbestellung, welche 80 Kissen für die Produktion benötigt. Nach der Produktion sollten noch 20 Kissen im Lager vorhanden sein und überschreitet somit den Minimalbetrag des Lagers für Kissen (25).
        int anzahlSofas = 16;
        int anzahlStuehle = 0;
        fabrik.bestellungAufgeben(anzahlSofas, anzahlStuehle);

        //Assert: Check, ob die korrekte Beschaffungszeit (0 Tage, da genug Materialien vorhanden sind) in die Lieferzeit berechnet wurde.
        assertEquals("1 Tag(e) 16 Stunde(n) 0 Minute(n)", fabrik.gibBestellungen().get(0).gibFormatierteLieferzeit());

        //Act: Eine Testbestellung, welche nach der vorherigen Überschreitung des Minimalbetrags ebenfalls Kissen benötigt.
        anzahlSofas = 1;
        anzahlStuehle = 0;
        fabrik.bestellungAufgeben(anzahlSofas, anzahlStuehle);

        //Assert: Check, ob die korrekte Beschaffungszeit (2 Tage, da bei vorheriger Bestellung der Minimalbetrag überschreitet worden ist und somit beim Lieferanten nachbestellt werden muss) in die Lieferzeit berechnet wurde.
        assertEquals("3 Tag(e) 1 Stunde(n) 0 Minute(n)", fabrik.gibBestellungen().get(1).gibFormatierteLieferzeit());
    }

    /**
     * Testet, ob Bestellungen korrekt aufgegeben werden können.
     */
    @Test
    public void TestBestellungAufgeben() {
        //Arrange: Siehe BeforeEach

        //Act: Testbestellung wird aufgegeben
        fabrik.bestellungAufgeben(4, 7);


        //Assert: Check, ob die richtige Anzahl Stühle und Sofas ausgegeben wird
        assertEquals(4, fabrik.gibBestellungen().get(0).gibAnzahlSofas());
        assertEquals(7, fabrik.gibBestellungen().get(0).gibAnzahlStuehle());
    }

    /**
     * Testet, ob mehrere Bestellungen korrekt aufgegeben und ausgegeben werden können.
     * Dazu wird die zweite Bestellung auf die Korrektheit ihrer Werte (Stühle & Sofas) geprüft.
     */
    @Test
    public void TestMehrereBestellungenAufgeben() {
        //Arrange: Siehe BeforeEach

        //Act: Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(4, 7);
        fabrik.bestellungAufgeben(3, 2);
        fabrik.bestellungAufgeben(9, 5);

        assertEquals(1, fabrik.gibBestellungen().get(0).gibBestellNummer());
        assertEquals(2, fabrik.gibBestellungen().get(1).gibBestellNummer());
        assertEquals(3, fabrik.gibBestellungen().get(2).gibBestellNummer());

        //Assert: Check, ob die richtige Anzahl Stühle und Sofas ausgegeben werden
        assertEquals(3, fabrik.gibBestellungen().get(1).gibAnzahlSofas());
        assertEquals(2, fabrik.gibBestellungen().get(1).gibAnzahlStuehle());
    }

    /**
     * Testet, ob eine Bestellung nach der Aufgabe bestätigt wird (true).
     */
    @Test
    public void TestBestellBestätigung() {
        //Arrange: Siehe BeforeEach

        //Act: Testbestellungen werden aufgegeben
        fabrik.bestellungAufgeben(4, 7);
        fabrik.bestellungAufgeben(5, 3);
        fabrik.bestellungAufgeben(2, 1);

        //Assert: Check, ob die Bestellungen bestätigt wurden
        for (Bestellung bestellung : fabrik.gibBestellungen()) {
            assertEquals(true, bestellung.gibBestellBestaetigung());
        }
    }

    /**
     * Testet, ob die Lieferung der bestellten Teile beim Lieferant erst nach der definierten Wartezeit erfolgt.
     */
    @Test
    public void TestLieferungVonMaterial() {
        //Arrange: Siehe BeforeEach

        //Act: Die fehlenden Rohstoffe wurden beim Lieferanten bestellt.
        fabrik.getLager().wareLiefern();

        //Assert: Check, ob der Lieferant erst nach 2 Tagen (48000ms) liefert.
        assertFalse(fabrik.getLager().gibLieferant().istWareGeliefert());
        ThreadUtil.sleep(2 * 25 * 1000);
        assertTrue(fabrik.getLager().gibLieferant().istWareGeliefert());
    }
}

