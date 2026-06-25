<div align="center">

# 🐾 PetShopApp

### Pet Shop Management System — Desktop CRUD Application

Aplikasi desktop manajemen data produk & hewan peliharaan berbasis **Java Swing** dengan database **MySQL**, dibangun di atas project **NetBeans (Ant-based)**.

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)](#)
[![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql&logoColor=white)](#)
[![NetBeans](https://img.shields.io/badge/IDE-NetBeans-1B6AC6?logo=apache-netbeans-ide)](#)
[![License](https://img.shields.io/badge/License-MIT-green)](#-lisensi)

</div>

---

## 📖 Tentang Aplikasi

**PetShopApp** adalah aplikasi desktop sederhana untuk mengelola data **produk dan hewan peliharaan** pada sebuah Pet Shop. Aplikasi ini dibangun sebagai implementasi konsep **Pemrograman Berorientasi Objek (OOP)** dan operasi **CRUD (Create, Read, Update, Delete)** menggunakan Java Swing untuk antarmuka dan MySQL (via JDBC) sebagai media penyimpanan data.

| Info | Keterangan |
|---|---|
| 👤 Developer | **Hizkia Siallagan** |
| 🆔 NIM | 231011400154 |
| 🏫 Institusi | Universitas Pamulang (UNPAM) |
| 🎓 Program Studi | Teknik Informatika |
| 📚 Mata Kuliah | Pemrograman Berbasis Objek / Praktikum Java |

---

## ✨ Fitur Utama

- ➕ **Tambah Data** — menambahkan data produk/hewan baru ke database
- 📋 **Lihat Data** — menampilkan seluruh data dalam tabel (JTable)
- ✏️ **Update Data** — mengubah data yang sudah ada
- 🗑️ **Hapus Data** — menghapus data dengan konfirmasi dialog
- 🔍 **Cari Data** — pencarian berdasarkan kode, nama, atau jenis
- ↺ **Refresh Data** — memuat ulang data terbaru dari database
- ✅ **Validasi Input** — mencegah data kosong/format salah sebelum disimpan

---

## 🛠️ Tech Stack

| Layer | Teknologi |
|---|---|
| Bahasa | Java (JDK 11+) |
| GUI | Java Swing (GridBagLayout, JTable, JOptionPane) |
| Database | MySQL 8.x |
| Konektor | MySQL Connector/J (JDBC) |
| IDE | Apache NetBeans (Ant-based project) |
| Arsitektur | MVC sederhana (Model–DAO–View) |

---

## 📁 Struktur Project

```
PetShopApp/
├── nbproject/
│   ├── project.xml
│   └── project.properties
├── src/
│   └── petshopapp/
│       ├── MainApp.java             ← Entry point aplikasi
│       ├── MainFrame.java           ← GUI utama (Swing)
│       ├── Produk.java              ← Model / Entity
│       ├── ProdukDAO.java           ← Data Access Object (CRUD ke MySQL)
│       └── DatabaseConnection.java  ← Koneksi JDBC ke MySQL
├── lib/
│   └── mysql-connector-j-8.0.33.jar ← (download manual, lihat instalasi)
├── manifest.mf
├── build.xml
├── db_Petshop_231011400154.sql      ← Script pembuatan database
├── README.md
└── USE_CASE.md                      ← Dokumentasi use case lengkap
```

---

## 🗄️ Struktur Database

**Database:** `db_Petshop_231011400154`
**Tabel:** `produk_hewan`

| Kolom    | Tipe Data      | Keterangan        |
|----------|----------------|--------------------|
| `kode`   | VARCHAR(20)    | Primary Key        |
| `nama`   | VARCHAR(100)   | Nama produk/hewan   |
| `jenis`  | VARCHAR(50)    | Kategori/jenis      |
| `stok`   | INT            | Jumlah stok         |
| `harga`  | DECIMAL(15,2)  | Harga satuan (Rp)   |

---

## 🚀 Instalasi & Menjalankan Project

### 1. Clone repository
```bash
git clone https://github.com/<username>/PetShopApp.git
cd PetShopApp
```

### 2. Siapkan Database MySQL
Jalankan file `db_Petshop_231011400154.sql` melalui phpMyAdmin, MySQL Workbench, atau terminal:
```bash
mysql -u root -p < db_Petshop_231011400154.sql
```

### 3. Download MySQL Connector/J
Unduh dari situs resmi: https://dev.mysql.com/downloads/connector/j/
Pilih versi **8.0.x → Platform Independent → ZIP**, ekstrak, lalu salin file `.jar`-nya ke folder `lib/` pada project ini.

### 4. Buka project di NetBeans
1. **File → Open Project** → pilih folder `PetShopApp`
2. Klik kanan project → **Properties → Libraries** → pastikan `mysql-connector-j-x.x.x.jar` sudah ditambahkan
3. Sesuaikan kredensial MySQL (jika perlu) di `src/petshopapp/DatabaseConnection.java`:
   ```java
   private static final String USERNAME = "root";
   private static final String PASSWORD = "";
   ```
4. Klik **Run Project** (Shift+F6 / F6)

---

## 🖥️ Tampilan Aplikasi

> Tambahkan screenshot aplikasi Anda di sini setelah dijalankan, contoh:
>
> | Tampilan Utama | Form Tambah Data |
> |---|---|
> | `![main](docs/screenshot-main.png)` | `![tambah](docs/screenshot-tambah.png)` |

---

## 📋 Use Case

Dokumentasi use case diagram lengkap beserta skenario tiap fitur tersedia di **[USE_CASE.md](USE_CASE.md)**.

---

## ❗ Troubleshooting

| Masalah | Solusi |
|---|---|
| `Driver MySQL tidak ditemukan` | Pastikan `.jar` connector sudah ada di `lib/` dan ditambahkan sebagai Library di NetBeans |
| `Gagal konek ke database` | Pastikan MySQL server aktif (XAMPP/WAMP/MySQL Server) dan database sudah dibuat |
| `package does not exist` saat build | Klik kanan project → **Clean and Build** ulang |
| Tampilan GUI tidak rapi | Pastikan JDK ≥ 11 dan Look and Feel sistem terdukung |

---

## 🗺️ Roadmap Pengembangan

- [ ] Tambah fitur login/autentikasi petugas
- [ ] Export data ke PDF/Excel
- [ ] Laporan stok & transaksi penjualan
- [ ] Relasi tabel transaksi & pelanggan
- [ ] Migrasi UI ke FlatLaf / tema modern

---

## 📄 Lisensi

Project ini dibuat untuk keperluan **akademik** (Tugas Akhir / Praktikum) di Universitas Pamulang. Bebas digunakan dan dimodifikasi untuk tujuan pembelajaran.

---

<div align="center">

Dibuat dengan ❤️ oleh **Hizkia Siallagan** — NIM 231011400154

</div>
