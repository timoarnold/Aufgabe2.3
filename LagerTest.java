import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Gruppe 29
 * @version 2.3 (13. November 2022)
 * 
 * Die Test-Klasse LagerTest verwaltet den Unit-Test zur Kontrolle der Bestellaufgabe beim Lieferanten. 
 */
public class LagerTest
{   
    private Lager testLager;
        
    /**
     * Konstruktor fuer die Test-Klasse LagerTest
     */
    public LagerTest()
    {
    }

    /**
     * Vor jedem Unit-Test der Klasse Lager und deren Inhalten, wird eine neue Lagerinstanz erstellt.
     */
    @BeforeEach
    public void setUp()
    {
        testLager = new Lager();
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
     * Testet, ob das Lager eine Bestellung an den Lieferanten aufgeben kann.
     */
    @Test
    public void TestBestellungAnLieferant(){
        //Arrange: Siehe BeforeEach
        
        //Act: Testbestellung wird aufgegeben & Check, ob die Bestellung beim Lieferanten eintrifft (true).
        assertTrue(testLager.gibLieferant().wareBestellen(1,1,1,1,1));
    }
}
