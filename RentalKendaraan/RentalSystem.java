import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    List<Kendaraan> kendaraanList = new ArrayList<>();
    List<Penyewa> penyewaList = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        kendaraanList.add(k);
    }

    public void tambahPenyewa(Penyewa p) {
        penyewaList.add(p);
    }

    public void tampilkanKendaraan() {
        System.out.println("\n=== KENDARAAN YANG TERSEDIA ===");
        if (kendaraanList.isEmpty()) {
            System.out.println("Tidak ada kendaraan.");
            return;
        }
        for (Kendaraan k : kendaraanList) {
            k.info();
        }
    }

    public void tampilkanPenyewa() {
        System.out.println("\n=== LIST PENYEWA ===");
        if (penyewaList.isEmpty()) {
            System.out.println("Belum ada penyewa.");
            return;
        }
        for (Penyewa p : penyewaList) {
            p.info();
        }
    }

    public void tampilkanMenu() {
        System.out.println("\n==== MENU RENTAL ====");
        System.out.println("1. Kendaraan yang tersedia");
        System.out.println("2. Tampilkan list penyewa");
        System.out.println("3. Keluar");
        System.out.print("Pilih: ");
    }

    public void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                tampilkanKendaraan();
                break;
            case 2:
                tampilkanPenyewa();
                break;
            case 3:
                System.out.println("Keluar dari program");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
}
