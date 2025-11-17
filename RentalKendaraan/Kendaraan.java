public class Kendaraan {
    protected String merk;
    protected String model;
    protected int tahunProduksi;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public void info() {
        System.out.println("Kendaraan: " + merk + " " + model + " (" + tahunProduksi + ")");
    }
}