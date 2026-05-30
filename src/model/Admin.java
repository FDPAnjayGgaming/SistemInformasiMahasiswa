/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// Admin mewarisi User
public class Admin extends User {
    private String password;

    public Admin(String username, String password) {
        super(username); // Username disimpan di 'identifier'
        this.password = password;
    }
}
    