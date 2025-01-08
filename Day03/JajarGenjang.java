package Day03;

public class JajarGenjang extends BangunDatar {
    public JajarGenjang(double alas, double tinggi, double diagonal) {
        setNama("Jajar Genjang");
        setHorizontal(alas);
        setVertikal(tinggi);
        setDiagonal(diagonal);
    }

    @Override
    public double hitungLuas() {
        double alas = getHorizontal();
        double tinggi = getVertikal();
        return alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        double alas = getHorizontal();
        double diagonal = getDiagonal();
        return 2 * (alas + diagonal);
    }
}
