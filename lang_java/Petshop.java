public class Petshop{
// membuat class Petshop

    private String idProduk; // atribut id produk
    private String namaProduk; // atribut nama produk
    private int hargaProduk; // atribut harga produk
    private int stokProduk; // atribut stok produk

    public Petshop(){
        // konstruktor kosong
    }

    public Petshop(String idProduk, String namaProduk, int hargaProduk, int stokProduk){
        // konstruktor langsung mengisi atribut
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.stokProduk = stokProduk;
    }

    public void setIdProduk(String idProduk){
        // setter untuk mengisi id produk
        this.idProduk = idProduk;
    }

    public String getIdProduk(){
        // getter untuk mendapatkan id produk
        return idProduk;
    }

    public void setNamaProduk(String namaProduk){
        // setter untuk mengisi nama produk
        this.namaProduk = namaProduk;
    }

    public String getNamaProduk(){
        // getter untuk mendapatkan nama produk
        return namaProduk;
    }

    public void setHargaProduk(int hargaProduk){
        // setter untuk mengisi harga produk
        this.hargaProduk = hargaProduk;
    }

    public int getHargaProduk(){
        // getter untuk mendapatkan harga produk
        return hargaProduk;
    }

    public void setStokProduk(int stokProduk){
        // setter untuk mengisi stok produk
        this.stokProduk = stokProduk;
    }

    public int getStokProduk(){
        // getter untuk mendapatkan stok produk
        return stokProduk;
    }

}