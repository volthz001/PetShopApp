# 🖼️ Images — PetShopApp

Folder ini berisi seluruh **screenshot tampilan aplikasi** dan **diagram use case** PetShopApp, yang digunakan sebagai referensi visual pada `README.md` utama maupun Laporan Tugas Akhir (BAB IV — Implementasi & Pengujian).

---

## 📁 Daftar File

| No | Nama File | Keterangan |
|----|-----------|------------|
| 1 | `01-tampilan-utama.png` | Tampilan utama aplikasi: form input kosong + tabel berisi 9 data produk/hewan |
| 2 | `02-pilih-data-edit.png` | Data `PT009` dipilih dari tabel, form otomatis terisi, tombol **Update** & **Hapus** aktif (siap untuk fitur edit) |
| 3 | `03-konfirmasi-hapus.png` | Dialog konfirmasi sebelum menghapus data `PT009`, mencegah penghapusan tidak sengaja |
| 4 | `04-setelah-hapus.png` | Data `PT009` berhasil dihapus — tabel kembali menjadi 8 baris, status bar menampilkan pesan sukses |
| 5 | `05-setelah-tambah.png` | Data baru `PT009 - Anjing BullDog` berhasil ditambahkan kembali — tabel menjadi 9 baris |
| 6 | `06-use-case-diagram.png` | Use case diagram lengkap PetShopApp (aktor, 6 use case utama, 2 use case `<<include>>`, dan database MySQL) |

---

## 🔗 Cara Menyisipkan ke README Utama

Tambahkan blok berikut pada bagian **"Tampilan Aplikasi"** di `README.md` utama:

```markdown
## 🖥️ Tampilan Aplikasi

### Tampilan Utama
![Tampilan Utama](images/01-tampilan-utama.png)

### Memilih & Mengedit Data
![Pilih Data untuk Edit](images/02-pilih-data-edit.png)

### Konfirmasi Hapus Data
![Konfirmasi Hapus](images/03-konfirmasi-hapus.png)

### Data Berhasil Dihapus
![Setelah Hapus](images/04-setelah-hapus.png)

### Data Berhasil Ditambahkan
![Setelah Tambah](images/05-setelah-tambah.png)

## 📋 Use Case Diagram
![Use Case Diagram](images/06-use-case-diagram.png)
```

---

## 📝 Catatan untuk Laporan TA

Gambar-gambar ini bisa langsung dipakai pada **BAB IV.3 Tampilan Aplikasi**, dengan format penomoran:

| Gambar | Sumber File | Keterangan di Laporan |
|--------|-------------|------------------------|
| Gambar 4.1 | `01-tampilan-utama.png` | Tampilan antarmuka utama aplikasi |
| Gambar 4.2 | `02-pilih-data-edit.png` | Proses memilih data untuk diubah |
| Gambar 4.3 | `03-konfirmasi-hapus.png` | Dialog konfirmasi penghapusan data |
| Gambar 4.4 | `04-setelah-hapus.png` | Hasil setelah data dihapus |
| Gambar 4.5 | `05-setelah-tambah.png` | Hasil setelah data baru ditambahkan |
| Gambar 3.1 (BAB III) | `06-use-case-diagram.png` | Use case diagram sistem |

---

## ➕ Menambahkan Screenshot Baru

1. Ambil screenshot aplikasi (gunakan `Win + Shift + S` atau Snipping Tool).
2. Simpan dengan format penamaan: `NN-deskripsi-singkat.png` (gunakan angka urut dan huruf kecil dengan tanda hubung).
3. Update tabel **Daftar File** di atas dan tautkan di `README.md` utama bila perlu.

---

Dokumentasi ini bagian dari project **PetShopApp** — Hizkia Siallagan (231011400154) — Universitas Pamulang.
