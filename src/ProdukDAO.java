package petshopapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * DAO: Operasi CRUD Produk/Hewan ke MySQL
 * Developer : Hizkia Siallagan
 * NIM       : 231011400154
 */
public class ProdukDAO {

    // ─── CREATE ──────────────────────────────────────────────────────────────
    public boolean tambah(Produk p) {
        String sql = "INSERT INTO produk_hewan (kode, nama, jenis, stok, harga) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getJenis());
            ps.setInt   (4, p.getStok());
            ps.setDouble(5, p.getHarga());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null,
                    "Kode produk '" + p.getKode() + "' sudah ada!\nGunakan kode yang berbeda.",
                    "Duplikat Kode", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menambah data:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }

    // ─── READ ALL ─────────────────────────────────────────────────────────────
    public List<Produk> getAll() {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM produk_hewan ORDER BY kode";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Produk(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getInt   ("stok"),
                    rs.getDouble("harga")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    // ─── READ BY KODE ─────────────────────────────────────────────────────────
    public Produk getByKode(String kode) {
        String sql = "SELECT * FROM produk_hewan WHERE kode = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Produk(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getInt   ("stok"),
                    rs.getDouble("harga")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // ─── SEARCH ───────────────────────────────────────────────────────────────
    public List<Produk> search(String keyword) {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM produk_hewan WHERE kode LIKE ? OR nama LIKE ? OR jenis LIKE ? ORDER BY kode";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String kw = "%" + keyword + "%";
            ps.setString(1, kw);
            ps.setString(2, kw);
            ps.setString(3, kw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Produk(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getInt   ("stok"),
                    rs.getDouble("harga")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    // ─── UPDATE ───────────────────────────────────────────────────────────────
    public boolean update(Produk p) {
        String sql = "UPDATE produk_hewan SET nama=?, jenis=?, stok=?, harga=? WHERE kode=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNama());
            ps.setString(2, p.getJenis());
            ps.setInt   (3, p.getStok());
            ps.setDouble(4, p.getHarga());
            ps.setString(5, p.getKode());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengupdate data:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // ─── DELETE ───────────────────────────────────────────────────────────────
    public boolean hapus(String kode) {
        String sql = "DELETE FROM produk_hewan WHERE kode = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
