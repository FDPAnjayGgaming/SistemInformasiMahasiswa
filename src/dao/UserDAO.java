/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Admin;
import model.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.KoneksiDB;

public class UserDAO {

    /**
     * Autentikasi untuk Admin menggunakan username dan password
     */
    public Admin loginAdmin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Mengembalikan objek Admin (Username sebagai identifier)
                    return new Admin(
                        rs.getString("username"), 
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error Login Admin: " + e.getMessage());
        }
        return null;
    }

    /**
     * Autentikasi untuk Mahasiswa menggunakan NIM dan Nama Lengkap
     */
    public Mahasiswa loginMahasiswa(String nim, String nama) {
        String sql = "SELECT * FROM mahasiswa WHERE nim = ? AND nama = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nim);
            ps.setString(2, nama);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Mengembalikan objek Mahasiswa lengkap
                    return new Mahasiswa(
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan"),
                        rs.getString("jenis_kelamin"),
                        rs.getString("alamat")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error Login Mahasiswa: " + e.getMessage());
        }
        return null;
    }
}