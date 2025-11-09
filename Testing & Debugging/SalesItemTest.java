import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }


    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("A", 1000);
        assertEquals(true, salesIte1.addComment("Andie", "Halo", 2));
    }
    
    @Test
    public void testIlegalRating()
    {
        SalesItem salesIte1 = new SalesItem("A", 1000);
        assertEquals(false, salesIte1.addComment("Andie", "Halo", 0));
    }

    @Test
    public void testDupe()
    {
        SalesItem salesIte1 = new SalesItem("A", 1000);
        assertEquals(true, salesIte1.addComment("Andie", "Halo", 4));
        assertEquals(false, salesIte1.addComment("Andie", "Hai", 2));
    }
}


