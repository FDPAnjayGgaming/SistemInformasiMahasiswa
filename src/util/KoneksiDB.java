/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
   
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_mahasiswa?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";        
    private static final String PASS = "";            
    
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Buat koneksi
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(" Koneksi database berhasil!");
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.err.println(" MySQL JDBC Driver tidak ditemukan!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println(" Koneksi database gagal: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    // Test koneksi (untuk debugging)
    public static void testConnection() {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println(" Database siap digunakan!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal koneksi ke database!");
        }
    }

}

