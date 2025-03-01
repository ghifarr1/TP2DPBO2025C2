import java.util.List; // import library untuk list
import java.util.ListIterator; // import library untuk iterator list

public class Baju extends Aksesoris{
// membuat class Baju sebagai anak dari class Aksesoris

    // atribut class
    private String untukBaju;
    private int sizeBaju;
    private String merkBaju;

    // constructor class kosong
    public Baju(){
        // memanggil konstruktor dari parent class
        super();
    }

    // constructor class dengan parameter
    public Baju(String idProduk, String namaProduk, int hargaProduk, int stokProduk, String jenisProduk, String bahanProduk, String warnaProduk, String untukBaju, int sizeBaju, String merkBaju){
        // memanggil konstruktor dari parent class
        super(idProduk, namaProduk, hargaProduk, stokProduk, jenisProduk, bahanProduk, warnaProduk);
        this.untukBaju = untukBaju;
        this.sizeBaju = sizeBaju;
        this.merkBaju = merkBaju;
    }

    // setter atribut untukBaju
    public void setUntukBaju(String untukBaju){
        this.untukBaju = untukBaju;
    }

    // getter atribut untukBaju
    public String getUntukBaju(){
        return untukBaju;
    }

    // setter atribut sizeBaju
    public void setSizeBaju(int sizeBaju){
        this.sizeBaju = sizeBaju;
    }

    // getter atribut sizeBaju
    public int getSizeBaju(){
        return sizeBaju;
    }

    // setter atribut merkBaju
    public void setMerkBaju(String merkBaju){
        this.merkBaju = merkBaju;
    }

    // getter atribut merkBaju
    public String getMerkBaju(){
        return merkBaju;
    }

    /** Method Fitur untuk manipulasi data */

    // method untuk menampilkan keseluruhan produk
    public static void tampilkanProduk(List<Baju> daftarProduk) {
        if (daftarProduk.isEmpty()) {
            System.out.println("Daftar produk kosong.");
            return;
        }

        // Menentukan lebar kolom yang cukup berdasarkan data
        int maxId = "ID Produk".length();
        int maxNama = "Nama Produk".length();
        int maxHarga = "Harga".length();
        int maxStok = "Stok".length();
        int maxJenis = "Jenis".length();
        int maxBahan = "Bahan".length();
        int maxWarna = "Warna".length();
        int maxUntuk = "Untuk".length();
        int maxSize = "Size".length();
        int maxMerk = "Merk".length();

        // Menghitung lebar kolom berdasarkan data yang ada
        for (Baju b : daftarProduk) {
            maxId = Math.max(maxId, b.getIdProduk().length());
            maxNama = Math.max(maxNama, b.getNamaProduk().length());
            maxHarga = Math.max(maxHarga, String.valueOf(b.getHargaProduk()).length());
            maxStok = Math.max(maxStok, String.valueOf(b.getStokProduk()).length());
            maxJenis = Math.max(maxJenis, b.getJenisProduk().length());
            maxBahan = Math.max(maxBahan, b.getBahanProduk().length());
            maxWarna = Math.max(maxWarna, b.getWarnaProduk().length());
            maxUntuk = Math.max(maxUntuk, b.getUntukBaju().length());
            maxSize = Math.max(maxSize, String.valueOf(b.getSizeBaju()).length());
            maxMerk = Math.max(maxMerk, b.getMerkBaju().length());
        }

        // Membuat format tabel
        String format = "| %-" + maxId + "s | %-" + maxNama + "s | %-" + maxHarga + "s | %-" + maxStok + "s | %-" + maxJenis + "s | %-" + maxBahan + "s | %-" + maxWarna + "s | %-" + maxUntuk + "s | %-" + maxSize + "s | %-" + maxMerk + "s |%n";

        // Menghitung total panjang garis pemisah berdasarkan format tabel
        int totalLength = maxId + maxNama + maxHarga + maxStok + maxJenis + maxBahan + maxWarna + maxUntuk + maxSize + maxMerk + (11 * 3) + 1 - 3; // 11 kolom dan 3 spasi antar kolom serta batas kiri-kanan "|"

        // Membuat garis pemisah secara dinamis
        String separator = "=".repeat(totalLength);

        // Mencetak header tabel dengan garis pemisah yang sesuai
        System.out.println(separator);
        System.out.printf(format, "ID Produk", "Nama Produk", "Harga", "Stok", "Jenis", "Bahan", "Warna", "Untuk", "Size", "Merk");
        System.out.println(separator);

        // Mencetak isi tabel
        for (Baju b : daftarProduk) {
            System.out.printf(format, b.getIdProduk(), b.getNamaProduk(), b.getHargaProduk(), b.getStokProduk(), b.getJenisProduk(), b.getBahanProduk(), b.getWarnaProduk(), b.getUntukBaju(), b.getSizeBaju(), b.getMerkBaju());
        }

        System.out.println(separator);
    }



    // method untuk mengupdate produk
    public void updateProduk(String idProdukBaru, String namaProdukBaru, int hargaProdukBaru, int stokProdukBaru, String jenisProdukBaru, String bahanProdukBaru, String warnaProdukBaru, String untukBajuBaru, int sizeBajuBaru, String merkBajuBaru){

        setIdProduk(idProdukBaru);
        setNamaProduk(namaProdukBaru);
        setHargaProduk(hargaProdukBaru);
        setStokProduk(stokProdukBaru);
        setJenisProduk(jenisProdukBaru);
        setBahanProduk(bahanProdukBaru);
        setWarnaProduk(warnaProdukBaru);

        this.untukBaju = untukBajuBaru;
        this.sizeBaju = sizeBajuBaru;
        this.merkBaju = merkBajuBaru;
    }

    // method untuk menghapus produk
    public void hapusProduk(List<Baju> daftarProduk, ListIterator<Baju> it){
        // Optional: set data ke nilai default
        setIdProduk("");
        setNamaProduk("");
        setHargaProduk(0);
        setStokProduk(0);
        setJenisProduk("");
        setBahanProduk("");
        setWarnaProduk("");

        untukBaju = null;
        sizeBaju = 0;
        merkBaju = null;

        // Hapus elemen dari container menggunakan iterator yang diterima
        if (it != null) {
            it.remove(); // Menghapus elemen pada posisi iterator saat ini
        }
    }

    // method untuk mencari produk berdasarkan nama produk
    public static Baju cariProduk(List<Baju> daftarProduk, String namaProduk){
        for(Baju p : daftarProduk){
            if(p.getNamaProduk().equalsIgnoreCase(namaProduk)){
                return p;
            }
        }
        return null; // jika produk tidak ditemukan
    }


}