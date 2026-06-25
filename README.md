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
- [**🎨 Tampilan Aplikasi (Screenshots)**](#-tampilan-aplikasi-screenshots)
- [**📊 Use Case Diagram & Explanation**](#-use-case-diagram--explanation)
- [**🔄 Workflow & Sequence Diagrams**](#-workflow--sequence-diagrams)
- [**💼 Use Case Details & Scenarios**](#-use-case-details--scenarios)
- [Struktur Project](#-struktur-project)
- [Troubleshooting](#-troubleshooting)
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
| **IDE** | NetBeans | 11.0+ |

---

## 🖥️ Persyaratan Sistem

### Minimum Specifications

| Requirement | Spesifikasi |
|-------------|------------|
| **OS** | Windows 7+, Linux, macOS 10.12+ |
| **Processor** | Intel/AMD dual-core @ 2GHz |
| **RAM** | 512 MB (1 GB recommended) |
| **Storage** | 200 MB free space |
| **Java** | JDK 1.8 atau lebih tinggi |
| **MySQL** | Server 5.7 atau 8.0+ |

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
```

**macOS:**
```bash
brew install openjdk@8
java -version
```

---

### Step 2️⃣: Install MySQL Server

**Windows:**
1. Download dari https://dev.mysql.com/downloads/mysql/
2. Jalankan installer (MySQL 8.0 recommended)
3. Setup wizard → set root password (catat untuk nanti)
4. Pilih "Configure MySQL Server as Windows Service"

**Linux (Ubuntu):**
```bash
sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation
mysql -u root -p
```

**macOS:**
```bash
brew install mysql
brew services start mysql
mysql -u root
```

---

### Step 3️⃣: Clone Project

```bash
git clone https://github.com/volthz001/PetShopApp.git
cd PetShopApp
```

---

### Step 4️⃣: Setup Database MySQL

```bash
mysql -u root -p
```

Kemudian jalankan SQL berikut:

```sql
CREATE DATABASE IF NOT EXISTS `db_Petshop_231011400154`
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE `db_Petshop_231011400154`;

CREATE TABLE IF NOT EXISTS `produk_hewan` (
    `kode`  VARCHAR(20)     NOT NULL,
    `nama`  VARCHAR(100)    NOT NULL,
    `jenis` VARCHAR(50)     NOT NULL,
    `stok`  INT             NOT NULL DEFAULT 0,
    `harga` DECIMAL(15, 2)  NOT NULL DEFAULT 0.00,
    PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

SELECT COUNT(*) AS total_produk FROM produk_hewan;
EXIT;
```

---

### Step 5️⃣: Verifikasi Konfigurasi Database

Edit file: `src/petshopapp/DatabaseConnection.java`

```java
private static final String HOST     = "localhost";
private static final String PORT     = "3306";
private static final String DB_NAME  = "db_Petshop_231011400154";
private static final String USERNAME = "root";
private static final String PASSWORD = "";  // ⚠️ Ubah sesuai password Anda!
```

---

### Step 6️⃣: Jalankan Aplikasi

**Di NetBeans:**
```
Run → Run Project (Shift+F6)
```

**Command Line:**
```bash
javac -cp lib/mysql-connector-j-8.0.33.jar -d build/classes src/petshopapp/*.java
java -cp lib/mysql-connector-j-8.0.33.jar:build/classes petshopapp.MainApp
```

---

## 📖 Panduan Penggunaan

### 1️⃣ Menambah Produk Baru

```
┌─────────────────────────────────────────┐
│  FORM INPUT PRODUK / HEWAN              │
│─────────────────────────────────────────│
│  Kode Produk *       : PT011            │
│  Nama Produk *       : Burung Lovebird  │
│  Jenis *             : Hewan Peliharaan │
│  Stok *              : 4                │
│  Harga (Rp) *        : 850000           │
│─────────────────────────────────────────│
│ [ ➕ Tambah ] [ ✏ Update ] [ 🗑 Hapus ] │
│ [ 🔄 Bersihkan ]                        │
└─────────────────────────────────────────┘

✓ Isi semua field
✓ Klik "➕ Tambah"
✓ Sistem validasi → Insert ke database
✓ Tabel refresh otomatis
✓ Status: "✅ Produk berhasil ditambahkan"
```

---

### 2️⃣ Mengubah (Update) Produk

```
STEP 1: PILIH DATA DI TABEL
┌────────────────────────────────────────┐
│ Kode │ Nama          │ Jenis │ Stok │ Harga
├────────────────────────────────────────┤
│ PT001 │ Kucing Persia │ Hewan │  5  │ Rp 2,5M  ← KLIK BARIS INI
│ PT002 │ Anjing GR     │ Hewan │  3  │ Rp 4,5M
└────────────────────────────────────────┘

STEP 2: FORM OTOMATIS TERISI
┌─────────────────────────────────────────┐
│  FORM INPUT PRODUK / HEWAN              │
│─────────────────────────────────────────│
│  Kode Produk *       : PT001 [LOCKED]   │
│  Nama Produk *       : Kucing Persia    │
│  Jenis *             : Hewan Peliharaan │
│  Stok *              : 5  ← EDIT: 5→6   │
│  Harga (Rp) *        : 2500000          │
│─────────────────────────────────────────│
│ [ ➕ Tambah ] [ ✏ Update ✓ ] [ 🗑 Hapus ✓ ]
└─────────────────────────────────────────┘

STEP 3: KLIK "✏ Update"
  Dialog: "Update data produk 'Kucing Persia'?"
  → Click "Yes"
  → Database updated
  → Tabel refresh
  → Status: "✏ Produk berhasil diupdate: Kucing Persia"
```

---

### 3️⃣ Menghapus Produk

```
STEP 1: PILIH PRODUK DI TABEL
┌────────────────────────────────────────┐
│ Kode │ Nama          │ Jenis │ Stok │ Harga
├────────────────────────────────────────┤
│ PT008 │ Hamster Syria │ Hewan │ 10  │ Rp 120K ← KLIK
└────────────────────────────────────────┘

STEP 2: FORM TERISI + TOMBOL AKTIF
┌─────────────────────────────────────────┐
│  Kode Produk *       : PT008             │
│  Nama Produk *       : Hamster Syria     │
│  Jenis *             : Hewan Peliharaan  │
│  Stok *              : 10                │
│  Harga (Rp) *        : 120000            │
│─────────────────────────────────────────│
│ [ ➕ Tambah ] [ ✏ Update ] [ 🗑 Hapus ✓ ]
└─────────────────────────────────────────┘

STEP 3: KLIK "🗑 Hapus"
  ⚠️ DIALOG KONFIRMASI:
  ┌──────────────────────────────────────┐
  │ ⚠️ Konfirmasi Hapus                   │
  │                                       │
  │ Hapus produk dengan kode 'PT008'?     │
  │ Data tidak dapat dikembalikan!        │
  │                                       │
  │  [ Yes ]  [ No ]                      │
  └──────────────────────────────────────┘

STEP 4: KLIK "Yes"
  → Produk dihapus dari database
  → Tabel refresh (tinggal 9 data)
  → Status: "🗑 Produk 'PT008' berhasil dihapus"
```

---

### 4️⃣ Mencari Produk

```
SEARCH BAR:
┌────────────────────────────────────┐
│ 🔍 Cari kode, nama, atau jenis...  │ ↺ Refresh
└────────────────────────────────────┘

INPUT: "anjing"

HASIL PENCARIAN:
┌────────────────────────────────────┐
│ Kode │ Nama            │ Jenis │...│
├────────────────────────────────────┤
│ PT002 │ Anjing Golden   │ Hewan │...│
│ PT007 │ Shampo Anjing   │ Groom │...│
│ PT010 │ Kalung Anjing   │ Akses │...│
└────────────────────────────────────┘

✓ Sistem mencari di: Kode + Nama + Jenis
✓ Hasil case-insensitive
✓ Klik "↺ Refresh" untuk reset
```

---

## 🎨 Tampilan Aplikasi (Screenshots)

### Screenshot 1: Halaman Utama Aplikasi

```
╔════════════════════════════════════════════════════════════════════════════╗
║  🐾  PET SHOP MANAGEMENT SYSTEM  |  Dev: Hizkia Siallagan  |  231011400154 ║
║─────────────────────────────────────────────────────────────────────────────║
║                         MAIN WINDOW (1000x680)                              ║
║                                                                              ║
║  ┌─────────────────────────────┬──────────────────────────────────────────┐ ║
║  │ FORM INPUT PRODUK / HEWAN   │ TABEL DATA PRODUK                        │ ║
║  │─────────────────────────────┼──────────────────────────────────────────┤ ║
║  │                             │ 🔍 Cari...     [ 🔍 Cari] [ ↺ Refresh]  │ ║
║  │ Kode Produk *   : [        ]│                                          │ ║
║  │ Nama Produk *   : [        ]│ ┌──────────────────────────────────────┐ ║
║  │ Jenis *         : [▼]       │ │ Kode│ Nama         │Jenis│Stok│Harga  │ ║
║  │ Stok *          : [        ]│ ├──────────────────────────────────────┤ ║
║  │ Harga (Rp) *    : [        ]│ │PT001│ Kucing Persia│Hewan│ 5 │ 2.5M  │ ║
║  │                             │ │PT002│ Anjing GR    │Hewan│ 3 │ 4.5M  │ ║
║  │                             │ │PT003│ Royal Canin  │Makan│20 │ 185K  │ ║
║  │ ┌─────────────────────────┐ │ │PT004│ Pedigree     │Makan│15 │ 145K  │ ║
║  │ │ ➕ Tambah │ ✏ Update  │ │ │PT005│ Kandang      │Kand │ 8 │ 350K  │ ║
║  │ │ 🗑 Hapus  │🔄 Bersih  │ │ │PT006│ Vitamin      │Obat │30 │  55K  │ ║
║  │ └─────────────────────────┘ │ │PT007│ Shampo       │Groom│25 │  45K  │ ║
║  │                             │ │PT008│ Hamster      │Hewan│10 │ 120K  │ ║
║  │                             │ │PT009│ Aquarium     │Kand │ 6 │ 450K  │ ║
║  │                             │ │PT010│ Kalung       │Akses│40 │  75K  │ ║
║  │                             │ └──────────────────────────────────────┘ ║
║  └─────────────────────────────┴──────────────────────────────────────────┘ ║
║─────────────────────────────────────────────────────────────────────────────║
║ ✅ Menampilkan 10 data produk/hewan.                                         ║
╚════════════════════════════════════════════════════════════════════════════╝

LEGENDA WARNA:
  🟢 Tombol Tambah   (Hijau - CLR_SUCCESS)
  🟠 Tombol Update   (Oranye - CLR_ACCENT)
  🔴 Tombol Hapus    (Merah - CLR_DANGER)
  🔵 Tombol Search   (Biru - CLR_PRIMARY)
```

---

### Screenshot 2: Proses Edit Data

```
╔════════════════════════════════════════════════════════════════════════════╗
║  SEBELUM KLIK BARIS:                                                       ║
║  ┌─────────────────────────────┐                                           ║
║  │ FORM INPUT (KOSONG)         │                                           ║
║  │─────────────────────────────│                                           ║
║  │ Kode Produk *   : [        ]│ ← Editable                               ║
║  │ Nama Produk *   : [        ]│                                           ║
║  │ Jenis *         : [▼]       │                                           ║
║  │ Stok *          : [        ]│                                           ║
║  │ Harga (Rp) *    : [        ]│                                           ║
║  │                             │                                           ║
║  │ ┌─────────────────────────┐ │                                           ║
║  │ │ ➕ Tambah [✓] │ ✏ Update│ │ ← Update DISABLED                        ║
║  │ │ 🗑 Hapus     │🔄 Bersih│ │ ← Delete DISABLED                        ║
║  │ └─────────────────────────┘ │                                           ║
║  └─────────────────────────────┘                                           ║
║  Status: ✅ Form dibersihkan.                                               ║
║─────────────────────────────────────────────────────────────────────────────║
║  SETELAH KLIK PT002 (Anjing Golden Retriever):                              ║
║  ┌─────────────────────────────┐                                           ║
║  │ FORM INPUT (TERISI)         │                                           ║
║  │─────────────────────────────│                                           ║
║  │ Kode Produk *   : PT002 [X] │ ← Read-only (tidak bisa diedit)          ║
║  │ Nama Produk *   : Anjing Golden Retriever                               │ ║
║  │ Jenis *         : [Hewan Peliharaan ▼]                                  │ ║
║  │ Stok *          : [3        ] ← BISA DIUBAH                             │ ║
║  │ Harga (Rp) *    : [4500000  ] ← BISA DIUBAH                             │ ║
║  │                             │                                           ║
║  │ ┌─────────────────────────┐ │                                           ║
║  │ │ ➕ Tambah [X] │ ✏ Update│ │ ← Update ENABLED ✓                       ║
║  │ │ 🗑 Hapus  [✓] │🔄 Bersih│ │ ← Delete ENABLED ✓                       ║
║  │ └─────────────────────────┘ │                                           ║
║  └─────────────────────────────┘                                           ║
║  Status: ✏ Mengedit: Anjing Golden Retriever                               ║
╚════════════════════════════════════════════════════════════════════════════╝
```

---

### Screenshot 3: Dialog Konfirmasi

```
┌──────────────────────────────────────────┐
│ ⚠️  KONFIRMASI OPERASI                    │
├──────────────────────────────────────────┤
│                                           │
│  Update data produk 'Anjing Golden       │
│  Retriever'?                              │
│                                           │
│          [ ✓ Yes ]   [ ✗ No ]            │
│                                           │
└──────────────────────────────────────────┘

ATAU untuk Delete:

┌──────────────────────────────────────────┐
│ ⚠️  KONFIRMASI HAPUS                      │
├──────────────────────────────────────────┤
│                                           │
│  Hapus produk dengan kode 'PT002'?        │
│  Data tidak dapat dikembalikan!           │
│                                           │
│          [ ✓ Yes ]   [ ✗ No ]            │
│                                           │
└──────────────────────────────────────────┘
```

---

### Screenshot 4: Status Bar Messages

```
Status Bar berada di BAWAH aplikasi dan menampilkan pesan:

Keadaan                              Pesan Status                    Warna
─────────────────────────────────────────────────────────────────────────
Aplikasi buka                        ✅ Menampilkan 10 data...       BLUE
Form dibersihkan                     ✅ Form dibersihkan             BLUE
Pilih item di tabel                  ✏ Mengedit: [nama produk]       ORANGE
Tambah berhasil                      ✅ Produk berhasil ditambahkan  GREEN
Update berhasil                      ✏ Produk berhasil diupdate      ORANGE
Delete berhasil                      🗑 Produk berhasil dihapus      RED
Form kosong saat input               ⚠ Kode tidak boleh kosong      RED
Koneksi database gagal               ⚠ Gagal konek database         RED
Search hasil                         📋 Menampilkan X data produk   BLUE
```

---

## 📊 Use Case Diagram & Explanation

### 🎯 Use Case Model

```
                    ┌─────────────┐
                    │   SISTEM    │
                    │  PETSHOP    │
                    └─────────────┘
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
        ▼                  ▼                  ▼
    ┌─────────┐      ┌──────────┐       ┌──────────┐
    │ ADMIN   │      │ DATABASE │       │  SISTEM  │
    │         │      │  MySQL   │       │  UI      │
    └─────────┘      └──────────┘       └──────────┘
        │                  │                  │
        ├──────────────────┴──────────────────┤
        │                                      │
        └──────────────────┬───────────────────┘
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
        ▼                  ▼                  ▼
    ┌─────────┐      ┌─────────┐      ┌─────────────┐
    │  TAMBAH │      │ BACA    │      │   CARI      │
    │ PRODUK  │      │ PRODUK  │      │  / FILTER   │
    └─────────┘      └─────────┘      └─────────────┘
        │                  │                  │
        ├──────────────────┼──────────────────┤
        │                  │                  │
        ▼                  ▼                  ▼
    ┌─────────┐      ┌─────────┐      ┌─────────────┐
    │  UBAH   │      │ HAPUS   │      │  VALIDASI   │
    │ PRODUK  │      │ PRODUK  │      │   INPUT     │
    └─────────┘      └─────────┘      └─────────────┘
        │                  │
        └──────────────────┴────────────────┐
                           │                 │
                           ▼                 ▼
                      ┌──────────┐    ┌─────────────┐
                      │KONFIRMASI│    │ SIMPAN DB   │
                      │ DIALOG   │    │ / UPDATE    │
                      └──────────┘    └─────────────┘

AKTOR: Admin/User Toko
SISTEM: PetShopApp (Java Swing + MySQL)
INTERAKSI: Form input → Validasi → Database → Tabel refresh
```

---

### 📋 Use Case Specifications

| # | Use Case | Aktor | Deskripsi | Precondition | Postcondition |
|---|----------|-------|-----------|--------------|---------------|
| **UC-01** | **Tambah Produk** | Admin | Menambah produk/hewan baru ke database | Database connected, form kosong | Data tersimpan, tabel refresh |
| **UC-02** | **Lihat Semua Produk** | Admin | Menampilkan semua data produk di tabel | App buka | Tabel show 10 data |
| **UC-03** | **Cari Produk** | Admin | Mencari produk by kode/nama/jenis | Tabel berisi data | Hasil filter ditampilkan |
| **UC-04** | **Edit Produk** | Admin | Mengubah data produk existing | Produk dipilih dari tabel | Data terupdate di DB |
| **UC-05** | **Hapus Produk** | Admin | Menghapus produk dari database | Produk dipilih, konfirmasi yes | Produk dihapus, tabel refresh |
| **UC-06** | **Validasi Input** | System | Cek field tidak kosong & tipe data benar | User input data | Pesan error jika invalid |

---

## 🔄 Workflow & Sequence Diagrams

### 1️⃣ CRUD Workflow (Siklus Lengkap)

```
START
  │
  ├─→ [1] APLIKASI DIBUKA
  │        └─→ MainApp.java → DatabaseConnection.testConnection()
  │           └─→ ✓ Koneksi berhasil? → MainFrame ditampilkan
  │           └─→ ✗ Koneksi gagal?    → Dialog error, tapi frame tetap buka
  │
  ├─→ [2] MENAMPILKAN DATA (READ ALL)
  │        └─→ ProdukDAO.getAll() → Query: SELECT * FROM produk_hewan
  │           └─→ ResultSet → Loop create Produk objects
  │           └─→ Tabel refresh dengan 10 data
  │
  ├─→ [3] USER MEMILIH AKSI
  │        ├─→ [A] TAMBAH PRODUK
  │        │        └─→ Fill form → Validasi form
  │        │           ├─→ ✓ Valid?     → ProdukDAO.tambah()
  │        │           │                → INSERT query
  │        │           │                → Tabel refresh
  │        │           └─→ ✗ Invalid?   → Warning dialog
  │        │
  │        ├─→ [B] KLIK PRODUK DI TABEL (untuk Edit/Delete)
  │        │        └─→ isiFormDariTabel()
  │        │           └─→ Form otomatis terisi
  │        │           └─→ Tombol Update & Delete enabled
  │        │
  │        ├─→ [C] UPDATE PRODUK
  │        │        └─→ Edit form fields
  │        │           └─→ Klik "✏ Update"
  │        │           └─→ Konfirmasi dialog muncul
  │        │           └─→ Click "Yes" → ProdukDAO.update()
  │        │           └─→ UPDATE query
  │        │           └─→ Tabel refresh
  │        │
  │        ├─→ [D] DELETE PRODUK
  │        │        └─→ Klik "🗑 Hapus"
  │        │           └─→ Konfirmasi dialog muncul
  │        │           └─→ Click "Yes" → ProdukDAO.hapus()
  │        │           └─→ DELETE query
  │        │           └─→ Tabel refresh
  │        │
  │        └─→ [E] SEARCH PRODUK
  │                 └─→ Ketik di search field
  │                    └─→ Klik "🔍 Cari"
  │                    └─→ ProdukDAO.search(keyword)
  │                    └─→ Tabel filter hasil
  │                    └─→ Klik "↺ Refresh" untuk reset
  │
  └─→ [4] LOOP kembali ke step [3] atau KELUAR aplikasi
       └─→ Semua data tersimpan di database
```

---

### 2️⃣ Sequence Diagram - Tambah Produk

```
User              MainFrame            Validasi           ProdukDAO          Database
  │                  │                    │                  │                   │
  │  1. Fill Form    │                    │                  │                   │
  ├─────────────────>│                    │                  │                   │
  │                  │                    │                  │                   │
  │  2. Click Tambah │                    │                  │                   │
  ├─────────────────>│                    │                  │                   │
  │                  │  3. Validasi Form  │                  │                   │
  │                  ├───────────────────>│                  │                   │
  │                  │  (check kosong, type)                 │                   │
  │                  │<───────────────────┤                  │                   │
  │                  │  4. Form valid     │                  │                   │
  │                  │                    │                  │                   │
  │                  │  5. Call tambah()  │                  │                   │
  │                  ├─────────────────────────────────────>│                   │
  │                  │                    │                  │  6. INSERT query   │
  │                  │                    │                  ├──────────────────>│
  │                  │                    │                  │                   │
  │                  │                    │                  │  7. Insert OK ✓    │
  │                  │                    │                  │<──────────────────┤
  │                  │                    │                  │                   │
  │                  │  8. Refresh table  │                  │                   │
  │                  ├────────────────────────────────────────────────────────>│
  │                  │                    │                  │  9. SELECT all    │
  │                  │                    │                  │<──────────────────┤
  │                  │                    │                  │                   │
  │  10. Display msg │                    │                  │                   │
  │<─────────────────┤                    │                  │                   │
  │  "✅ Berhasil"   │                    │                  │                   │
  │
```

---

### 3️⃣ Sequence Diagram - Delete Produk

```
User              MainFrame         Dialog             ProdukDAO         Database
  │                  │                │                  │                 │
  │  1. Click Delete │                │                  │                 │
  ├─────────────────>│                │                  │                 │
  │                  │                │                  │                 │
  │                  │  2. Show Dialog│                  │                 │
  │                  ├───────────────>│                  │                 │
  │  3. Confirm?     │<───────────────┤                  │                 │
  │  [Yes] [No]      │                │                  │                 │
  │                  │                │                  │                 │
  │  4. Click "Yes"  │                │                  │                 │
  ├─────────────────>│                │                  │                 │
  │                  │  5. Call hapus()                  │                 │
  │                  ├─────────────────────────────────>│                 │
  │                  │                │                  │                 │
  │                  │                │  6. DELETE query │                 │
  │                  │                │                  ├────────────────>│
  │                  │                │                  │                 │
  │                  │                │                  │  7. Delete OK ✓ │
  │                  │                │                  │<────────────────┤
  │                  │                │                  │                 │
  │                  │  8. Refresh table (Tabel update) │                 │
  │                  ├─────────────────────────────────────────────────>│
  │                  │                │                  │  9. SELECT all  │
  │                  │                │                  │<────────────────┤
  │                  │                │                  │                 │
  │  10. Status msg  │                │                  │                 │
  │<─────────────────┤                │                  │                 │
  │  "🗑 Dihapus"   │                │                  │                 │
  │
```

---

## 💼 Use Case Details & Scenarios

### 🎯 Use Case 1: Admin Kelola Stok Harian

**Nama:** Tambah, Lihat, Edit, Hapus Produk  
**Aktor:** Admin/Pemilik Toko  
**Tujuan:** Mengelola inventori stok hewan & produk setiap hari

#### Scenario A: Saat Pagi (Buka Aplikasi)

```
WAKTU: 07:00 - Pagi hari

1. Admin datang ke toko
   └─→ Buka aplikasi PetShopApp
   
2. Aplikasi startup
   ┌─────────────────────────────────────┐
   │ 🐾 PET SHOP MANAGEMENT SYSTEM       │
   │─────────────────────────────────────│
   │ [Connecting to database...]         │
   │ [Loading data...]                   │
   │ [Success! Connected to MySQL]       │
   └─────────────────────────────────────┘
   
3. Main window terbuka
   └─→ Tabel menampilkan 10 produk yang sudah ada
   └─→ Status: "✅ Menampilkan 10 data produk/hewan"
   
4. Admin lihat stok pagi ini
   ├─→ Kucing Persia: 5 ekor (normal ✓)
   ├─→ Anjing GR: 3 ekor (normal ✓)
   ├─→ Hamster: 10 ekor (normal ✓)
   └─→ Stok semua masih aman
```

#### Scenario B: Hewan Baru Tiba dari Supplier

```
WAKTU: 09:00 - Supplier datang

SITUASI: Supplier kirim 4 ekor burung lovebird (belum ada di sistem)

LANGKAH:
1. Admin fill form:
   ┌────────────────────────────────────┐
   │ Kode Produk *    : PT011           │
   │ Nama Produk *    : Burung Lovebird │
   │ Jenis *          : Hewan Peliharaan│
   │ Stok *           : 4               │
   │ Harga (Rp) *     : 850000          │
   └────────────────────────────────────┘

2. Admin click "➕ Tambah"

3. Sistem process:
   ✓ Validasi: semua field terisi
   ✓ Cek duplicate: kode PT011 belum ada
   ✓ Insert: INSERT INTO produk_hewan (PT011, Lovebird, ...)
   ✓ Database: data tersimpan
   ✓ Refresh tabel: 11 data sekarang

4. Result:
   ┌─────────────────────────────────────────┐
   │ Kode │ Nama           │ Jenis │Stok│   │
   ├─────────────────────────────────────────┤
   │ ...                                     │
   │ PT011│ Burung Love..  │Hewan │ 4 │850K│ ← NEW ENTRY
   │ ...                                     │
   └─────────────────────────────────────────┘
   
   Status: "✅ Produk berhasil ditambahkan: Burung Lovebird"
```

#### Scenario C: Anjing Terjual (Update Stok)

```
WAKTU: 11:30 - Customer beli Anjing

SITUASI: Ada yang beli 1 Anjing Golden Retriever (stok 3 → 2)

LANGKAH:
1. Admin click baris PT002 (Anjing GR) di tabel
   
2. Form otomatis terisi:
   ┌────────────────────────────────────────────┐
   │ Kode Produk *    : PT002 [LOCKED - read]  │
   │ Nama Produk *    : Anjing Golden Retriever│
   │ Jenis *          : Hewan Peliharaan       │
   │ Stok *           : 3                      │
   │ Harga (Rp) *     : 4500000                │
   └────────────────────────────────────────────┘
   
   Tombol Update & Delete aktif ✓

3. Admin ubah stok:
   Stok: 3 → 2 (kurang 1 karena terjual)

4. Admin click "✏ Update"

5. Dialog konfirmasi:
   ┌──────────────────────────────────┐
   │ Update data 'Anjing GR'?          │
   │  [ ✓ Yes ]     [ ✗ No ]          │
   └──────────────────────────────────┘

6. Admin click "Yes"

7. Database UPDATE:
   UPDATE produk_hewan SET stok=2 WHERE kode='PT002'

8. Tabel refresh:
   │ PT002│ Anjing Golden..│Hewan│ 2 │4.5M│ ← STOK BERUBAH
   
   Status: "✏ Produk berhasil diupdate: Anjing Golden Retriever"
```

#### Scenario D: Hamster Tidak Laku (Delete Produk)

```
WAKTU: 14:00 - Owner review produk

SITUASI: Hamster Syria jarang diminati, owner ingin hapus dari sistem

LANGKAH:
1. Admin klik baris PT008 (Hamster Syria) di tabel

2. Form terisi:
   ┌────────────────────────────────────────┐
   │ Kode Produk *    : PT008               │
   │ Nama Produk *    : Hamster Syria       │
   │ Jenis *          : Hewan Peliharaan    │
   │ Stok *           : 10                  │
   │ Harga (Rp) *     : 120000              │
   └────────────────────────────────────────┘
   
   Tombol Delete aktif ✓

3. Admin click "🗑 Hapus"

4. Dialog konfirmasi BAHAYA:
   ┌─────────────────────────────────────┐
   │ ⚠️  KONFIRMASI HAPUS                  │
   │─────────────────────────────────────│
   │                                      │
   │ Hapus produk dengan kode 'PT008'?    │
   │ Data tidak dapat dikembalikan!       │
   │                                      │
   │  [ ✓ Yes ]     [ ✗ No ]             │
   │                                      │
   └─────────────────────────────────────┘

5. Admin berpikir... lalu click "Yes" (confirm)

6. Database DELETE:
   DELETE FROM produk_hewan WHERE kode='PT008'

7. Tabel refresh: tinggal 10 data
   (Hamster hilang dari list)

8. Status: "🗑 Produk 'PT008' berhasil dihapus"
```

#### Scenario E: Akhir Hari (Backup Data)

```
WAKTU: 17:00 - Tutup toko

AKTIVITAS:
├─→ Admin review stok akhir hari (tabel menampilkan)
├─→ Pastikan semua data terupdate
├─→ Tutup aplikasi (data otomatis saved di DB)
└─→ MySQL background service tetap running

NEXT DAY: Data masih ada, ready untuk hari berikutnya ✓
```

---

### 🔍 Use Case 2: Staff Cari Produk untuk Pelanggan

**Nama:** Search/Filter Produk  
**Aktor:** Staff Toko  
**Tujuan:** Menjawab pertanyaan customer tentang ketersediaan produk

#### Scenario: Customer Tanya "Ada Grooming Supplies?"

```
SITUASI:
Customer: "Excuse me, ada grooming supplies untuk anjing tidak?"
Staff: "Tunggu sebentar, saya cek sistemnya"

LANGKAH:
1. Staff di aplikasi, lihat tabel penuh (10 data)

2. Staff ketik di search field:
   ┌────────────────────────────────────┐
   │ 🔍 grooming                        │ [ 🔍 Cari ] [ ↺ Refresh ]
   └────────────────────────────────────┘

3. Staff click "🔍 Cari"

4. Sistem search:
   SELECT * FROM produk_hewan 
   WHERE kode LIKE '%grooming%' 
      OR nama LIKE '%grooming%' 
      OR jenis LIKE '%grooming%'

5. HASIL (Filter tabel):
   ┌──────────────────────────────────┐
   │ Kode │Nama           │Jenis │Stok│
   ├──────────────────────────────────┤
   │PT007 │ Shampo Anjing │Groom │25  │
   │      │Anti Jamur     │      │    │
   └──────────────────────────────────┘

6. Staff baca hasil:
   - Ada 1 item: Shampo Anjing Anti Jamur
   - Kategori: Grooming
   - Stok: 25 pcs
   - Harga: Rp 45,000

7. Staff jawab customer:
   "Ada, kami punya Shampo Anjing Anti Jamur, tersedia 25 kemasan,
    harganya Rp 45 ribu per botol. Cocok untuk grooming anjing Anda!"

8. Customer: "Oh iya, bagus. Saya ambil 1 botol ya"

9. Staff click "↺ Refresh" untuk kembali lihat semua data
   Tabel kembali menampilkan 10 produk
   
   Status: "📋 Menampilkan 10 data produk/hewan"
```

---

### 💰 Use Case 3: Owner Hitung Nilai Inventori

**Nama:** Calculate Inventory Value  
**Aktor:** Pemilik Toko  
**Tujuan:** Mengetahui total nilai aset inventory untuk laporan keuangan

#### Scenario: Weekly Inventory Valuation

```
WAKTU: Jumat sore, sebelum tutup minggu

SITUASI: Owner perlu tahu total nilai inventory untuk laporan

LANGKAH:
1. Owner buka aplikasi → lihat tabel dengan harga

2. Manual calculation (dari tabel):
   ┌────────────────────────────────────────────────────┐
   │ Kode │Nama           │Harga   │Stok│ Nilai Stok  │
   ├────────────────────────────────────────────────────┤
   │PT001 │Kucing Persia  │2.5M    │5   │ 12,500,000  │
   │PT002 │Anjing GR      │4.5M    │3   │ 13,500,000  │
   │PT003 │Royal Canin    │185K    │20  │  3,700,000  │
   │PT004 │Pedigree       │145K    │15  │  2,175,000  │
   │PT005 │Kandang Premium│350K    │8   │  2,800,000  │
   │PT006 │Vitamin        │55K     │30  │  1,650,000  │
   │PT007 │Shampo         │45K     │25  │  1,125,000  │
   │PT008 │Hamster        │120K    │10  │  1,200,000  │
   │PT009 │Aquarium       │450K    │6   │  2,700,000  │
   │PT010 │Kalung         │75K     │40  │  3,000,000  │
   ├────────────────────────────────────────────────────┤
   │                            TOTAL │  44,350,000  │
   └────────────────────────────────────────────────────┘

3. Owner catat:
   "Total nilai inventory hari ini: Rp 44,350,000"

4. Owner input ke accounting system atau report

5. Note untuk future (v2.0):
   💡 Bisa otomatis calculate dengan feature "Generate Report"
      yang menampilkan summary inventory value per kategori
```

---

### 📦 Use Case 4: Integrasi dengan POS (Future Feature)

**Nama:** Automatic Stock Update saat Transaksi  
**Aktor:** Cashier (kasir)  
**Status:** ❌ Not yet implemented (v2.0 feature)

#### Scenario (Desired Future Flow)

```
SKENARIO (NANTI DI v2.0):
Ketika cashier proses penjualan di POS system:

1. Cashier scan/input: PT006 (Vitamin Kucing), qty 3

2. POS system call PetShopApp API:
   PATCH /api/products/PT006/stock?qty=3

3. PetShopApp update database:
   UPDATE produk_hewan SET stok = stok - 3 WHERE kode='PT006'
   (30 → 27)

4. PetShopApp response:
   {
     "status": "success",
     "kode": "PT006",
     "nama": "Vitamin Kucing Nutri Plus",
     "stok_lama": 30,
     "stok_baru": 27
   }

5. POS menampilkan:
   ✓ Item: Vitamin Kucing
   ✓ Qty: 3
   ✓ Price: Rp 55,000 × 3 = Rp 165,000
   ✓ Stock update: 30 → 27

6. Jika PetShopApp real-time:
   - Admin di toko lihat tabel update otomatis
   - Stok Vitamin Kucing langsung berubah jadi 27
   - Real-time inventory sync ✓

MANFAAT:
✓ Stock selalu akurat
✓ Tidak perlu manual update
✓ Prevent over-selling
✓ Automated reporting
```

---

## 📁 Struktur Project

```
PetShopApp/
│
├── src/petshopapp/
│   ├── MainApp.java              ← Entry point (main method)
│   ├── MainFrame.java            ← UI/GUI (Java Swing, 443 lines)
│   ├── DatabaseConnection.java   ← MySQL config & connection
│   ├── Produk.java               ← Model/Entity (kode, nama, jenis, stok, harga)
│   └── ProdukDAO.java            ← CRUD operations (156 lines)
│
├── lib/
│   └── mysql-connector-j-8.0.33.jar  ← JDBC driver
│
├── nbproject/
│   ├── project.properties        ← NetBeans build config
│   └── project.xml               ← NetBeans project metadata
│
├── build/                        ← Compiled output folder
├── dist/                         ← JAR distribution folder
│
├── manifest.mf                   ← Manifest untuk JAR
├── db_Petshop_231011400154.sql   ← Database schema & sample data
├── README.md                     ← Documentation (ini)
└── LICENSE                       ← MIT License
```

---

## 🗄️ Struktur Database dengan Use Case Mapping

```sql
TABLE: produk_hewan
┌─────────┬──────────┬────────┬──────┬────────┐
│ Kode    │ Nama     │ Jenis  │ Stok │ Harga  │ ← Columns
├─────────┼──────────┼────────┼──────┼────────┤
│ PT001   │ Kucing   │ Hewan  │ 5    │ 2.5M   │ ← Row 1
│ PT002   │ Anjing   │ Hewan  │ 3    │ 4.5M   │ ← Row 2 (Update UC)
│ PT003   │ Makan    │ Makan  │ 20   │ 185K   │ ← Row 3
│ ...     │ ...      │ ...    │ ...  │ ...    │
│ PT011   │ Lovebird │ Hewan  │ 4    │ 850K   │ ← Row 11 (Create UC)
└─────────┴──────────┴────────┴──────┴────────┘

USE CASE MAPPING:
├─ UC-01 (Tambah): INSERT row baru (PT011)
├─ UC-02 (Baca):   SELECT * FROM produk_hewan
├─ UC-03 (Cari):   SELECT * WHERE kode/nama/jenis LIKE '%keyword%'
├─ UC-04 (Edit):   UPDATE stok/harga WHERE kode='PT002'
└─ UC-05 (Hapus):  DELETE WHERE kode='PT008'
```

---

## 🐛 Troubleshooting & Solutions

### ❌ Error: "Koneksi database gagal"

```
SOLUSI STEP-BY-STEP:

1. Cek MySQL Server berjalan:
   Windows: Start → Services → MySQL80 (status: Running)
   Linux:   sudo systemctl status mysql
   macOS:   brew services list | grep mysql

2. Cek database ada:
   mysql -u root -p
   SHOW DATABASES;
   (Lihat: db_Petshop_231011400154 ?)

3. Cek credentials di kode:
   Edit: src/petshopapp/DatabaseConnection.java
   - HOST: localhost ✓
   - PORT: 3306 ✓
   - DB_NAME: db_Petshop_231011400154 ✓
   - USERNAME: root ✓
   - PASSWORD: (sesuai MySQL Anda) ✓

4. Recompile & test connection:
   mvn clean compile
   java -cp ... petshopapp.MainApp
```

---

### ❌ Error: "Duplicate entry untuk Kode 'PT001'"

```
PENYEBAB: Kode produk sudah ada di database

SOLUSI:
├─ Gunakan kode unik baru (PT011, PT012, dst)
└─ Atau hapus produk lama dulu sebelum insert ulang
```

---

### ⚠️ Tabel kosong saat app buka

```
SOLUSI:
1. Verify database berisi data:
   mysql -u root -p db_Petshop_231011400154
   SELECT COUNT(*) FROM produk_hewan;
   (Hasil: 10 rows ?)

2. Jika 0 rows, insert sample data:
   (Copy dari db_Petshop_231011400154.sql)

3. Check query di ProdukDAO.getAll():
   Confirm: SELECT * FROM produk_hewan ORDER BY kode;
```

---

## 📞 Support & Contribution

**Issues & Bugs:**
- Open issue di: https://github.com/volthz001/PetShopApp/issues

**Saran Fitur v2.0:**
- Dashboard analytics
- Export to PDF/Excel
- Multi-user authentication
- POS integration
- Mobile app

**Pull Request Welcome!** 🎉

---

## 📄 Lisensi

**MIT License** - Bebas digunakan untuk keperluan komersial & non-komersial

---

## 👨‍💻 Developer Info

| Aspek | Detail |
|-------|--------|
| **Name** | Hizkia Siallagan |
| **NIM** | 231011400154 |
| **University** | Universitas Pamulang (UNPAM) |
| **Program** | Teknik Informatika, Semester 6 |
| **Project Status** | ✅ Complete & Production Ready |
| **Version** | 1.0.0 |
| **Last Updated** | June 2025 |

---

**Terima kasih telah menggunakan PetShopApp! 🐾**

*Setiap feedback dan kontribusi sangat diterima. Jangan ragu untuk membuka issue atau PR!* 💪

---

## 📚 Learning References

- [Oracle Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [JDBC API Guide](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)
- [Design Patterns - DAO](https://www.baeldung.com/java-dao-pattern)
- [Use Case Modeling](https://en.wikipedia.org/wiki/Use_case)

---

**Hizkia Siallagan - UNPAM 2025**
