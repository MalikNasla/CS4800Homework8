public class Main {
    public static void main(String[] args) {
        Snack coke = new Snack("Coke", 1.5, 5);
        Snack pepsi = new Snack("Pepsi", 1.3, 7);
        Snack cheetos = new Snack("Cheetos", 1.0, 4);
        Snack doritos = new Snack("Doritos", 1.2, 6);
        Snack kitKat = new Snack("KitKat", 1.1, 3);
        Snack snickers = new Snack("Snickers", 1.4, 0);

        SnackDispenseHandler snackDispenser = new SnackDispenseHandler();
        snackDispenser.add("Coke", coke);
        snackDispenser.add("Pepsi", pepsi);
        snackDispenser.add("Cheetos", cheetos);
        snackDispenser.add("Doritos", doritos);
        snackDispenser.add("KitKat", kitKat);
        snackDispenser.add("Snickers", snickers);

        VendingMachine vendingMachine = new VendingMachine(snackDispenser);
        vendingMachine.select("Coke");
        vendingMachine.addMoney(2.0);
        vendingMachine.dispense();
        vendingMachine.select("Pepsi");
        vendingMachine.addMoney(2.0);
        vendingMachine.dispense();
        vendingMachine.select("Cheetos");
        vendingMachine.addMoney(2.0);
        vendingMachine.dispense();
        vendingMachine.select("Snickers");
        vendingMachine.addMoney(1.5);
        vendingMachine.dispense();
        vendingMachine.select("Doritos");
        vendingMachine.addMoney(1.5);
        vendingMachine.dispense();
        vendingMachine.select("KitKat");
        vendingMachine.addMoney(1.0);
        vendingMachine.dispense();
    }
}