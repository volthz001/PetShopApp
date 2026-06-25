-- ============================================================
--  Pet Shop Management System - Database Setup
--  Developer : Hizkia Siallagan
--  NIM       : 231011400154
--  Universitas Pamulang (UNPAM)
--
--  Cara penggunaan:
--  1. Buka phpMyAdmin atau MySQL Workbench
--  2. Import file ini atau jalankan query di bawah
-- ============================================================

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

-- ─── Data contoh ────────────────────────────────────────────
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

-- ─── Konfirmasi ─────────────────────────────────────────────
SELECT 'Setup berhasil!' AS status, COUNT(*) AS total_data FROM produk_hewan;
