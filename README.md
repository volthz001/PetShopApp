# PetShopApp 🐾

**Sistem Informasi Manajemen Toko Hewan Peliharaan**  
Aplikasi desktop Java untuk mengelola inventori, penjualan, dan data produk toko hewan dengan antarmuka GUI yang intuitif.

---

## 📋 Daftar Isi

- [Fitur Utama](#-fitur-utama)
- [Persyaratan Sistem](#-persyaratan-sistem)
- [Instalasi](#-instalasi)
- [Cara Penggunaan](#-cara-penggunaan)
- [Tampilan Aplikasi](#-tampilan-aplikasi)
- [Use Case Diagram](#-use-case-diagram)
- [Troubleshooting](#-troubleshooting)
- [Struktur Database](#-struktur-database)
- [Kontribusi](#-kontribusi)
- [Lisensi](#-lisensi)

---

## ✨ Fitur Utama

- ✅ **CRUD Lengkap** — Tambah, baca, ubah, dan hapus data produk/hewan
- ✅ **Antarmuka GUI Responsif** — Aplikasi desktop dengan tabel data interaktif
- ✅ **Database MySQL** — Penyimpanan data terintegrasi dan reliable
- ✅ **Validasi Input** — Pencegahan data kosong atau tidak valid
- ✅ **Dialog Konfirmasi** — Persetujuan sebelum penghapusan data (aman dari tindakan tidak sengaja)
- ✅ **Status Bar** — Pesan feedback real-time untuk setiap aksi
- ✅ **Search/Filter** — Pencarian dan filter data produk (optional, bergantung implementasi)

---

## 💻 Persyaratan Sistem

### Minimum Requirements
| Komponen | Versi | Keterangan |
|----------|-------|-----------|
| **Java Runtime Environment (JRE)** | 11 atau lebih tinggi | Untuk menjalankan aplikasi |
| **Java Development Kit (JDK)** | 11 atau lebih tinggi | Untuk kompilasi (development) |
| **MySQL Server** | 5.7 atau 8.0+ | Database backend |
| **RAM** | 512 MB minimum | Minimum untuk aplikasi berjalan lancar |
| **Disk Space** | 200 MB | Untuk instalasi aplikasi + database |

### Software Dependencies
```
Java Swing (built-in dengan JDK)
MySQL Connector/J (untuk koneksi MySQL)
Apache Commons Lang3 (utility library, optional)
```

---

## 🚀 Instalasi

### Langkah 1: Install Java Development Kit (JDK)

**Windows:**
```bash
# Download dari https://www.oracle.com/java/technologies/downloads/
# Pilih JDK 11+ → installer Windows → jalankan setup

# Verifikasi instalasi
java -version
javac -version
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-11-jdk
java -version
```

**macOS:**
```bash
brew install openjdk@11
java -version
```

---

### Langkah 2: Install MySQL Server

**Windows:**
```bash
# Download dari https://dev.mysql.com/downloads/mysql/
# Jalankan installer dan ikuti wizard setup
# Set root password dan catat untuk nanti

# Verifikasi
mysql -u root -p
# Masukkan password yang Anda buat
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation

# Verifikasi
mysql -u root -p
```

**macOS:**
```bash
brew install mysql
brew services start mysql
mysql -u root
```

---

### Langkah 3: Buat Database dan Import Schema

```bash
# Login ke MySQL
mysql -u root -p

# Di MySQL console, jalankan:
CREATE DATABASE petshop_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE petshop_db;

# Import schema (lihat bagian "Struktur Database" di bawah)
# Kemudian exit
EXIT;
```

---

### Langkah 4: Clone Repository

```bash
# Menggunakan HTTPS
git clone https://github.com/volthz001/PetShopApp.git
cd PetShopApp

# ATAU menggunakan SSH (jika sudah setup)
git clone git@github.com:volthz001/PetShopApp.git
cd PetShopApp
```

---

### Langkah 5: Konfigurasi Koneksi Database

**Lokasi file:** `PetShopApp/src/config/DatabaseConfig.java` (atau sesuaikan dengan struktur Anda)

```java
public class DatabaseConfig {
    // Database Configuration
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "petshop_db";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "password_anda"; // Ganti dengan password Anda
    
    public static final String DB_URL = 
        "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
        + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
}
```

---

### Langkah 6: Compile dan Run Aplikasi

**Menggunakan IDE (NetBeans/IntelliJ IDEA):**
1. Buka project di IDE pilihan Anda
2. Build project (`Ctrl+Shift+B`)
3. Jalankan aplikasi (`Shift+F6`)

**Menggunakan Command Line:**
```bash
# Navigate ke project root
cd PetShopApp

# Compile (jika menggunakan Maven)
mvn clean compile

# Jalankan
mvn exec:java -Dexec.mainClass="com.petshop.Main"

# ATAU jika project sederhana
javac -d bin src/**/*.java
java -cp bin:lib/* com.petshop.Main
```

---

## 📖 Cara Penggunaan

### 1. **Membuka Aplikasi**
- Jalankan aplikasi melalui IDE atau command line
- Tunggu sampai form utama terbuka dan tabel produk terisi

### 2. **Menambah Data Produk Baru**
```
1. Isi form input:
   - ID Produk (contoh: PT001)
   - Nama Produk/Hewan (contoh: Anjing Poodle)
   - Harga
   - Stok
   - Kategori (optional)

2. Klik tombol "Tambah" atau "Add"
3. Tunggu pesan sukses di status bar
4. Data baru muncul di tabel
```

### 3. **Mengubah Data Produk**
```
1. Klik salah satu baris di tabel (pilih data yang ingin diubah)
2. Form otomatis terisi dengan data terpilih
3. Edit field yang diperlukan
4. Klik tombol "Update" atau "Ubah"
5. Konfirmasi perubahan jika ada dialog
6. Data di tabel ter-update secara real-time
```

### 4. **Menghapus Data Produk**
```
1. Klik baris data di tabel (pilih data yang ingin dihapus)
2. Klik tombol "Hapus" atau "Delete"
3. Konfirmasi penghapusan di dialog pop-up
4. Jika dikonfirmasi, data dihapus dari database
5. Tabel ter-refresh dan menampilkan sisa data
```

### 5. **Melihat Riwayat/Pencarian** (jika ada fitur)
```
- Gunakan field search untuk filter data
- Atau gunakan dropdown kategori untuk filter
- Tekan "Reset" untuk menampilkan semua data
```

---

## 🖥️ Tampilan Aplikasi

### Tampilan Utama
![Tampilan Utama Aplikasi](images/01-tampilan-utama.png)
*Form kosong dengan tabel berisi 9 data produk/hewan peliharaan. Tombol aksi (Tambah, Ubah, Hapus) tersedia di bawah form input.*

### Memilih & Mengedit Data
![Pilih Data untuk Edit](images/02-pilih-data-edit.png)
*Data PT009 dipilih dari tabel → form otomatis terisi dengan data terpilih → tombol Update & Hapus aktif siap digunakan.*

### Konfirmasi Hapus Data
![Konfirmasi Hapus](images/03-konfirmasi-hapus.png)
*Dialog konfirmasi muncul sebelum penghapusan untuk mencegah tindakan tidak sengaja.*

### Data Berhasil Dihapus
![Setelah Hapus](images/04-setelah-hapus.png)
*Data PT009 berhasil dihapus dari database → tabel kembali menjadi 8 baris → status bar menampilkan pesan sukses.*

### Data Berhasil Ditambahkan
![Setelah Tambah](images/05-setelah-tambah.png)
*Data baru PT009 (Anjing BullDog) berhasil ditambahkan → tabel kembali menjadi 9 baris dengan data terbaru.*

---

## 📋 Use Case Diagram

![Use Case Diagram](images/06-use-case-diagram.png)

### Deskripsi Use Case

| Use Case | Aktor | Deskripsi |
|----------|-------|-----------|
| **View Products** | Admin, Staff | Menampilkan daftar semua produk dari database |
| **Add Product** | Admin | Menambah produk baru ke database (include: Validate Input) |
| **Edit Product** | Admin | Mengubah data produk yang sudah ada |
| **Delete Product** | Admin | Menghapus produk dari database (include: Confirm Action) |
| **Search Product** | Admin, Staff | Mencari atau filter produk berdasarkan criteria |
| **Generate Report** | Admin | Membuat laporan inventori atau penjualan (optional) |

**Relationships:**
- `Validate Input` ⟵ *include* ⟵ `Add Product`
- `Confirm Action` ⟵ *include* ⟵ `Delete Product`
- **Database MySQL** ↔ System (simpan/ambil data)

---

## 🐛 Troubleshooting

### ❌ Error: "Connection refused: connect"

**Penyebab:**
- MySQL Server tidak running
- Host atau port database salah
- Credentials database tidak valid

**Solusi:**
```bash
# 1. Pastikan MySQL berjalan
# Windows
net start MySQL80  # atau MySQL57, tergantung versi

# Linux
sudo service mysql start

# macOS
brew services start mysql

# 2. Verifikasi koneksi manual
mysql -h localhost -u root -p -e "SELECT 1"

# 3. Cek file config di aplikasi
# - Edit DatabaseConfig.java
# - Verifikasi DB_HOST, DB_PORT, DB_USER, DB_PASSWORD
```

---

### ❌ Error: "No suitable driver found for jdbc:mysql"

**Penyebab:**
- MySQL Connector/J JAR tidak ditambahkan ke classpath
- Path library tidak benar

**Solusi:**

**Jika menggunakan Maven** (`pom.xml`):
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```
Kemudian jalankan:
```bash
mvn clean install
```

**Jika manual:**
1. Download `mysql-connector-java-8.0.33.jar` dari https://dev.mysql.com/downloads/connector/j/
2. Tambahkan ke folder `lib/` project
3. Di IDE: Right-click project → Build Path → Configure Build Path → Library → Add JARs

---

### ❌ Error: "Access denied for user 'root'@'localhost'"

**Penyebab:**
- Password di config tidak sesuai dengan password MySQL sebenarnya

**Solusi:**
```bash
# 1. Reset password MySQL (Windows)
mysql -u root
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password_baru';
FLUSH PRIVILEGES;
EXIT;

# 2. Update DatabaseConfig.java dengan password baru
# 3. Recompile dan run ulang
```

---

### ❌ Error: "Table doesn't exist" atau "Unknown database"

**Penyebab:**
- Database atau tabel belum dibuat
- Database salah dipilih

**Solusi:**
```bash
# Login ke MySQL
mysql -u root -p

# Cek database yang ada
SHOW DATABASES;

# Jika petshop_db tidak ada, buat:
CREATE DATABASE petshop_db CHARACTER SET utf8mb4;
USE petshop_db;

# Import schema (baca bagian "Struktur Database")
```

---

### ❌ Error: "Port 3306 already in use"

**Penyebab:**
- MySQL Server sudah running di instance lain
- Port 3306 dipakai aplikasi lain

**Solusi:**
```bash
# Windows - Cek process di port 3306
netstat -ano | findstr :3306

# Kill process (ganti PID)
taskkill /PID 1234 /F

# Atau jalankan MySQL di port berbeda
# Edit my.ini dan ubah port=3307
# Update DatabaseConfig.java: DB_PORT = "3307"
```

---

### ⚠️ Aplikasi Hang/Freeze saat Load Data

**Penyebab:**
- Koneksi database timeout
- Query terlalu lambat (data banyak)
- Thread tidak async

**Solusi:**
```java
// Gunakan SwingWorker untuk query background
SwingWorker<List<Product>, Void> worker = new SwingWorker<List<Product>, Void>() {
    @Override
    protected List<Product> doInBackground() throws Exception {
        return loadDataFromDatabase(); // Long-running query
    }
    
    @Override
    protected void done() {
        try {
            List<Product> products = get();
            updateTableUI(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};
worker.execute();
```

---

### ✅ Aplikasi jalan tapi tabel kosong

**Penyebab:**
- Data belum diinput ke database
- Query SELECT tidak mengembalikan hasil

**Solusi:**
```bash
# Cek tabel di MySQL
mysql -u root -p petshop_db
SELECT * FROM products;  # (atau nama tabel Anda)

# Jika kosong, insert sample data
INSERT INTO products (id_produk, nama, harga, stok) 
VALUES ('PT001', 'Anjing Poodle', 5000000, 2);
```

---

## 🗄️ Struktur Database

### Schema Database `petshop_db`

#### Tabel: `products` (atau `animals`)

```sql
CREATE TABLE IF NOT EXISTS products (
    id_produk VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    kategori VARCHAR(50),
    deskripsi TEXT,
    harga DECIMAL(12, 2) NOT NULL,
    stok INT DEFAULT 0,
    status ENUM('Aktif', 'Tidak Aktif') DEFAULT 'Aktif',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

#### Tabel: `transactions` (optional - untuk tracking penjualan)

```sql
CREATE TABLE IF NOT EXISTS transactions (
    id_transaksi INT AUTO_INCREMENT PRIMARY KEY,
    id_produk VARCHAR(10),
    jumlah INT NOT NULL,
    harga_satuan DECIMAL(12, 2),
    total DECIMAL(12, 2),
    tanggal_transaksi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_produk) REFERENCES products(id_produk)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

### Sample Data

```sql
INSERT INTO products (id_produk, nama, kategori, harga, stok) VALUES
('PT001', 'Anjing Poodle', 'Anjing', 5000000, 2),
('PT002', 'Kucing Persia', 'Kucing', 3000000, 5),
('PT003', 'Burung Beo', 'Burung', 2000000, 3),
('PT004', 'Hamster', 'Rodent', 500000, 10),
('PT005', 'Ikan Arwana', 'Ikan', 8000000, 1),
('PT006', 'Kelinci', 'Mamalia Kecil', 1500000, 4),
('PT007', 'Tarantula', 'Reptil', 2500000, 2),
('PT008', 'Cockatiel', 'Burung', 3500000, 3),
('PT009', 'Anjing BullDog', 'Anjing', 7000000, 1);
```

---

## 💼 Use Cases (Skenario Penggunaan)

### Use Case 1: Admin Mengelola Stok Harian

**Scenario:**
Setiap pagi, admin toko membuka aplikasi untuk:
1. ✓ Melihat stok produk terkini (view all products)
2. ✓ Update stok yang baru datang dari supplier (edit stok)
3. ✓ Tandai produk yang sold out (delete atau ubah status)
4. ✓ Catat penjualan dari kemarin

**Implementasi di Aplikasi:**
```
1. Admin login → Tampil tabel stok
2. Hewan baru tiba → Tambah produk baru
3. Hewan terjual → Update stok (kurang 1)
4. Hewan mati/tidak laku → Hapus dari database
```

---

### Use Case 2: Pencarian Produk Spesifik

**Scenario:**
Pelanggan datang mencari "Anjing ras Poodle", staff mencari data di sistem:

**Implementasi di Aplikasi:**
```
1. Staff ketik "Poodle" di search bar
2. Sistem filter dan tampilkan: PT001 - Anjing Poodle
3. Staff bisa lihat harga, stok, deskripsi
4. Informasi diberikan ke pelanggan
```

---

### Use Case 3: Laporan Inventori Bulanan

**Scenario:**
Manager ingin laporan nilai inventori untuk keperluan keuangan:

**Implementasi (future feature):**
```sql
SELECT 
    nama, 
    stok, 
    harga,
    (stok * harga) AS nilai_inventori
FROM products
WHERE status = 'Aktif'
ORDER BY nilai_inventori DESC;
```

---

### Use Case 4: Integrasi Point of Sale (POS)

**Scenario:**
Saat transaksi di kasir, aplikasi dapat:
1. ✓ Query produk yang dijual
2. ✓ Kurangi stok otomatis
3. ✓ Simpan ke tabel `transactions`
4. ✓ Hitung total + pajak

---

## 🔧 Stack Teknologi

| Komponen | Teknologi | Versi |
|----------|-----------|-------|
| **IDE** | NetBeans / IntelliJ IDEA | Terbaru |
| **Language** | Java | 11+ |
| **GUI** | Java Swing | Built-in |
| **Database** | MySQL | 5.7, 8.0+ |
| **JDBC Driver** | MySQL Connector/J | 8.0.33+ |
| **Build Tool** | Maven (optional) | 3.6+ |

---

## 📁 Struktur Project

```
PetShopApp/
├── PetShopApp/
│   ├── src/
│   │   ├── com/
│   │   │   └── petshop/
│   │   │       ├── Main.java
│   │   │       ├── config/
│   │   │       │   └── DatabaseConfig.java
│   │   │       ├── database/
│   │   │       │   └── DatabaseConnection.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       ├── dao/
│   │   │       │   └── ProductDAO.java
│   │   │       └── ui/
│   │   │           └── MainWindow.java
│   │   └── resources/
│   │       └── schema.sql
│   ├── lib/
│   │   └── mysql-connector-java-8.0.33.jar
│   └── pom.xml (jika menggunakan Maven)
├── images/
│   ├── 01-tampilan-utama.png
│   ├── 02-pilih-data-edit.png
│   ├── 03-konfirmasi-hapus.png
│   ├── 04-setelah-hapus.png
│   ├── 05-setelah-tambah.png
│   └── 06-use-case-diagram.png
├── README.md
└── LICENSE
```

---

## 🤝 Kontribusi

Kontribusi sangat diterima! Silakan:

1. **Fork** repository ini
2. **Buat branch** fitur baru (`git checkout -b feature/NamaFitur`)
3. **Commit** perubahan (`git commit -m "Add: Deskripsi fitur"`)
4. **Push** ke branch (`git push origin feature/NamaFitur`)
5. **Buat Pull Request** dengan penjelasan detail

### Saran Fitur untuk Development Lanjutan:
- ✨ Fitur search/filter produk
- ✨ Laporan inventori (export PDF/Excel)
- ✨ Multi-user authentication
- ✨ Integrasi POS untuk checkout
- ✨ Dashboard statistik penjualan
- ✨ Backup database otomatis

---

## 📝 Lisensi

Project ini dilisensikan di bawah **MIT License** — Lihat file [LICENSE](LICENSE) untuk detail lengkap.

```
MIT License

Copyright (c) 2025 Voltz (volthz001)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files...
```

---

## 👥 Author

**Voltz** (volthz001)  
Informatics Engineering Student — Universitas Pamulang  
📧 Email: [contact information]  
🔗 GitHub: [@volthz001](https://github.com/volthz001)

---

## 📞 Support & Questions

Jika ada pertanyaan atau menemukan bug:

1. **Buka Issue** di GitHub → https://github.com/volthz001/PetShopApp/issues
2. **Cantumkan:**
   - Versi Java & MySQL
   - Screenshot error atau log file
   - Langkah untuk reproduce error
3. **Berikan tracking ID** jika memungkinkan

---

## 🎯 Roadmap v2.0

- [ ] Fitur search/filter real-time
- [ ] Export laporan ke PDF
- [ ] Authentication & role management
- [ ] Mobile app companion (Flutter/React Native)
- [ ] REST API backend (Spring Boot)
- [ ] Dashboard analytics
- [ ] Backup database otomatis
- [ ] Dark mode UI

---

**Last Updated:** June 2025  
**Versi:** 1.0.0  
**Status:** Active Development

---

## 📚 Resources & References

- [Java Documentation](https://docs.oracle.com/en/java/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- [JDBC API Reference](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)

---

**Terima kasih telah menggunakan PetShopApp! 🐾**
