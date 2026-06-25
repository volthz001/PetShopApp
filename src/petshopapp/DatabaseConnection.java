package petshopapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Koneksi Database MySQL
 * Developer : Hizkia Siallagan
 * NIM       : 231011400154
 * DB Name   : db_Petshop_231011400154
 */
public class DatabaseConnection {

    private static final String HOST     = "localhost";
    private static final String PORT     = "3306";
    private static final String DB_NAME  = "db_Petshop_231011400154";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static final String URL =
        "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
        + "?useSSL=false&serverTimezone=Asia/Jakarta&allowPublicKeyRetrieval=true";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                "Driver MySQL tidak ditemukan!\nPastikan mysql-connector sudah ada di folder lib.",
                "Error Driver", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Gagal konek ke database!\n" + e.getMessage()
                + "\n\nPastikan:\n- MySQL server berjalan\n- Database '" + DB_NAME + "' sudah dibuat\n- Username/password sesuai",
                "Error Koneksi", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public static boolean testConnection() {
        Connection conn = getConnection();
        if (conn != null) {
            try { conn.close(); } catch (SQLException ignored) {}
            return true;
        }
        return false;
    }
}
