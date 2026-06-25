# 🐾 PetShopApp - Pet Shop Management System

**Aplikasi Desktop CRUD untuk Manajemen Inventori Toko Hewan Peliharaan**

Aplikasi sederhana namun lengkap untuk mengelola produk dan hewan di toko hewan peliharaan. Dibangun dengan **Java Swing** sebagai frontend dan **MySQL** sebagai database.

| Informasi | Detail |
|-----------|--------|
| **Developer** | Hizkia Siallagan |
| **NIM** | 231011400154 |
| **Universitas** | Universitas Pamulang (UNPAM) |
| **Status** | ✅ Selesai & Siap Digunakan |

---

## 📋 Daftar Isi

- [Fitur Utama](#-fitur-utama)
- [Tech Stack](#-tech-stack)
- [Persyaratan Sistem](#-persyaratan-sistem)
- [Instalasi](#-instalasi-step-by-step)
- [Konfigurasi Database](#-konfigurasi-database)
- [Cara Menjalankan Aplikasi](#-cara-menjalankan-aplikasi)
- [Panduan Penggunaan](#-panduan-penggunaan)
- [Struktur Project](#-struktur-project)
- [Troubleshooting](#-troubleshooting)
- [Use Case & Scenario](#-use-case--scenario)
- [Kontribusi](#-kontribusi)

---

## ✨ Fitur Utama

✅ **CRUD Lengkap**
- Tambah (Create) produk/hewan baru
- Baca (Read) seluruh data dari database
- Ubah (Update) data produk yang sudah ada
- Hapus (Delete) produk dengan konfirmasi

✅ **User Interface Modern**
- Desain responsive dengan Java Swing
- Color-coded buttons (hijau=tambah, oranye=edit, merah=hapus)
- Tabel data dengan alternating row colors untuk mudah dibaca
- Status bar untuk feedback setiap aksi

✅ **Search & Filter**
- Cari produk berdasarkan: Kode, Nama, atau Jenis
- Real-time search dengan tombol cari

✅ **Validasi Input**
- Validasi field kosong otomatis
- Validasi tipe data (angka untuk stok & harga)
- Deteksi duplicate kode produk
- Format harga dengan separasi ribuan (Rp X,XXX,XXX)

✅ **Keamanan Data**
- Konfirmasi dialog sebelum delete
- Prepared statements untuk mencegah SQL injection
- Try-catch untuk error handling yang proper

✅ **Database Integration**
- Koneksi MySQL dengan test otomatis saat startup
- 10 data sample siap pakai
- Kategori produk yang beragam

---

## 💻 Tech Stack

| Layer | Teknologi | Versi |
|-------|-----------|-------|
| **Frontend** | Java Swing | Built-in JDK |
| **Backend Logic** | Java SE | 1.8+ |
| **Database** | MySQL | 5.7, 8.0+ |
| **JDBC Driver** | mysql-connector-j | 8.0.33 |
| **IDE** | NetBeans | 11.0+ (atau Apache Netbeans) |
| **Build System** | Apache Ant (NetBeans default) | Latest |

### Library Dependencies
```
mysql-connector-j-8.0.33.jar (sudah di-include di folder lib)
```

---

## 🖥️ Persyaratan Sistem

### Minimum Specifications

| Requirement | Spesifikasi |
|-------------|------------|
| **OS** | Windows 7+, Linux (Ubuntu 18.04+), macOS 10.12+ |
| **Processor** | Intel/AMD dual-core @ 2GHz |
| **RAM** | 512 MB (1 GB recommended) |
| **Storage** | 200 MB free space |
| **Java** | JDK 1.8 (Java 8) atau lebih tinggi |
| **MySQL** | Server 5.7 atau 8.0+ |

### Software Prerequisites
```
✓ Java Development Kit (JDK) 1.8 atau lebih tinggi
✓ MySQL Server (5.7 atau 8.0+)
✓ MySQL Connector/J 8.0.33 (sudah included dalam project)
✓ NetBeans IDE (untuk development)
  ATAU Java Runtime Environment (JRE) untuk menjalankan .jar
```

---

## 🚀 Instalasi Step-by-Step

### Step 1️⃣: Install Java Development Kit (JDK)

**Windows:**
```bash
# Download dari https://www.oracle.com/java/technologies/downloads/
# Pilih JDK 8 atau lebih tinggi → installer Windows → double-click & ikuti wizard

# Verify installation
java -version
javac -version
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-8-jdk openjdk-8-jre

# Verify
java -version
javac -version
```

**macOS:**
```bash
brew install openjdk@8

# Verify
java -version
```

---

### Step 2️⃣: Install MySQL Server

**Windows:**
1. Download dari https://dev.mysql.com/downloads/mysql/
2. Jalankan installer (MySQL 8.0 recommended)
3. Ikuti setup wizard → set root password (catat untuk nanti)
4. Pilih "Configure MySQL Server as a Windows Service"

Verifikasi:
```bash
mysql -u root -p
# Masukkan password yang tadi dibuat
# Jika berhasil, prompt akan berubah menjadi mysql>
EXIT;
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install mysql-server

# Jalankan secure installation
sudo mysql_secure_installation

# Test koneksi
mysql -u root -p
EXIT;
```

**macOS:**
```bash
brew install mysql
brew services start mysql

# Setup (opsional)
mysql_secure_installation

# Test
mysql -u root
EXIT;
```

---

### Step 3️⃣: Clone atau Download Project

**Option A - Menggunakan Git:**
```bash
git clone https://github.com/volthz001/PetShopApp.git
cd PetShopApp
```

**Option B - Download ZIP Manual:**
1. Buka https://github.com/volthz001/PetShopApp
2. Klik tombol `Code` → `Download ZIP`
3. Extract ke folder pilihan Anda
4. Buka terminal di folder project

---

### Step 4️⃣: Setup Database MySQL

**Import Database Schema:**

```bash
# Masuk ke MySQL console
mysql -u root -p

# Masukkan password root MySQL Anda
```

Kemudian jalankan SQL berikut di MySQL console:

```sql
-- Buat database
CREATE DATABASE IF NOT EXISTS `db_Petshop_231011400154`
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE `db_Petshop_231011400154`;

-- Buat tabel produk_hewan
CREATE TABLE IF NOT EXISTS `produk_hewan` (
    `kode`  VARCHAR(20)     NOT NULL,
    `nama`  VARCHAR(100)    NOT NULL,
    `jenis` VARCHAR(50)     NOT NULL,
    `stok`  INT             NOT NULL DEFAULT 0,
    `harga` DECIMAL(15, 2)  NOT NULL DEFAULT 0.00,
    PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insert sample data (10 produk)
INSERT INTO `produk_hewan` (`kode`, `nama`, `jenis`, `stok`, `harga`) VALUES
('PT001', 'Kucing Persia',            'Hewan Peliharaan', 5,  2500000.00),
('PT002', 'Anjing Golden Retriever',  'Hewan Peliharaan', 3,  4500000.00),
('PT003', 'Royal Canin Adult Cat 2kg','Makanan Hewan',   20,   185000.00),
('PT004', 'Pedigree Adult Dog 3kg',   'Makanan Hewan',   15,   145000.00),
('PT005', 'Kandang Kucing Premium',   'Kandang & Tempat', 8,   350000.00),
('PT006', 'Vitamin Kucing Nutri Plus', 'Obat & Vitamin', 30,    55000.00),
('PT007', 'Shampo Anjing Anti Jamur', 'Grooming',        25,    45000.00),
('PT008', 'Hamster Syria',            'Hewan Peliharaan',10,   120000.00),
('PT009', 'Aquarium 60cm + Filter',   'Kandang & Tempat', 6,   450000.00),
('PT010', 'Kalung + Tali Anjing',     'Aksesoris',       40,    75000.00);

-- Konfirmasi
SELECT COUNT(*) AS total_produk FROM produk_hewan;

-- Exit
EXIT;
```

**Atau import langsung dari file SQL** (jika menggunakan MySQL Workbench/phpMyAdmin):
1. Buka database tool favorit Anda
2. Pilih `Import` → navigasi ke file `db_Petshop_231011400154.sql`
3. Klik execute/import

---

### Step 5️⃣: Buka Project di NetBeans

1. Buka NetBeans IDE
2. File → Open Project → navigasi ke folder `PetShopApp`
3. Klik "Open Project"
4. IDE akan mendeteksi project sebagai "Ant-based Java Project"

---

### Step 6️⃣: Verifikasi Konfigurasi Database

**Lokasi file:** `PetShopApp/src/petshopapp/DatabaseConnection.java`

Pastikan konfigurasi berikut sesuai dengan setup MySQL Anda:

```java
private static final String HOST     = "localhost";      // ✓ Correct
private static final String PORT     = "3306";           // ✓ Correct (MySQL default)
private static final String DB_NAME  = "db_Petshop_231011400154";  // ✓ Database name
private static final String USERNAME = "root";           // ✓ MySQL username
private static final String PASSWORD = "";               // ⚠️ SESUAIKAN dengan password MySQL Anda!
```

**Jika Anda set password MySQL**, ubah baris:
```java
private static final String PASSWORD = "YOUR_PASSWORD";  // ganti YOUR_PASSWORD
```

---

## 🎯 Cara Menjalankan Aplikasi

### Menggunakan NetBeans IDE ✅ (Recommended)

1. Di NetBeans, buka project `PetShopApp`
2. Klik menu **Run** → **Run Project** (atau tekan `Shift+F6`)
3. Aplikasi akan di-compile dan dijalankan otomatis
4. Jika koneksi database berhasil, aplikasi akan terbuka
5. Lihat status di console untuk verify

### Menggunakan Command Line

```bash
# Navigate ke project directory
cd PetShopApp

# Compile
javac -cp lib/mysql-connector-j-8.0.33.jar -d build/classes src/petshopapp/*.java

# Run
java -cp lib/mysql-connector-j-8.0.33.jar:build/classes petshopapp.MainApp
```

### Menggunakan JAR File (Jika sudah di-export)

```bash
java -jar PetShopApp.jar
```

---

## 📖 Panduan Penggunaan

### 1️⃣ Tampilan Awal Aplikasi

Saat aplikasi dibuka, Anda akan melihat:
- **Panel Kiri**: Form input untuk menambah/edit produk
- **Panel Kanan**: Tabel data produk yang sudah ada (10 data sample)
- **Status Bar Bawah**: Menampilkan status setiap aksi

### 2️⃣ Menambah Produk Baru

```
1. Isi form di panel kiri:
   - Kode Produk    : Masukkan kode unik (contoh: PT011)
   - Nama Produk    : Nama hewan/produk (contoh: "Burung Lovebird")
   - Jenis          : Pilih dari dropdown (7 kategori tersedia)
   - Stok           : Jumlah produk dalam angka
   - Harga (Rp)     : Harga dalam rupiah (angka saja, format otomatis)

2. Klik tombol "➕ Tambah"

3. Sistem akan:
   ✓ Validasi semua field tidak kosong
   ✓ Cek kode tidak sudah terdaftar
   ✓ Insert ke database
   ✓ Refresh tabel otomatis
   ✓ Menampilkan pesan sukses di status bar

4. Form otomatis kosong, siap input berikutnya
```

**Contoh Input:**
| Field | Value |
|-------|-------|
| Kode Produk | PT011 |
| Nama Produk | Burung Lovebird |
| Jenis | Hewan Peliharaan |
| Stok | 4 |
| Harga | 850000 |

### 3️⃣ Mengubah (Update) Produk

```
1. Di tabel sebelah kanan, KLIK pada baris produk yang ingin diubah
   → Form otomatis terisi dengan data produk tersebut
   → Tombol "✏ Update" & "🗑 Hapus" menjadi aktif
   → Kode Produk menjadi read-only (tidak bisa diedit)

2. Ubah field yang diperlukan:
   - BISA mengubah: Nama, Jenis, Stok, Harga
   - TIDAK BISA: Kode (sudah locked)

3. Klik tombol "✏ Update"

4. Dialog konfirmasi muncul, klik "Yes"

5. Data akan ter-update di database dan tabel langsung refresh
   → Status bar menampilkan pesan sukses
```

### 4️⃣ Menghapus Produk

```
1. Klik pada baris produk di tabel
   → Form terisi otomatis
   → Tombol "🗑 Hapus" aktif

2. Klik tombol "🗑 Hapus"

3. Dialog konfirmasi muncul:
   "Hapus produk dengan kode 'PT001'?
    Data tidak dapat dikembalikan!"

4. Klik "Yes" untuk konfirmasi

5. Produk dihapus dari database
   → Tabel ter-refresh
   → Status bar: "Produk dengan kode 'PT001' berhasil dihapus"
```

### 5️⃣ Mencari Produk (Search)

```
1. Di panel kanan, ketik di kolom search
   Contoh: "anjing" atau "PT005" atau "kandang"

2. Klik tombol "🔍 Cari"

3. Tabel akan menampilkan hasil pencarian
   (cari di: Kode, Nama, atau Jenis)

4. Untuk reset ke semua data, klik "↺ Refresh"
```

### 6️⃣ Membersihkan Form

```
1. Klik tombol "🔄 Bersihkan" di panel kiri

2. Semua field dalam form akan kosong

3. Kode Produk kembali editable

4. Tombol "✏ Update" & "🗑 Hapus" menjadi disabled

5. Tombol "➕ Tambah" aktif kembali
```

---

## 📁 Struktur Project

```
PetShopApp/
│
├── src/petshopapp/
│   ├── MainApp.java              ← Entry point aplikasi
│   ├── MainFrame.java            ← UI/GUI (Java Swing)
│   ├── DatabaseConnection.java   ← Koneksi MySQL & config
│   ├── Produk.java               ← Model/Entity class
│   └── ProdukDAO.java            ← Data Access Object (CRUD)
│
├── lib/
│   └── mysql-connector-j-8.0.33.jar  ← MySQL JDBC driver
│
├── nbproject/
│   ├── project.properties        ← NetBeans build config
│   └── project.xml               ← NetBeans project metadata
│
├── build/                        ← Folder output compile (auto-generated)
├── dist/                         ← Folder JAR distribution (jika di-build)
│
├── manifest.mf                   ← Manifest untuk JAR
├── db_Petshop_231011400154.sql   ← Database schema & sample data
├── README.md                     ← Dokumentasi ini
└── LICENSE                       ← Lisensi MIT
```

### Penjelasan File Kunci

| File | Fungsi |
|------|--------|
| `MainApp.java` | Entry point aplikasi - berisi main() method & SwingUtilities |
| `MainFrame.java` | UI utama - form input, tabel, tombol, styling |
| `DatabaseConnection.java` | Manage koneksi MySQL & konfigurasi database |
| `Produk.java` | Model/Entity untuk Produk - getter/setter |
| `ProdukDAO.java` | CRUD operations - tambah, baca, cari, update, hapus ke database |
| `db_Petshop_231011400154.sql` | SQL script untuk setup database & sample data |

---

## 🗄️ Struktur Database

### Tabel: `produk_hewan`

```sql
CREATE TABLE `produk_hewan` (
    `kode`  VARCHAR(20)     PRIMARY KEY,  -- Kode unik produk (PT001, PT002, dst)
    `nama`  VARCHAR(100)    NOT NULL,     -- Nama produk/hewan
    `jenis` VARCHAR(50)     NOT NULL,     -- Kategori/jenis produk
    `stok`  INT             DEFAULT 0,    -- Jumlah stok
    `harga` DECIMAL(15, 2)  DEFAULT 0.00  -- Harga dalam rupiah
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### Kategori/Jenis yang Tersedia

1. **Hewan Peliharaan** - Anjing, kucing, hamster, burung, dll
2. **Makanan Hewan** - Pet food berkualitas
3. **Kandang & Tempat** - Kandang, aquarium, dll
4. **Obat & Vitamin** - Suplemen hewan
5. **Grooming** - Shampo, sikat, dll
6. **Aksesoris** - Kalung, tali, mainan, dll
7. **Lainnya** - Kategori bebas

### Sample Data (10 Produk)

| Kode | Nama | Jenis | Stok | Harga |
|------|------|-------|------|-------|
| PT001 | Kucing Persia | Hewan Peliharaan | 5 | Rp 2,500,000 |
| PT002 | Anjing Golden Retriever | Hewan Peliharaan | 3 | Rp 4,500,000 |
| PT003 | Royal Canin Adult Cat 2kg | Makanan Hewan | 20 | Rp 185,000 |
| PT004 | Pedigree Adult Dog 3kg | Makanan Hewan | 15 | Rp 145,000 |
| PT005 | Kandang Kucing Premium | Kandang & Tempat | 8 | Rp 350,000 |
| PT006 | Vitamin Kucing Nutri Plus | Obat & Vitamin | 30 | Rp 55,000 |
| PT007 | Shampo Anjing Anti Jamur | Grooming | 25 | Rp 45,000 |
| PT008 | Hamster Syria | Hewan Peliharaan | 10 | Rp 120,000 |
| PT009 | Aquarium 60cm + Filter | Kandang & Tempat | 6 | Rp 450,000 |
| PT010 | Kalung + Tali Anjing | Aksesoris | 40 | Rp 75,000 |

---

## 🐛 Troubleshooting

### ❌ Error: "Koneksi database gagal"

**Penyebab & Solusi:**

```
1️⃣ MySQL Server tidak berjalan
   Windows: 
   - Tekan Win+R → ketik "services.msc"
   - Cari "MySQL80" (atau versi Anda)
   - Klik kanan → "Start"
   
   Linux:
   - sudo service mysql start
   - sudo systemctl start mysql
   
   macOS:
   - brew services start mysql

2️⃣ Database belum dibuat
   - Buka MySQL console: mysql -u root -p
   - Jalankan SQL di section "Setup Database MySQL"
   
3️⃣ Username/Password salah di DatabaseConnection.java
   - Edit: src/petshopapp/DatabaseConnection.java
   - Pastikan USERNAME & PASSWORD sesuai MySQL Anda
   - Re-compile dan run

4️⃣ Port MySQL bukan 3306
   - Cek port MySQL: SHOW GLOBAL VARIABLES LIKE 'port';
   - Update di DatabaseConnection.java: private static final String PORT = "3307";
```

---

### ❌ Error: "Driver MySQL tidak ditemukan"

**Penyebab:**
MySQL Connector JAR tidak ada di classpath

**Solusi:**

**Di NetBeans:**
1. Right-click project → Properties
2. Sources → Java Sources Classpath
3. Pastikan ada: `lib/mysql-connector-j-8.0.33.jar`
4. Jika tidak ada, tambahkan file dari folder lib/

**Command line:**
```bash
# Pastikan file ada di folder lib
ls lib/mysql-connector-j-8.0.33.jar

# Jika tidak ada, download dari:
# https://dev.mysql.com/downloads/connector/j/

# Atau copy dari repo yang sudah ada
```

---

### ❌ Error: "Duplicate entry untuk Kode Produk"

**Penyebab:**
Kode produk yang diinput sudah ada di database

**Solusi:**
```
1. Gunakan kode unik yang berbeda
   ✗ PT001 (sudah ada)
   ✓ PT011 (baru - belum ada)

2. Atau delete produk lama terlebih dahulu
   - Klik baris di tabel
   - Klik tombol "🗑 Hapus"
   - Klik "Yes"
   - Barulah input dengan kode yang sama
```

---

### ❌ Tabel kosong saat aplikasi dibuka

**Penyebab:**
- Database belum di-setup dengan data
- Koneksi berhasil tapi tabel kosong

**Solusi:**
```bash
# Login ke MySQL
mysql -u root -p petshop_db_231011400154

# Cek apakah tabel ada
SHOW TABLES;

# Cek apakah ada data
SELECT COUNT(*) FROM produk_hewan;

# Jika kosong, insert sample data:
INSERT INTO `produk_hewan` VALUES 
('PT001', 'Kucing Persia', 'Hewan Peliharaan', 5, 2500000.00),
... (lihat bagian "Setup Database")

# Exit
EXIT;
```

---

### ⚠️ Aplikasi freeze/hang saat load data banyak

**Penyebab:**
Query terlalu lambat atau timeout koneksi

**Solusi:**
```java
// Edit di src/petshopapp/DatabaseConnection.java
// Tambahkan timeout:
private static final String URL =
    "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
    + "?useSSL=false&serverTimezone=Asia/Jakarta&allowPublicKeyRetrieval=true"
    + "&connectTimeout=5000&socketTimeout=5000";  // ← Tambah ini
```

---

### ✅ Verifikasi Setup Berhasil

Pastikan indikator ini muncul:

```
✓ Java version muncul saat: java -version
✓ MySQL connect berhasil: mysql -u root -p
✓ Database ada: SHOW DATABASES; → db_Petshop_231011400154
✓ Tabel ada: USE db_Petshop_231011400154; SHOW TABLES;
✓ Data ada: SELECT COUNT(*) FROM produk_hewan; → 10 rows
✓ Aplikasi buka tanpa error di console
✓ Tabel di UI menampilkan 10 data sample
✓ Status bar: "Menampilkan 10 data produk/hewan"
```

---

## 📋 Use Case & Scenario

### 🛍️ Use Case 1: Admin Kelola Stok Harian

**Scenario:** Pagi hari, admin membuka aplikasi untuk kelola stok

```
Workflow:
1. Buka aplikasi → lihat stok semua hewan (Tabel menampilkan 10 data)

2. Hewan baru tiba dari supplier (Kucing Siamese):
   - Fill form: PT011, "Kucing Siamese", Hewan Peliharaan, Stok: 3, Harga: 3500000
   - Click "➕ Tambah"
   - Tabel update → 11 data

3. Anjing sudah terjual (stok kurang 2):
   - Click PT002 di tabel → form terisi
   - Ubah stok: 3 → 1
   - Click "✏ Update"
   - Tabel update → stok PT002 sekarang 1

4. Hamster mati (tidak bisa dijual):
   - Click PT008 di tabel
   - Click "🗑 Hapus"
   - Confirm → Tabel update → 10 data (Hamster dihapus)

5. Admin selesai, aplikasi ditutup
```

---

### 🔍 Use Case 2: Staff Cari Produk untuk Pelanggan

**Scenario:** Pelanggan bertanya "Ada tidak grooming supplies?"

```
Workflow:
1. Staff ketik "grooming" di search bar
2. Click "🔍 Cari"
3. Tabel menampilkan hasil: PT007 - Shampo Anjing Anti Jamur
4. Staff bisa lihat: ada 25 stok, harga Rp 45,000
5. Staff bilang ke pelanggan: "Ada, tersedia 25 pcs, harganya 45 ribu"
6. Click "↺ Refresh" untuk lihat semua data lagi
```

---

### 💰 Use Case 3: Laporan Pemilik untuk Keuangan

**Scenario:** Pemilik toko ingin tahu total nilai inventori

```
Bisa dihitung manual:
- Lihat kolom "Harga (Rp)"
- Kalikan dengan "Stok"
- Jumlahkan semua

Total Inventori = Σ(Harga × Stok)
Contoh:
- PT001: 2,500,000 × 5 = 12,500,000
- PT002: 4,500,000 × 3 = 13,500,000
- PT003: 185,000 × 20 = 3,700,000
- ...
- Total ≈ Rp 75,000,000+

💡 Feature ini bisa di-develop di v2.0
```

---

### 📦 Use Case 4: Integrasi Kasir (Future)

**Scenario:** Saat transaksi di kasir, sistem update stok otomatis

```
Misal pelanggan beli PT006 (Vitamin) qty 2:
1. Kasir input: kode PT006, qty 2
2. Sistem cek: stok PT006 saat ini 30
3. Proses: stok berkurang 30 → 28
4. Auto-update di database → tabel refresh
5. Kasir lihat stok real-time terbaru

Feature ini belum ada di v1.0
Bisa di-develop di v2.0 dengan POS integration
```

---

## 🔧 Tips & Best Practices

### Development Tips

✅ **Backup Database Rutin**
```bash
# Backup database
mysqldump -u root -p db_Petshop_231011400154 > backup_petshop.sql

# Restore dari backup
mysql -u root -p db_Petshop_231011400154 < backup_petshop.sql
```

✅ **Ubah Password MySQL (Opsional)**
```bash
mysql -u root -p
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password_baru';
FLUSH PRIVILEGES;
EXIT;

# Update di DatabaseConnection.java:
private static final String PASSWORD = "password_baru";
```

✅ **Create User Terpisah (Security)**
```bash
mysql -u root -p
CREATE USER 'petshop_user'@'localhost' IDENTIFIED BY 'petshop_pass';
GRANT ALL PRIVILEGES ON db_Petshop_231011400154.* TO 'petshop_user'@'localhost';
FLUSH PRIVILEGES;
EXIT;

# Update di DatabaseConnection.java:
private static final String USERNAME = "petshop_user";
private static final String PASSWORD = "petshop_pass";
```

---

## 📈 Roadmap v2.0 (Future Features)

- [ ] 📊 Dashboard dengan chart statistik (grafik stok, penjualan)
- [ ] 📥 Export laporan ke PDF/Excel
- [ ] 👤 Multi-user dengan authentication & role (Admin, Staff, Manager)
- [ ] 🧾 Modul Penjualan (POS integration)
- [ ] 📅 History/Log transaksi
- [ ] 🔔 Notifikasi stok minimum
- [ ] 📱 Mobile app (Android/iOS)
- [ ] 🌐 REST API backend (Spring Boot)
- [ ] 🔐 Enkripsi password database
- [ ] 🐳 Docker containerization

---

## 📸 Screenshots

Aplikasi akan menampilkan:
1. **Jendela Utama** dengan split pane (form + tabel)
2. **Form Input** di sebelah kiri dengan 5 field + 4 tombol
3. **Tabel Data** di sebelah kanan dengan 5 kolom (Kode, Nama, Jenis, Stok, Harga)
4. **Status Bar** di bawah menampilkan feedback pesan
5. **Color-coded UI** dengan tema Material Design

---

## 🤝 Kontribusi

Ingin improve aplikasi ini? Silakan:

1. **Fork** repository
2. **Clone** ke local: `git clone https://github.com/volthz001/PetShopApp.git`
3. **Create branch** fitur: `git checkout -b feature/nama-fitur`
4. **Commit** perubahan: `git commit -m "Add: deskripsi fitur"`
5. **Push** ke GitHub: `git push origin feature/nama-fitur`
6. **Open Pull Request** dengan penjelasan

### Saran untuk Kontribusi:
- Fix bugs & improve performa
- Tambah fitur baru (search, filter, export, multi-user)
- Improve UI/UX (dark theme, responsive, icon, dll)
- Dokumentasi lebih lengkap
- Unit tests & automation

---

## 📞 Support & Issues

Ada masalah atau pertanyaan?

📧 **Email:** (contact info)  
🐛 **Report Bug:** https://github.com/volthz001/PetShopApp/issues  
💬 **Discussion:** https://github.com/volthz001/PetShopApp/discussions  

---

## 📄 Lisensi

Project ini dilisensikan di bawah **MIT License**.  
Lihat file [LICENSE](LICENSE) untuk detail lengkap.

```
MIT License

Copyright (c) 2025 Hizkia Siallagan - 231011400154

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and subject to the person furnwhom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

## 🏫 Tentang Project Ini

| Aspek | Detail |
|-------|--------|
| **Tujuan** | Tugas Kuliah - Praktik Java Swing & Database |
| **Universitas** | Universitas Pamulang (UNPAM) |
| **Jurusan** | Teknik Informatika |
| **Semester** | 6 |
| **Developer** | Hizkia Siallagan |
| **NIM** | 231011400154 |
| **Status** | ✅ Selesai & Production Ready |

---

## 📚 Referensi & Resources

- [Oracle Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- [MySQL Official Documentation](https://dev.mysql.com/doc/)
- [JDBC API Reference](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)
- [NetBeans IDE Guide](https://netbeans.apache.org/tutorials/)
- [GitHub README Best Practices](https://github.com/TryGhost/Ghost/blob/master/README.md)

---

**Made with ❤️ by Hizkia Siallagan**  
*Last Updated: June 2025*  
**Version: 1.0.0**

Terima kasih telah menggunakan **PetShopApp**! 🐾

---

*Setiap bug yang ditemukan atau saran fitur sangat diterima. Jangan ragu untuk membuka issue atau PR!* 💪
