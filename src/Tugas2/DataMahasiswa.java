
package Tugas2;

import java.util.ArrayList;
import java.util.Scanner;

public class DataMahasiswa {
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void tambahData() {
        System.out.println("\n--- Tambah Data Mahasiswa ---");
        System.out.print("Masukkan NPM: ");
        String npm = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa(npm, nama, alamat);
        daftarMahasiswa.add(mhs);
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    public Mahasiswa cariMahasiswa(String npm) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNpm().equals(npm)) {
                return mhs;
            }
        }
        return null; 
    }

    public void tampilkanSemuaData() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.println("\n--- Daftar Mahasiswa ---");
            for (Mahasiswa mhs : daftarMahasiswa) {
                System.out.println(mhs);
            }
        }
    }

    public void editData() {
        System.out.println("\n--- Edit Data Mahasiswa ---");
        System.out.print("Masukkan NPM mahasiswa yang akan diedit: ");
        String npmCari = scanner.nextLine();
        Mahasiswa mhs = cariMahasiswa(npmCari);

        if (mhs != null) {
            System.out.println("Data ditemukan: " + mhs);
            System.out.print("Masukkan Nama baru (kosongkan jika tidak ingin mengubah): ");
            String namaBaru = scanner.nextLine();
            if (!namaBaru.isEmpty()) {
                mhs.setNama(namaBaru);
            }
            System.out.print("Masukkan Alamat baru (kosongkan jika tidak ingin mengubah): ");
            String alamatBaru = scanner.nextLine();
            if (!alamatBaru.isEmpty()) {
                mhs.setAlamat(alamatBaru);
            }
            System.out.println("Data mahasiswa berhasil diperbarui.");
        } else {
            System.out.println("Data mahasiswa dengan NPM " + npmCari + " tidak ditemukan.");
        }
    }

    public void hapusData() {
        System.out.println("\n--- Hapus Data Mahasiswa ---");
        System.out.print("Masukkan NPM mahasiswa yang akan dihapus: ");
        String npmHapus = scanner.nextLine();
        Mahasiswa mhs = cariMahasiswa(npmHapus);

        if (mhs != null) {
            daftarMahasiswa.remove(mhs);
            System.out.println("Data mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Data mahasiswa dengan NPM " + npmHapus + " tidak ditemukan.");
        }
    }
}