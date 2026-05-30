/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Mahasiswa extends User {
    private String nim;
    private String nama;
    private String jurusan;
    private String jenisKelamin;
    private String alamat;
    
    
    @Override
    public String toString() {
    return nim + " - " + nama;
}
    // Constructor
   public Mahasiswa() {
        super(""); // Memanggil constructor User dengan string kosong
    }
   
    public Mahasiswa(String nim, String nama, String jurusan, String jenisKelamin, String alamat) {
        super(nim);
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }
    
    // Getter & Setter
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}

