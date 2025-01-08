package Day03;

public class Persegi extends BangunDatar {
    public Persegi() {}

    public Persegi(double sisi) {
        setNama("Persegi");
        setHorizontal(sisi);
    }

    @Override
    public double hitungLuas() {
        double sisi = getHorizontal();
        return sisi * sisi;
    }

    @Override
    public double hitungKeliling() {
        double sisi = getHorizontal();
        return 4 * sisi;
    }
}
