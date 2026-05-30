package controller;

import dao.MahasiswaDAO;
import model.Mahasiswa;
import java.util.List;

public class MahasiswaController {

    private MahasiswaDAO dao = new MahasiswaDAO();

    public void simpan(String nim, String nama, String jurusan,
                       String jenisKelamin, String alamat) {

        Mahasiswa m = new Mahasiswa(nim, nama, jurusan, jenisKelamin, alamat);
        dao.insert(m);
    }

    public void update(String nim, String nama, String jurusan,
                       String jenisKelamin, String alamat) {

        Mahasiswa m = new Mahasiswa(nim, nama, jurusan, jenisKelamin, alamat);
        dao.update(m);
    }

    public void hapus(String nim) {
        dao.delete(Integer.parseInt(nim));
    }

    public List<Mahasiswa> getAll() {
        return dao.getAll();
    }

    public Mahasiswa getByNim(String nim) {
        return dao.getByNim(Integer.parseInt(nim));
    }
}
