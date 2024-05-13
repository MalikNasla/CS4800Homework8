import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SnackDispenseHandlerTest {

    private SnackDispenseHandler snackDispenseHandler;
    private Snack snack;

    @Before
    public void setUp() {
        snackDispenseHandler = new SnackDispenseHandler();
        snack = new Snack("KitKat", 1.5, 10);
        snackDispenseHandler.add("KitKat", snack);
    }

    @Test
    public void testAdd() {
        assertEquals(1, snackDispenseHandler.snacks.size());
    }

    @Test
    public void testSelect() {
        snackDispenseHandler.select("KitKat");
        assertEquals(StateOfVendingMachine.waiting, snackDispenseHandler.getState());
        assertEquals(snack, snackDispenseHandler.getSnack());
    }

    @Test
    public void testAddMoney() {
        snackDispenseHandler.select("KitKat");
        snackDispenseHandler.addMoney(2.0);
        assertEquals(StateOfVendingMachine.dispense, snackDispenseHandler.getState());
    }

    @Test
    public void testDispense() {
        snackDispenseHandler.select("Chips");
        snackDispenseHandler.addMoney(2.0);
        snackDispenseHandler.dispense();
        assertEquals(9, snack.getQuantity());
        assertEquals(StateOfVendingMachine.idle, snackDispenseHandler.getState());
    }

}
