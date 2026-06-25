package petshopapp;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * Main Frame: Aplikasi Pet Shop - CRUD Produk/Hewan
 * Developer : Hizkia Siallagan
 * NIM       : 231011400154
 * Universitas Pamulang (UNPAM)
 */
public class MainFrame extends JFrame {

    // ── Warna tema ────────────────────────────────────────────────────────────
    private static final Color CLR_PRIMARY   = new Color(0x1976D2);
    private static final Color CLR_PRIMARY_D = new Color(0x1565C0);
    private static final Color CLR_ACCENT    = new Color(0xFF8F00);
    private static final Color CLR_SUCCESS   = new Color(0x388E3C);
    private static final Color CLR_DANGER    = new Color(0xC62828);
    private static final Color CLR_BG        = new Color(0xF5F5F5);
    private static final Color CLR_CARD      = Color.WHITE;
    private static final Color CLR_TBL_HDR   = new Color(0x1976D2);
    private static final Color CLR_TBL_ALT   = new Color(0xE3F2FD);

    // ── Komponen ──────────────────────────────────────────────────────────────
    private JTextField txtKode, txtNama, txtStok, txtHarga, txtCari;
    private JComboBox<String> cmbJenis;
    private JTable tblProduk;
    private DefaultTableModel tblModel;
    private JButton btnTambah, btnUpdate, btnHapus, btnBersihkan, btnCari, btnRefresh;
    private JLabel lblStatus;

    private final ProdukDAO dao = new ProdukDAO();
    private final DecimalFormat df = new DecimalFormat("#,###");

    // ═════════════════════════════════════════════════════════════════════════
    public MainFrame() {
        initUI();
        loadTable(dao.getAll());
        setVisible(true);
    }

    // ─── UI Setup ─────────────────────────────────────────────────────────────
    private void initUI() {
        setTitle("🐾  Pet Shop Management System  |  Dev: Hizkia Siallagan  |  231011400154");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 680);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(CLR_BG);

        setLayout(new BorderLayout(10, 10));
        add(buildHeader(),    BorderLayout.NORTH);
        add(buildCenter(),    BorderLayout.CENTER);
        add(buildStatusBar(), BorderLayout.SOUTH);
    }

    // ─── Header ───────────────────────────────────────────────────────────────
    private JPanel buildHeader() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(CLR_PRIMARY);
        p.setBorder(new EmptyBorder(12, 20, 12, 20));

        JLabel title = new JLabel("🐾  PET SHOP MANAGEMENT SYSTEM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        JLabel sub = new JLabel("Produk & Hewan  |  Hizkia Siallagan  |  NIM: 231011400154  |  UNPAM");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        sub.setForeground(new Color(0xBBDEFB));

        JPanel textP = new JPanel(new GridLayout(2, 1));
        textP.setOpaque(false);
        textP.add(title);
        textP.add(sub);
        p.add(textP, BorderLayout.WEST);
        return p;
    }

    // ─── Center (Form + Table) ─────────────────────────────────────────────────
    private JSplitPane buildCenter() {
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buildFormPanel(), buildTablePanel());
        sp.setDividerLocation(320);
        sp.setDividerSize(5);
        sp.setBorder(new EmptyBorder(8, 8, 4, 8));
        sp.setBackground(CLR_BG);
        return sp;
    }

    // ─── Form Panel ───────────────────────────────────────────────────────────
    private JPanel buildFormPanel() {
        JPanel card = new JPanel(new BorderLayout(0, 10));
        card.setBackground(CLR_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(0xDDDDDD), 1, true),
            new EmptyBorder(16, 16, 16, 16)
        ));

        // Title
        JLabel lbl = new JLabel("Form Input Produk / Hewan");
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(CLR_PRIMARY_D);
        card.add(lbl, BorderLayout.NORTH);

        // Fields
        JPanel fields = new JPanel(new GridBagLayout());
        fields.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(5, 2, 5, 2);

        txtKode  = styledField("PTxxx");
        txtNama  = styledField("Nama produk/hewan");
        cmbJenis = new JComboBox<>(new String[]{
            "Hewan Peliharaan", "Makanan Hewan", "Aksesoris", "Obat & Vitamin",
            "Kandang & Tempat", "Grooming", "Lainnya"
        });
        styleCombo(cmbJenis);
        txtStok  = styledField("0");
        txtHarga = styledField("0");

        addRow(fields, gc, 0, "Kode Produk *",   txtKode);
        addRow(fields, gc, 1, "Nama Produk *",   txtNama);
        addRow(fields, gc, 2, "Jenis *",         cmbJenis);
        addRow(fields, gc, 3, "Stok *",          txtStok);
        addRow(fields, gc, 4, "Harga (Rp) *",    txtHarga);

        card.add(fields, BorderLayout.CENTER);

        // Buttons
        JPanel btnPanel = new JPanel(new GridLayout(3, 2, 6, 6));
        btnPanel.setOpaque(false);

        btnTambah    = makeBtn("➕ Tambah",    CLR_SUCCESS);
        btnUpdate    = makeBtn("✏ Update",     CLR_ACCENT);
        btnHapus     = makeBtn("🗑 Hapus",     CLR_DANGER);
        btnBersihkan = makeBtn("🔄 Bersihkan", new Color(0x607D8B));
        btnTambah.putClientProperty("JButton.buttonType", "default");
        btnUpdate.setEnabled(false);
        btnHapus.setEnabled(false);

        btnPanel.add(btnTambah);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnHapus);
        btnPanel.add(btnBersihkan);

        card.add(btnPanel, BorderLayout.SOUTH);

        // Events
        btnTambah.addActionListener(e -> aksiTambah());
        btnUpdate.addActionListener(e -> aksiUpdate());
        btnHapus.addActionListener(e -> aksiHapus());
        btnBersihkan.addActionListener(e -> bersihkanForm());

        return card;
    }

    // ─── Table Panel ──────────────────────────────────────────────────────────
    private JPanel buildTablePanel() {
        JPanel p = new JPanel(new BorderLayout(0, 6));
        p.setOpaque(false);

        // Search bar
        JPanel searchBar = new JPanel(new BorderLayout(6, 0));
        searchBar.setOpaque(false);
        txtCari    = styledField("Cari kode, nama, atau jenis...");
        txtCari.putClientProperty("JTextField.placeholderText", "Cari kode, nama, atau jenis...");
        txtCari.putClientProperty("JTextField.showClearButton", true);
        btnCari    = makeBtn("🔍 Cari",    CLR_PRIMARY);
        btnRefresh = makeBtn("↺ Refresh", new Color(0x455A64));
        btnCari.setPreferredSize(new Dimension(100, 32));
        btnRefresh.setPreferredSize(new Dimension(100, 32));

        JPanel btnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        btnSearch.setOpaque(false);
        btnSearch.add(btnCari);
        btnSearch.add(btnRefresh);

        searchBar.add(txtCari,    BorderLayout.CENTER);
        searchBar.add(btnSearch,  BorderLayout.EAST);

        // Table
        String[] cols = {"Kode", "Nama Produk/Hewan", "Jenis", "Stok", "Harga (Rp)"};
        tblModel = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblProduk = new JTable(tblModel);
        styleTable(tblProduk);

        JScrollPane scroll = new JScrollPane(tblProduk);
        scroll.setBorder(new LineBorder(new Color(0xDDDDDD), 1));
        scroll.getViewport().setBackground(Color.WHITE);

        p.add(searchBar, BorderLayout.NORTH);
        p.add(scroll,    BorderLayout.CENTER);

        // Events
        btnCari.addActionListener(e -> {
            String kw = txtCari.getText().trim();
            loadTable(kw.isEmpty() ? dao.getAll() : dao.search(kw));
        });
        btnRefresh.addActionListener(e -> {
            txtCari.setText("");
            loadTable(dao.getAll());
        });
        txtCari.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) btnCari.doClick();
            }
        });
        tblProduk.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { isiFormDariTabel(); }
        });

        return p;
    }

    // ─── Status Bar ───────────────────────────────────────────────────────────
    private JPanel buildStatusBar() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(CLR_PRIMARY_D);
        p.setBorder(new EmptyBorder(4, 12, 4, 12));

        lblStatus = new JLabel("✅  Siap digunakan");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblStatus.setForeground(Color.WHITE);

        JLabel dev = new JLabel("© 2025  Hizkia Siallagan  |  NIM: 231011400154  |  Universitas Pamulang");
        dev.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        dev.setForeground(new Color(0xBBDEFB));

        p.add(lblStatus, BorderLayout.WEST);
        p.add(dev,       BorderLayout.EAST);
        return p;
    }

    // ═════ CRUD ACTIONS ══════════════════════════════════════════════════════

    private void aksiTambah() {
        if (!validasiForm()) return;
        Produk p = formToProduk();
        if (dao.getByKode(p.getKode()) != null) {
            setStatus("⚠  Kode '" + p.getKode() + "' sudah terdaftar.", CLR_DANGER);
            return;
        }
        if (dao.tambah(p)) {
            loadTable(dao.getAll());
            bersihkanForm();
            setStatus("✅  Produk berhasil ditambahkan: " + p.getNama(), CLR_SUCCESS);
        }
    }

    private void aksiUpdate() {
        if (!validasiForm()) return;
        Produk p = formToProduk();
        int conf = JOptionPane.showConfirmDialog(this,
            "Update data produk '" + p.getNama() + "'?", "Konfirmasi Update",
            JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION && dao.update(p)) {
            loadTable(dao.getAll());
            bersihkanForm();
            setStatus("✏  Produk berhasil diupdate: " + p.getNama(), CLR_ACCENT);
        }
    }

    private void aksiHapus() {
        String kode = txtKode.getText().trim();
        if (kode.isEmpty()) { setStatus("⚠  Pilih produk dari tabel terlebih dahulu.", CLR_DANGER); return; }
        int conf = JOptionPane.showConfirmDialog(this,
            "Hapus produk dengan kode '" + kode + "'?\nData tidak dapat dikembalikan!",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (conf == JOptionPane.YES_OPTION && dao.hapus(kode)) {
            loadTable(dao.getAll());
            bersihkanForm();
            setStatus("🗑  Produk dengan kode '" + kode + "' berhasil dihapus.", CLR_DANGER);
        }
    }

    // ═════ HELPERS ═══════════════════════════════════════════════════════════

    private void isiFormDariTabel() {
        int row = tblProduk.getSelectedRow();
        if (row < 0) return;
        txtKode.setText(tblModel.getValueAt(row, 0).toString());
        txtNama.setText(tblModel.getValueAt(row, 1).toString());
        cmbJenis.setSelectedItem(tblModel.getValueAt(row, 2).toString());
        txtStok.setText(tblModel.getValueAt(row, 3).toString());

        String hargaStr = tblModel.getValueAt(row, 4).toString()
            .replace("Rp ", "").replace(",", "").replace(".", "").trim();
        txtHarga.setText(hargaStr);

        txtKode.setEditable(false);
        btnTambah.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnHapus.setEnabled(true);
        setStatus("✏  Mengedit: " + tblModel.getValueAt(row, 1), CLR_ACCENT);
    }

    private void bersihkanForm() {
        txtKode.setText(""); txtKode.setEditable(true);
        txtNama.setText(""); txtStok.setText(""); txtHarga.setText("");
        cmbJenis.setSelectedIndex(0);
        btnTambah.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnHapus.setEnabled(false);
        tblProduk.clearSelection();
        setStatus("✅  Form dibersihkan.", CLR_PRIMARY);
    }

    private void loadTable(List<Produk> list) {
        tblModel.setRowCount(0);
        for (Produk p : list) {
            tblModel.addRow(new Object[]{
                p.getKode(),
                p.getNama(),
                p.getJenis(),
                p.getStok(),
                "Rp " + df.format(p.getHarga())
            });
        }
        setStatus("📋  Menampilkan " + list.size() + " data produk/hewan.", CLR_PRIMARY);
    }

    private Produk formToProduk() {
        double harga = 0;
        int    stok  = 0;
        try { harga = Double.parseDouble(txtHarga.getText().trim().replace(",", "")); } catch (NumberFormatException ignored) {}
        try { stok  = Integer.parseInt(txtStok.getText().trim()); } catch (NumberFormatException ignored) {}
        return new Produk(
            txtKode.getText().trim().toUpperCase(),
            txtNama.getText().trim(),
            cmbJenis.getSelectedItem().toString(),
            stok, harga
        );
    }

    private boolean validasiForm() {
        if (txtKode.getText().trim().isEmpty())  { warn("Kode produk tidak boleh kosong!"); return false; }
        if (txtNama.getText().trim().isEmpty())  { warn("Nama produk tidak boleh kosong!"); return false; }
        if (txtStok.getText().trim().isEmpty())  { warn("Stok tidak boleh kosong!");         return false; }
        if (txtHarga.getText().trim().isEmpty()) { warn("Harga tidak boleh kosong!");        return false; }
        try { Integer.parseInt(txtStok.getText().trim()); }
        catch (NumberFormatException e) { warn("Stok harus berupa angka!"); return false; }
        try { Double.parseDouble(txtHarga.getText().trim().replace(",","")); }
        catch (NumberFormatException e) { warn("Harga harus berupa angka!"); return false; }
        return true;
    }

    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Validasi", JOptionPane.WARNING_MESSAGE);
        setStatus("⚠  " + msg, CLR_DANGER);
    }

    private void setStatus(String msg, Color clr) {
        lblStatus.setText(msg);
        lblStatus.setForeground(clr == CLR_PRIMARY ? Color.WHITE : clr);
    }

    // ─── Style Helpers ────────────────────────────────────────────────────────
    private JTextField styledField(String placeholder) {
        JTextField f = new JTextField();
        f.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        f.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(0xBDBDBD), 1, true),
            new EmptyBorder(5, 8, 5, 8)
        ));
        f.setToolTipText(placeholder);
        return f;
    }

    private void styleCombo(JComboBox<String> c) {
        c.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        c.setBackground(Color.WHITE);
    }

    private JButton makeBtn(String text, Color bg) {
    JButton b = new JButton(text);
    b.setFont(new Font("Segoe UI", Font.BOLD, 12));
    b.setBackground(bg);
    b.setForeground(Color.WHITE);
    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b.putClientProperty("JButton.buttonType", "roundRect"); // bentuk flat ala FlatLaf
    b.putClientProperty("JComponent.minimumWidth", 0);
    return b;
}
   
    private void styleTable(JTable t) {
        t.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        t.setRowHeight(28);
        t.setShowHorizontalLines(true);
        t.setGridColor(new Color(0xE0E0E0));
        t.setSelectionBackground(new Color(0xBBDEFB));
        t.setSelectionForeground(Color.BLACK);
        t.setAutoCreateRowSorter(true);

        // Header style
        JTableHeader header = t.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(CLR_TBL_HDR);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 32));

        // Column widths
        t.getColumnModel().getColumn(0).setPreferredWidth(80);
        t.getColumnModel().getColumn(1).setPreferredWidth(200);
        t.getColumnModel().getColumn(2).setPreferredWidth(130);
        t.getColumnModel().getColumn(3).setPreferredWidth(60);
        t.getColumnModel().getColumn(4).setPreferredWidth(120);

        // Alternating row color
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                if (!isSelected) setBackground(row % 2 == 0 ? Color.WHITE : CLR_TBL_ALT);
                setBorder(new EmptyBorder(0, 8, 0, 8));
                // Right-align numeric columns
                setHorizontalAlignment(col >= 3 ? SwingConstants.RIGHT : SwingConstants.LEFT);
                return this;
            }
        });
    }

    private void addRow(JPanel p, GridBagConstraints gc, int row, String label, JComponent comp) {
        gc.gridx = 0; gc.gridy = row; gc.weightx = 0.35;
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        p.add(lbl, gc);
        gc.gridx = 1; gc.weightx = 0.65;
        p.add(comp, gc);
    }
}
