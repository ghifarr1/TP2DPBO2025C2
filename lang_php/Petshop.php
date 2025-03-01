<?php
class Petshop{
    private string $idProduk;
    private string $namaProduk;
    private int $hargaProduk;
    private int $stokProduk;
    private string $gambarProduk;

    public function __construct($idProduk, $namaProduk, $hargaProduk, $stokProduk, $gambarProduk){
        $this->idProduk = $idProduk;
        $this->namaProduk = $namaProduk;
        $this->hargaProduk = $hargaProduk;
        $this->stokProduk = $stokProduk;
        $this->gambarProduk = $gambarProduk;
    }

    // setter untuk id Produk
    public function setIdProduk($idProduk){
        $this->idProduk = $idProduk;
    }

    // getter untuk id Produk
    public function getIdProduk(){
        return $this->idProduk;
    }

    // setter untuk nama Produk
    public function setNamaProduk($namaProduk){
        $this->namaProduk = $namaProduk;
    }

    // getter untuk nama Produk
    public function getNamaProduk(){
        return $this->namaProduk;
    }

    // setter untuk harga Produk
    public function setHargaProduk($hargaProduk){
        $this->hargaProduk = $hargaProduk;
    }

    // getter untuk harga Produk
    public function getHargaProduk(){
        return $this->hargaProduk;
    }

    // setter untuk stok produk
    public function setStokProduk($stokProduk){
        $this->stokProduk = $stokProduk;
    }

    // getter untuk stok Produk
    public function getStokProduk(){
        return $this->stokProduk;
    }

    // setter untuk gambar Produk
    public function setGambarProduk($gambarProduk){
        $this->gambarProduk = $gambarProduk;
    }

    // getter untuk gambar Produk
    public function getGambarProduk(){
        return $this->gambarProduk;
    }

    public function toArray(){
        return [
            'idProduk' => $this->idProduk,
            'namaProduk' => $this->namaProduk,
            'kategoriProduk' => $this->kategoriProduk,
            'hargaProduk' => $this->hargaProduk,
            'gambarProduk' => $this->gambarProduk
        ];
    }

    public function __destruct(){
    }

}
?>