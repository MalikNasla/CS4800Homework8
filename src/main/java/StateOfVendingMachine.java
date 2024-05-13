public class StateOfVendingMachine {
    static State idle = (snackDispenseHandler, snack, money) -> {
        snackDispenseHandler.setSnack(snack);
        snackDispenseHandler.setState(StateOfVendingMachine.waiting);
    };

    static State waiting = new State() {
        private boolean moneyNeededPrinted = false;

        @Override
        public void handle(SnackDispenseHandler snackDispenser, Snack snack, double money) {
            if (money >= snack.getPrice()) {
                snackDispenser.setState(StateOfVendingMachine.dispense);
            } else {
                if (!moneyNeededPrinted) {
                    System.out.println("Need more money.");
                    moneyNeededPrinted = true;
                }
                snackDispenser.setState(StateOfVendingMachine.waiting);
            }
        }
    };

    static State dispense = (snackDispenseHandler, snack, money) -> {
        if (snack.getQuantity() > 0){
            System.out.println("Snack: " + snack.getName());
            snack.setQuantity(snack.getQuantity() - 1);
        }
        else{
            System.out.println("There is no more of the selected snack");
        }
        snackDispenseHandler.setState(StateOfVendingMachine.idle);
    };
}
