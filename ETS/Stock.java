public class Stock {
    private int snackStock;

    public Stock() {
        this.snackStock = 10;
    }

    public boolean isEnough(int qty) {
        return snackStock >= qty;
    }

    public void useStock(int qty) {
        snackStock -= qty;
    }
}