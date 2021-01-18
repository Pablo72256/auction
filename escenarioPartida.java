

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class escenarioPartida.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class escenarioPartida
{
    private Auction auction1;
    private Person person1;
    private Person person2;

    /**
     * Default constructor for test class escenarioPartida
     */
    public escenarioPartida()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        auction1 = new Auction();
        person1 = new Person("pepe");
        person2 = new Person("juan");
        auction1.enterLot("Anillo");
        auction1.enterLot("corona");
        auction1.enterLot("pergamino");
        auction1.enterLot("coleccion libros");
        auction1.enterLot("Espada");
        auction1.showLots();
        auction1.makeABid(0, person1, 50);
        auction1.makeABid(0, person1, 55);
        auction1.makeABid(1, person2, 5);
        auction1.makeABid(1, person1, 7);
        auction1.makeABid(2, person2, 100);
        auction1.makeABid(2, person1, 96);
        auction1.makeABid(3, person1, 569);
        auction1.makeABid(3, person2, 698);
        auction1.makeABid(4, person1, 40);
        auction1.makeABid(4, person2, 122);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
