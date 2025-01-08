package Day03;

public class Lingkaran extends BangunDatar {
    public Lingkaran(double jariJari) {
        setNama("Lingkaran");
        setJariJari(jariJari);
    }

    @Override
    public double hitungLuas() {
        double r = getJariJari();
        return Math.PI * r * r;
    }

    @Override
    public double hitungKeliling() {
        double r = getJariJari();
        return 2 * Math.PI * r;
    }
}
