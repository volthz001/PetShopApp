package petshopapp;

/**
 * Model: Produk / Hewan
 * Developer : Hizkia Siallagan
 * NIM       : 231011400154
 */
public class Produk {

    private String kode;
    private String nama;
    private String jenis;
    private int    stok;
    private double harga;

    public Produk() {}

    public Produk(String kode, String nama, String jenis, int stok, double harga) {
        this.kode  = kode;
        this.nama  = nama;
        this.jenis = jenis;
        this.stok  = stok;
        this.harga = harga;
    }

    public String getKode()              { return kode; }
    public void   setKode(String kode)   { this.kode = kode; }

    public String getNama()              { return nama; }
    public void   setNama(String nama)   { this.nama = nama; }

    public String getJenis()             { return jenis; }
    public void   setJenis(String jenis) { this.jenis = jenis; }

    public int    getStok()              { return stok; }
    public void   setStok(int stok)      { this.stok = stok; }

    public double getHarga()             { return harga; }
    public void   setHarga(double harga) { this.harga = harga; }

    @Override
    public String toString() {
        return "[" + kode + "] " + nama + " (" + jenis + ")";
    }
}
