/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Nilai;
import util.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NilaiDAO {
    public void insert(Nilai nilai) {
        String sql = "INSERT INTO nilai (nim, kode_mk, nilai, nilai_huruf) VALUES (?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nilai.getNim());
            pstmt.setString(2, nilai.getKodeMk());
            pstmt.setInt(3, nilai.getNilai());
            pstmt.setString(4, nilai.getNilaiHuruf());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Nilai nilai) {
        String sql = "UPDATE nilai SET nim=?, kode_mk=?, nilai=?, nilai_huruf=? WHERE id_nilai=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nilai.getNim().trim());
            ps.setString(2, nilai.getKodeMk());
            ps.setInt(3, nilai.getNilai());
            ps.setString(4, nilai.getNilaiHuruf());
            ps.setInt(5, nilai.getIdNilai());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal mengupdate nilai");
        }
    }

    public void delete(int idNilai) {
        String sql = "DELETE FROM nilai WHERE id_nilai=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idNilai);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal menghapus nilai");
        }
    }

public List<Nilai> getAll() {
    List<Nilai> list = new ArrayList<>();

    String sql = """
        SELECT 
            n.id_nilai,
            n.nim,
            m.nama AS nama_mahasiswa,
            n.kode_mk,
            mk.nama_mk AS nama_matkul,
            n.nilai,
            n.nilai_huruf
        FROM nilai n
        JOIN mahasiswa m ON n.nim = m.nim
        JOIN mata_kuliah mk ON n.kode_mk = mk.kode_mk
        ORDER BY n.id_nilai
    """;

    try (Connection conn = KoneksiDB.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Nilai n = new Nilai();
            n.setIdNilai(rs.getInt("id_nilai"));
            n.setNim(rs.getString("nim"));
            n.setNamaMahasiswa(rs.getString("nama_mahasiswa")); 
            n.setKodeMk(rs.getString("kode_mk"));
            n.setNamaMatkul(rs.getString("nama_matkul"));       
            n.setNilai(rs.getInt("nilai"));
            n.setNilaiHuruf(rs.getString("nilai_huruf"));
            list.add(n);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
}

        
