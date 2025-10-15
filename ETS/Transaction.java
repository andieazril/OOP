import java.io.*;

public class Transaction {
    private static final String LOG_FILE = "snack_transactions.log";

    public static void saveLog(Order order, int price) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(order.getDescription() + " | Rp " + (int) price + "\n");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
}