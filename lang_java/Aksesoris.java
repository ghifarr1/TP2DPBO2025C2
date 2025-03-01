public class Aksesoris extends Petshop{
// membuat class Aksesoris sebagai anak dari class Petshop

    private String jenisProduk;
    private String bahanProduk;
    private String warnaProduk;

    // konstruktor kosong
    public Aksesoris(){
        // memanggil konstruktor dari parent class
        super();
    }

    // konstruktor dengan parameter
    public Aksesoris(String idProduk, String namaProduk, int hargaProduk, int stokProduk, String jenisProduk, String bahanProduk, String warnaProduk){
        // memanggil konstruktor parent class
        super(idProduk, namaProduk, hargaProduk, stokProduk);
        this.jenisProduk = jenisProduk;
        this.bahanProduk = bahanProduk;
        this.warnaProduk = warnaProduk;
    }

    public void setJenisProduk(String jenisProduk){
        // setter untuk mengisi jenisProduk
        this.jenisProduk = jenisProduk;
    }

    public String getJenisProduk(){
        // getter untuk mendapatkan jenisProduk
        return jenisProduk;
    }

    public void setBahanProduk(String bahanProduk){
        // setter untuk mengisi bahanProduk
        this.bahanProduk = bahanProduk;
    }

    public String getBahanProduk(){
        // getter untuk mendapatkan bahanProduk
        return bahanProduk;
    }

    public void setWarnaProduk(String warnaProduk){
        // setter untuk mengisi warnaProduk
        this.warnaProduk = warnaProduk;
    }

    public String getWarnaProduk(){
        // getter untuk mendapatkan warnaProduk
        return warnaProduk;
    }

}