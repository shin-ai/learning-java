package Day03;

public class PersegiPanjang extends BangunDatar {
    public PersegiPanjang(double panjang, double tinggi) {
        setNama("Persegi Panjang");
        setHorizontal(panjang);
        setVertikal(tinggi);
    }

    @Override
    public double hitungLuas() {
        double panjang = getHorizontal();
        double lebar = getVertikal();
        return panjang * lebar;
    }

    @Override
    public double hitungKeliling() {
        double panjang = getHorizontal();
        double lebar = getVertikal();
        return 2 * (panjang + lebar);
    }
}
