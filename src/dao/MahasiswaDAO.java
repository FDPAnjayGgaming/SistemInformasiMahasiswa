/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Mahasiswa;
import util.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    public void insert(Mahasiswa mahasiswa) {
        String sql = "INSERT INTO mahasiswa (nim, nama, jurusan, jenis_kelamin, alamat) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, mahasiswa.getNim());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getJurusan());
            pstmt.setString(4, mahasiswa.getJenisKelamin());
            pstmt.setString(5, mahasiswa.getAlamat());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT nim, nama,jurusan, jenis_kelamin, alamat FROM mahasiswa ORDER BY LENGTH(nim) ASC, nim ASC";
        
        try (Connection conn = KoneksiDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setJurusan(rs.getString("jurusan"));
                m.setJenisKelamin(rs.getString("jenis_kelamin"));
                m.setAlamat(rs.getString("alamat"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void update(Mahasiswa mahasiswa) {
        String sql = "UPDATE mahasiswa SET nama=?, jurusan=?, jenis_kelamin=?, alamat=? WHERE nim=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, mahasiswa.getNama());
            pstmt.setString(2, mahasiswa.getJurusan());
            pstmt.setString(3, mahasiswa.getJenisKelamin());
            pstmt.setString(4, mahasiswa.getAlamat());
            pstmt.setString(5, mahasiswa.getNim());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, nim);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Mahasiswa getByNim(int nim) {
        String sql = "SELECT * FROM mahasiswa WHERE nim=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, nim);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setJurusan(rs.getString("jurusan"));
                m.setJenisKelamin(rs.getString("jenis_kelamin"));
                m.setAlamat(rs.getString("alamat"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}