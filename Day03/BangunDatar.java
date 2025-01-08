package Day03;

public abstract class BangunDatar {
    private String Nama;
    private double Horizontal;
    private double Vertikal;
    private double Diagonal;
    private double jariJari;

    public String getNama() {
        return Nama;
    }
    public void setNama(String nama) {
        Nama = nama;
    }
    public double getHorizontal() {
        return Horizontal;
    }
    public void setHorizontal(double horizontal) {
        Horizontal = horizontal;
    }
    public double getVertikal() {
        return Vertikal;
    }
    public void setVertikal(double vertikal) {
        Vertikal = vertikal;
    }
    public double getDiagonal() {
        return Diagonal;
    }
    public void setDiagonal(double diagonal) {
        Diagonal = diagonal;
    }
    public double getJariJari() {
        return jariJari;
    }
    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }
    public abstract double hitungLuas();
    public abstract double hitungKeliling();
}
