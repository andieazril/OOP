import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RentalSystem rental = new RentalSystem();
        Scanner sc = new Scanner(System.in);

        rental.tambahKendaraan(new Mobil("Toyota", "Avanza", 2020, 4));
        rental.tambahKendaraan(new Motor("Honda", "Vario", 2018, 2));
        rental.tambahKendaraan(new Sepeda("Polygon", "Strattos", 2021, "Balap"));

        rental.tambahPenyewa(new Penyewa("Andi", "08123", rental.kendaraanList.get(0)));
        rental.tambahPenyewa(new Penyewa("Budi", "08222", rental.kendaraanList.get(2)));

        int pilihan = 0;

        while (pilihan != 3) {
            rental.tampilkanMenu();
            pilihan = sc.nextInt();
            rental.prosesPilihan(pilihan);
        }

        sc.close();
    }
}