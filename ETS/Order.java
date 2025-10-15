public class Order {
    private Snack snack;
    private int quantity;

    public Order(Snack snack, int quantity) {
        this.snack = snack;
        this.quantity = quantity;
    }

    public int calculate() {
        return snack.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return snack.getName() + " (" + quantity + ")";
    }
}