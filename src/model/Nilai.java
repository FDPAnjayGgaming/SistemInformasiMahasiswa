/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.nio.channels.Pipe;


public class Nilai {
    private int idNilai;
    private String nim;
    private String kodeMk;
    private int nilai;
    private String nilaiHuruf;
    private String namaMahasiswa;
    private String namaMatkul;



    public Nilai() {}

    // untuk INSERT (tanpa id)
    public Nilai(String nim, String kodeMk, int nilai, String nilaiHuruf) {
        this.nim = nim;
        this.kodeMk = kodeMk;
        this.nilai = nilai;
        this.nilaiHuruf = nilaiHuruf;
    }

    // untuk UPDATE (pakai id)
    public Nilai(int idNilai, String nim, String kodeMk, int nilai, String nilaiHuruf) {
        this.idNilai = idNilai;
        this.nim = nim;
        this.kodeMk = kodeMk;
        this.nilai = nilai;
        this.nilaiHuruf = nilaiHuruf;
    }

    public int getIdNilai() { return idNilai; }
    public void setIdNilai(int idNilai) { this.idNilai = idNilai; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getKodeMk() { return kodeMk; }
    public void setKodeMk(String kodeMk) { this.kodeMk = kodeMk; }

    public int getNilai() { return nilai; }
    public void setNilai(int nilai) { this.nilai = nilai; } 

    public String getNilaiHuruf() { return nilaiHuruf; }
    public void setNilaiHuruf(String nilaiHuruf) { this.nilaiHuruf = nilaiHuruf;}
    
    public String getNamaMahasiswa() { return namaMahasiswa; }
    public void setNamaMahasiswa(String namaMahasiswa) { this.namaMahasiswa = namaMahasiswa; }

    public String getNamaMatkul() { return namaMatkul; }
    public void setNamaMatkul(String namaMatkul) { this.namaMatkul = namaMatkul; }
  
}
