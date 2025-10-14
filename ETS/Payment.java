import java.util.Scanner;

public class Payment {
    private double price;

    public Payment(double price) {
        this.price = price;
    }

    public boolean process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTotal harga: Rp " + price);
        System.out.print("Masukkan uang: Rp ");
        double money = sc.nextDouble();

        if (money == price) {
            System.out.println("Pembayaran berhasil.");
            return true;
        } else if (money > price) {
            double change = money - price;
            System.out.println("Pembayaran berhasil. Kembalian: Rp " + change);
            return true;
        } else {
            System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
            return false;
        }
    }
}