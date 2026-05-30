/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.MataKuliahDAO;
import model.MataKuliah;
import java.util.List;

public class MataKuliahController {

    private MataKuliahDAO dao = new MataKuliahDAO();

    public void simpan(String kodeMk, String namaMk, int sks) {
        if (namaMk == null || namaMk.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama mata kuliah wajib diisi");
        }

        MataKuliah mk = new MataKuliah(kodeMk, namaMk.trim(), sks);
        dao.insert(mk);
    }

    public void update(String kodeMk, String namaMk, int sks) {
        MataKuliah mk = new MataKuliah(kodeMk, namaMk.trim(), sks);
        dao.update(mk);
    }

    public void hapus(String kodeMk) {
        dao.delete(kodeMk);
    }

    public List<MataKuliah> getAll() {
        return dao.getAll();
    }
}