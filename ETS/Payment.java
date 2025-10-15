import java.util.Scanner;

public class Payment {
    private int price;

    public Payment(int price) {
        this.price = price;
    }

    public boolean process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTotal harga: Rp " + price);
        System.out.print("Masukkan uang: Rp ");
        int money = sc.nextInt();

        if (money == price) {
            System.out.println("Pembayaran berhasil.");
            return true;
        } else if (money > price) {
            int change = money - price;
            System.out.println("Pembayaran berhasil. Kembalian: Rp " + change);
            return true;
        } else {
            System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
            return false;
        }
    }
}