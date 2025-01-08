package Day03;

public class App {
    public static void main(String[] args) {
        BangunDatar[] bangunDatar = new BangunDatar[5];
        bangunDatar[0] = new Persegi(5);  
        bangunDatar[1] = new Lingkaran(7);
        bangunDatar[2] = new Segitiga(4, 6, 7);
        bangunDatar[3] = new PersegiPanjang(6,4);  
        bangunDatar[4] = new JajarGenjang(6, 4, 5);
        
        for (BangunDatar bd : bangunDatar) {
            System.out.println("Nama: " + bd.getNama());
            System.out.println("Luas: " + bd.hitungLuas());
            System.out.println("Keliling: " + bd.hitungKeliling());
            System.out.println();
        }
    }
}
