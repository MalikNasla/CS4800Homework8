import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SnackTest {

    private Snack snack;

    @Before
    public void setUp() {
        snack = new Snack("KitKat", 2.5, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("KitKat", snack.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.5, snack.getPrice(), 0.01);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, snack.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        snack.setQuantity(5);
        assertEquals(5, snack.getQuantity());
    }
}
