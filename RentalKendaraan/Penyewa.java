public class Penyewa {
    private String nama;
    private String telepon;
    private Kendaraan kendaraan;

    public Penyewa(String nama, String telepon, Kendaraan kendaraan) {
        this.nama = nama;
        this.telepon = telepon;
        this.kendaraan = kendaraan;
    }

    public void info() {
        System.out.println("Nama: " + nama + " | Telp: " + telepon);
        System.out.print("Menyewa: ");
        kendaraan.info();
    }
}
