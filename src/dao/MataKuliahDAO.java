/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.MataKuliah;
import util.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MataKuliahDAO {
    public void insert(MataKuliah mk) {
        String sql = "INSERT INTO mata_kuliah (kode_mk, nama_mk, sks) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, mk.getKodeMk());
            pstmt.setString(2, mk.getNamaMk());
            pstmt.setInt(3, mk.getSks());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<MataKuliah> getAll() {
        List<MataKuliah> list = new ArrayList<>();
        String sql = "SELECT * FROM mata_kuliah";
        
        try (Connection conn = KoneksiDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                MataKuliah mk = new MataKuliah();
                mk.setKodeMk(rs.getString("kode_mk"));
                mk.setNamaMk(rs.getString("nama_mk"));
                mk.setSks(rs.getInt("sks"));
                list.add(mk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
        public void update(MataKuliah mk) {
        String sql = "UPDATE mata_kuliah SET nama_mk=?, sks=? WHERE kode_mk=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mk.getNamaMk());
            ps.setInt(2, mk.getSks());
            ps.setString(3, mk.getKodeMk());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal update mata kuliah");
        }
    }

public void delete(String kodeMk) {
    String sql = "DELETE FROM mata_kuliah WHERE kode_mk=?";
    try (Connection conn = KoneksiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, kodeMk);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Gagal hapus mata kuliah");
    }
}

public MataKuliah getByKode(String kodeMk) {
    String sql = "SELECT * FROM mata_kuliah WHERE kode_mk=?";
    try (Connection conn = KoneksiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, kodeMk);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            MataKuliah mk = new MataKuliah();
            mk.setKodeMk(rs.getString("kode_mk"));
            mk.setNamaMk(rs.getString("nama_mk"));
            mk.setSks(rs.getInt("sks"));
            return mk;
        }
        return null;

    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Gagal ambil mata kuliah");
    }
}

    }
