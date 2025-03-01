<?php 
include "Petshop.php";
class Aksesoris extends Petshop{
// membuat class Aksesoris sebagai anak dari class Petshop

    // deklarasi atribut class
    private string $jenisAksesoris;
    private string $bahanAksesoris;
    private string $warnaAksesoris;

    public function __construct($idProduk, $namaProduk, $hargaProduk, $stokProduk, $gambarProduk, $jenisAksesoris, $bahanAksesoris, $warnaAksesoris){
        parent::__construct($idProduk, $namaProduk, $hargaProduk, $stokProduk, $gambarProduk);
        $this->jenisAksesoris = $jenisAksesoris;
        $this->bahanAksesoris = $bahanAksesoris;
        $this->warnaAksesoris = $warnaAksesoris;
    }

    // setter untuk atribut jenisAksesoris
    public function setJenisAksesoris($jenisAksesoris){
        $this->jenisAksesoris = $jenisAksesoris;
    }

    // getter untuk atribut jenisAksesoris
    public function getJenisAksesoris(){
        return $this->jenisAksesoris;
    }

    // setter untuk atribut bahanAksesoris
    public function setBahanAksesoris($bahanAksesoris){
        $this->bahanAksesoris = $bahanAksesoris;
    }

    // getter untuk atribut bahanAksesoris
    public function getBahanAksesoris(){
        return $this->bahanAksesoris;
    }

    // setter untuk atribut warnaAksesoris
    public function setWarnaAksesoris($warnaAksesoris){
        $this->warnaAksesoris = $warnaAksesoris;
    }

    // getter untuk atribut warnaAksesoris
    public function getWarnaAksesoris(){
        return $this->warnaAksesoris;
    }

    public function __destruct(){
    }

}
?>