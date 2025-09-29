import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<MataKuliah> daftarMatkul = new ArrayList<>();
        daftarMatkul.add(new MataKuliah("EF234301", "Pemrograman Web (B)", 65, "Fajar Baskoro, S.Kom., M.T."));
        daftarMatkul.add(new MataKuliah("EF234302", "Pemrograman Berorientasi Objek (B)", 65, "Fajar Baskoro, S.Kom., M.T."));
        daftarMatkul.add(new MataKuliah("EF234303", "Jaringan Komputer (B)", 80, "Royyana Muslim Ijtihadie, S.Kom., M.Kom., Ph.D."));
        daftarMatkul.add(new MataKuliah("EF234304", "Teori Graf (E)", 65, "Ir. Arya Yudhi Wijaya, S.Kom., M.Kom."));
        daftarMatkul.add(new MataKuliah("EF234305", "Matematika Diskrit (A)", 80, "Ilham Gurat Adillion, S.Kom., M.Kom."));
        daftarMatkul.add(new MataKuliah("EF234307", "Konsep Pengembangan Perangkat Lunak (A)", 45, "Dr. Sarwosri, S.Kom., M.T."));
        daftarMatkul.add(new MataKuliah("EK234201", "Konsep Kecerdasan Artifisial (G)", 45, "Prof. Dr. Eng. Chastine Fatichah, S.Kom., M.Kom."));

        ArrayList<Dosen> daftarDosen = new ArrayList<>();
        for (MataKuliah mk : daftarMatkul) {
            boolean sudahAda = false;
            for (Dosen d : daftarDosen) {
                if (d.getNama().equals(mk.getDosen())) {
                    sudahAda = true;
                    break;
                }
            }
            if (!sudahAda) {
                daftarDosen.add(new Dosen(mk.getDosen()));
            }
        }

        System.out.print("Masukkan NRP: ");
        String nrp = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        String namaMhs = sc.nextLine();
        Mahasiswa mhs = new Mahasiswa(nrp, namaMhs);

        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Mata Kuliah yang Bisa Diambil");
            System.out.println("2. Data Dosen");
            System.out.println("3. Mata Kuliah yang Sudah Diambil");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Daftar Mata Kuliah ===");
                    for (int i = 0; i < daftarMatkul.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMatkul.get(i));
                    }
                    System.out.print("Pilih 0 untuk keluar: ");
                    int pilihMatkul = sc.nextInt();
                    sc.nextLine();
                    if (pilihMatkul > 0 && pilihMatkul <= daftarMatkul.size()) {
                        mhs.ambilMatkul(daftarMatkul.get(pilihMatkul - 1));
                    }
                    break;

                case 2:
                    System.out.println("\n=== Data Dosen ===");
                    for (Dosen d : daftarDosen) {
                        System.out.println("- " + d.getNama());
                        System.out.println("  Mata kuliah:");
                        for (MataKuliah mk : daftarMatkul) {
                            if (mk.getDosen().equals(d.getNama())) {
                                System.out.println("    • " + mk.getKode() + " - " + mk.getNama());
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== Mata Kuliah yang Sudah Diambil ===");
                    mhs.tampilkanMatkulDiambil();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close();
    }
}