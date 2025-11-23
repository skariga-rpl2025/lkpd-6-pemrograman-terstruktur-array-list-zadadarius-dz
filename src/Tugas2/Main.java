
package Tugas2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataMahasiswa app = new DataMahasiswa();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 5) {
            System.out.println("\n============================");
            System.out.println("APLIKASI MANAJEMEN MAHASISWA");
            System.out.println("============================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Cari Mahasiswa (dan Tampilkan Semua Data)");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1:
                        app.tambahData();
                        break;
                    case 2:
                        app.tampilkanSemuaData();
                        System.out.print("\nMasukkan NPM untuk pencarian spesifik (tekan Enter untuk kembali): ");
                        String npmCari = scanner.nextLine();
                        if (!npmCari.isEmpty()) {
                            Mahasiswa mhsCari = app.cariMahasiswa(npmCari);
                            if (mhsCari != null) {
                                System.out.println("Data ditemukan: " + mhsCari);
                            } else {
                                System.out.println("Data mahasiswa tidak ditemukan.");
                            }
                        }
                        break;
                    case 3:
                        app.editData();
                        break;
                    case 4:
                        app.hapusData();
                        break;
                    case 5:
                        System.out.println("Terima kasih, program berakhir.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka pilihan.");
            }
        }
        scanner.close();
    }
}