import java.io.*;

public class Transaction {
    private static final String LOG_FILE = "snack_transactions.log";

    public static void saveLog(Order order, double price) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(order.getDescription() + " | Rp " + (int) price + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan log transaksi.");
        }
    }

    public static void showLog() {
        System.out.println("\n=== LOG TRANSAKSI SNACK ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) {
                System.out.println("Belum ada transaksi.");
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca log transaksi.");
        }
    }
}