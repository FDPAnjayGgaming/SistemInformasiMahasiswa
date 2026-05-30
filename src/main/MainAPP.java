package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import ui.*;

public class MainAPP {
    public static void main(String[] args) {
        try {
          
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            
            
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 10);
            
        } catch (Exception ex) {
            System.err.println("Gagal memuat FlatLaf");
        }

        java.awt.EventQueue.invokeLater(() -> {
            LoginPage login = new LoginPage();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }
}