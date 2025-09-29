public class MataKuliah {
    private String kode;
    private String nama;
    private int kapasitas;
    private String dosen;

    public MataKuliah(String kode, String nama, int kapasitas, String dosen) {
        this.kode = kode;
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.dosen = dosen;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void kurangiKapasitas() {
        if (kapasitas > 0) {
            kapasitas--;
        }
    }

    public String getDosen() {
        return dosen;
    }

    public String toString() {
        return kode + " - " + nama + " | Kapasitas: " + kapasitas;
    }
}