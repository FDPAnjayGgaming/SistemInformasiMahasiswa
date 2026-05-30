/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class User {
    protected String identifier; // Bisa Username (Admin) atau NIM (Mahasiswa)
    
    public User(String identifier) {
        this.identifier = identifier;
    }
}