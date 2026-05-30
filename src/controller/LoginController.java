/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import model.Admin;
import model.Mahasiswa;

public class LoginController {
    private  UserDAO userDAO = new UserDAO();
   public Object doLogin(String in1, String in2) {
    // Memanggil DAO untuk cek Admin
    model.Admin admin = userDAO.loginAdmin(in1, in2);
    if (admin != null) return admin;

    // Memanggil DAO untuk cek Mahasiswa
    model.Mahasiswa mhs = userDAO.loginMahasiswa(in1, in2);
    if (mhs != null) return mhs;

    return null;


   }    
}