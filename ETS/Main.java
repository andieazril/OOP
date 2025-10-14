import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Snack> snacks;
    private ArrayList<Order> transactions;
    private Stock stock;

    public Main() {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Chitato", 8000));
        snacks.add(new Snack("Oreo", 6000));
        snacks.add(new Snack("SilverQueen", 12000));
        snacks.add(new Snack("Tango", 7000));
        snacks.add(new Snack("Pocky", 10000));

        stock = new Stock();
        transactions = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("\n=== MENU SNACK ===");
        for (int i = 0; i < snacks.size(); i++) {
            Snack s = snacks.get(i);
            System.out.println((i + 1) + ". " + s.getName() + " - Rp " + s.getPrice());
        }
    }

    public Order takeOrder() {
        Scanner sc = new Scanner(System.in);
        displayMenu();

        System.out.print("Pilih snack: ");
        int choice = sc.nextInt();
        Snack snackType = snacks.get(choice - 1);

        System.out.print("Jumlah yang dibeli: ");
        int qty = sc.nextInt();

        return new Order(snackType, qty);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== SNACK VENDING MACHINE =====");
            System.out.println("1. Beli snack");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            String choice = sc.next();

            switch (choice) {
                case "1":
                    Order order = takeOrder();
                    int qty = order.getQuantity();

                    if (!stock.isEnough(qty)) {
                        System.out.println("Stok tidak cukup. Panggil admin untuk refill.");
                        break;
                    }

                    double price = order.calculate();
                    Payment payment = new Payment(price);

                    if (payment.process()) {
                        System.out.println("Snack siap diambil. Terima kasih!");
                        stock.useStock(qty);
                        transactions.add(order);
                        Transaction.saveLog(order, price);
                    }
                    break;

                case "2":
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {
        Main vm = new Main();
        vm.run();
    }
}