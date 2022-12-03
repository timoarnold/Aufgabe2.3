import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Gruppe 29
 * @version 3.1 (4. Dezember 2022)
 * 
 * Die Test-Klasse LagerTest verwaltet den Unit-Test zur Kontrolle der Bestellaufgabe beim Lieferanten. 
 */
public class LagerTest
{   
    private Lager testLager;
        
    /**
     * Konstruktor für die Test-Klasse LagerTest
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
     * Testet, ob der Lieferant die Materialbestellungen an das Lager liefert.
     */
    @Test
    public void TestLieferungVonMaterial(){
        //Arrange: Siehe BeforeEach
        
        //Act: Prüft, ob Materialbestellung geliefert wird.
        assertTrue(testLager.gibLieferant().gibWareGeliefert());
    }
}
