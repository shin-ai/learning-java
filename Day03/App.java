package Day03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih bangun datar:");
        System.out.println("1. Persegi");
        System.out.println("2. Lingkaran");
        System.out.println("3. Segitiga");
        System.out.println("4. Persegi Panjang");
        System.out.println("5. Jajar Genjang");
        System.out.print("Masukkan pilihan (1-5): ");
        int pilihan = scanner.nextInt();

        // Menyimpan bangun datar yang dipilih
        BangunDatar bangunDatar = null;

        switch (pilihan) {
            case 1: // Persegi
                System.out.print("Masukkan sisi Persegi: ");
                double sisiPersegi = scanner.nextDouble();
                bangunDatar = new Persegi(sisiPersegi);
                break;
            case 2: // Lingkaran
                System.out.print("Masukkan jari-jari Lingkaran: ");
                double jariJariLingkaran = scanner.nextDouble();
                bangunDatar = new Lingkaran(jariJariLingkaran);
                break;
            case 3: // Segitiga
                System.out.print("Masukkan alas Segitiga: ");
                double alasSegitiga = scanner.nextDouble();
                System.out.print("Masukkan tinggi Segitiga: ");
                double tinggiSegitiga = scanner.nextDouble();
                System.out.print("Masukkan sisi miring Segitiga: ");
                double sisiMiringSegitiga = scanner.nextDouble();
                bangunDatar = new Segitiga(alasSegitiga, tinggiSegitiga, sisiMiringSegitiga);
                break;
            case 4: // Persegi Panjang
                System.out.print("Masukkan panjang Persegi Panjang: ");
                double panjangPersegiPanjang = scanner.nextDouble();
                System.out.print("Masukkan lebar Persegi Panjang: ");
                double lebarPersegiPanjang = scanner.nextDouble();
                bangunDatar = new PersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
                break;
            case 5: // Jajar Genjang
                System.out.print("Masukkan alas Jajar Genjang: ");
                double alasJajarGenjang = scanner.nextDouble();
                System.out.print("Masukkan tinggi Jajar Genjang: ");
                double tinggiJajarGenjang = scanner.nextDouble();
                System.out.print("Masukkan sisi miring Jajar Genjang: ");
                double sisiMiringJajarGenjang = scanner.nextDouble();
                bangunDatar = new JajarGenjang(alasJajarGenjang, tinggiJajarGenjang, sisiMiringJajarGenjang);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }

        if (bangunDatar != null) {
            System.out.println("----------------------------------------------------");
            System.out.println("Nama: " + bangunDatar.getNama());
            System.out.printf("Luas: %.2f \n", bangunDatar.hitungLuas());
            System.out.printf("Keliling: %.2f \n", bangunDatar.hitungKeliling());
        }

        // Menutup scanner
        scanner.close();
    }
}
