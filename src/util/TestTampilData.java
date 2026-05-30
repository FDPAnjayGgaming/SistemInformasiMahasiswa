/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dao.MahasiswaDAO;
import model.Mahasiswa;
import java.util.List;

public class TestTampilData {
    public static void main(String[] args) {
        // 1. Instansiasi kelas DAO yang sudah dibuat tim Anda
        MahasiswaDAO dao = new MahasiswaDAO();
        
        // 2. Memanggil method getAll() untuk mengambil semua data dari tabel mahasiswa
        List<Mahasiswa> daftarMahasiswa = dao.getAll();
        
        // 3. Mengecek apakah data berhasil diambil
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Data di database kosong.");
        } else {
            System.out.println("======= DAFTAR MAHASISWA =======");
            // 4. Perulangan untuk menampilkan data (Prinsip OOP: Encapsulation)
            for (Mahasiswa mhs : daftarMahasiswa) {
                System.out.println("NIM     : " + mhs.getNim());
                System.out.println("Nama    : " + mhs.getNama());
                System.out.println("Jurusan : " + mhs.getJurusan());
                System.out.println("JK      : " + mhs.getJenisKelamin());
                System.out.println("Alamat  : " + mhs.getAlamat());
                System.out.println("--------------------------------");
            }
        }
    }
}