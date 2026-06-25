package petshopapp;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Entry Point Aplikasi Pet Shop
 * Developer : Hizkia Siallagan
 * NIM       : 231011400154
 * Universitas Pamulang (UNPAM)
 */
public class MainApp {

    public static void main(String[] args) {
        // ── Look and Feel modern via FlatLaf ──────────────────────────────
        FlatLightLaf.setup();

        // Kustomisasi global (opsional, biar makin senada dengan tema biru kamu)
        UIManager.put("Button.arc", 10);
        UIManager.put("Component.arc", 8);
        UIManager.put("TextComponent.arc", 8);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.focusColor", new java.awt.Color(0x1976D2));
        UIManager.put("Button.default.background", new java.awt.Color(0x1976D2));
        UIManager.put("Button.default.foreground", java.awt.Color.WHITE);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", false);

        // Jalankan di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            if (!DatabaseConnection.testConnection()) {
                System.err.println("Koneksi database gagal. Periksa konfigurasi di DatabaseConnection.java");
                // Tetap buka window agar user tahu errornya
            }
            new MainFrame();
        });
    }
}