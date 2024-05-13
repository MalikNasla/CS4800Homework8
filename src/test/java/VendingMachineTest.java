import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenser;

    @Before
    public void setUp() {
        snackDispenser = new SnackDispenseHandler();
        vendingMachine = new VendingMachine(snackDispenser);
    }

    @Test
    public void testSelect() {
        vendingMachine.select("Chips");
        assertEquals(StateOfVendingMachine.waiting, vendingMachine.getCurrentState());
    }

    @Test
    public void testAddMoney() {
        vendingMachine.select("Chips");
        vendingMachine.addMoney(2.0);
        assertEquals(StateOfVendingMachine.dispense, vendingMachine.getCurrentState());
    }

    @Test
    public void testDispense() {
        vendingMachine.select("Chips");
        vendingMachine.addMoney(2.0);
        vendingMachine.dispense();
        assertEquals(StateOfVendingMachine.idle, vendingMachine.getCurrentState());
    }
}
