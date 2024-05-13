import java.util.HashMap;

public class SnackDispenseHandler {
    HashMap<String, Snack> snacks = new HashMap<>();
    State state = StateOfVendingMachine.idle;
    Snack snack;

    public void add(String name, Snack snack) {
        snacks.put(name, snack);
    }

    public void select(String snack) {
        Snack selectedSnack = snacks.get(snack);
        state.handle(this, selectedSnack, 0);
    }

    public void addMoney(double money) {
        state.handle(this, getSnack(), money);
    }

    public void dispense() {
        state.handle(this, getSnack(), 0);
    }

    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack){
        this.snack = snack;
    }

    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
