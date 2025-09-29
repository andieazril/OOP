import java.util.ArrayList;

public class Mahasiswa {
    private String nrp;
    private String nama;
    private ArrayList<MataKuliah> matkulDiambil;

    public Mahasiswa(String nrp, String nama) {
        this.nrp = nrp;
        this.nama = nama;
        this.matkulDiambil = new ArrayList<>();
    }

    public String getNrp() {
        return nrp;
    }

    public String getNama() {
        return nama;
    }

    public void ambilMatkul(MataKuliah mk) {
        if (mk.getKapasitas() > 0) {
            matkulDiambil.add(mk);
            mk.kurangiKapasitas();
            System.out.println("Mata kuliah " + mk.getNama() + " berhasil diambil.");
        } else {
            System.out.println("Kapasitas sudah penuh");
        }
    }

    public void tampilkanMatkulDiambil() {
        if (matkulDiambil.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mk : matkulDiambil) {
                System.out.println("- " + mk.getKode() + " " + mk.getNama());
            }
        }
    }
}