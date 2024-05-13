public class VendingMachine {
    private SnackDispenseHandler snackDispenser;
    private State currentState;

    public VendingMachine(SnackDispenseHandler snackDispenser) {
        this.snackDispenser = snackDispenser;
        this.currentState = StateOfVendingMachine.idle;
    }

    public void select(String snackName) {
        snackDispenser.select(snackName);
    }

    public void addMoney(double money) {
        snackDispenser.addMoney(money);
    }

    public void dispense() {
        snackDispenser.dispense();
    }

    public State getCurrentState() {
        return currentState;
    }
}
