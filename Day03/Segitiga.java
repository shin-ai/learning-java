package Day03;

public class Segitiga extends BangunDatar {
    public Segitiga(double alas, double tinggi, double diagonal) {
        setNama("Segitiga");
        setHorizontal(alas);
        setVertikal(tinggi);
        setDiagonal(diagonal);
    }

    @Override
    public double hitungLuas() {
        double alas = getHorizontal();
        double tinggi = getVertikal();
        return 0.5 * alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        double diagonal = getDiagonal();

        return 3 * diagonal; 
    }
}
