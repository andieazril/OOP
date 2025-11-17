public class Sepeda extends Kendaraan {
    private String jenis;

    public Sepeda(String merk, String model, int tahunProduksi, String jenis) {
        super(merk, model, tahunProduksi);
        this.jenis = jenis;
    }

    @Override
    public void info() {
        System.out.println("Sepeda: " + merk + " " + model + 
                           " (" + tahunProduksi + "), Jenis: " + jenis);
    }
}