package controller;

import dao.NilaiDAO;
import model.Nilai;
import java.util.List;


public class NilaiController {

    private NilaiDAO dao = new NilaiDAO();

    public String hitungNilaiHuruf(int nilai) {
        if (nilai >= 85) return "A";
        if (nilai >= 75) return "B";
        if (nilai >= 65) return "C";
        if (nilai >= 55) return "D";
        return "E";
    }

    public void simpan(String nim, String kodeMk, int nilai) {
        if (nim == null || nim.isEmpty())
            throw new IllegalArgumentException("Mahasiswa wajib dipilih");

        if (kodeMk == null || kodeMk.isEmpty())
            throw new IllegalArgumentException("Mata kuliah wajib dipilih");

        if (nilai < 0 || nilai > 100)
            throw new IllegalArgumentException("Nilai harus 0 - 100");

        String huruf = hitungNilaiHuruf(nilai);

        Nilai n = new Nilai(nim, kodeMk, nilai, huruf);
        dao.insert(n);
    }

    public void update(int idNilai, String nim, String kodeMk, int nilai) {
        String huruf = hitungNilaiHuruf(nilai);
        dao.update(new Nilai(idNilai, nim, kodeMk, nilai, huruf));
    }

    public void hapus(int idNilai) {
        dao.delete(idNilai);
    }

    public List<Nilai> getAll() {
        return dao.getAll();
    }

}
