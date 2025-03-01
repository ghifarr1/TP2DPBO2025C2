<?php
include "Aksesoris.php";
class Baju extends Aksesoris{
// membuat class Baju sebagai anak dari class Aksesoris

    // deklarasi atribut class
    private string $untukBaju;
    private int $sizeBaju;
    private string $merkBaju;

    public function __construct($idProduk, $namaProduk, $hargaProduk, $stokProduk, $gambarProduk, $jenisAksesoris, $bahanAksesoris, $warnaAksesoris, $untukBaju, $sizeBaju, $merkBaju){
        parent::__construct($idProduk, $namaProduk, $hargaProduk, $stokProduk, $gambarProduk, $jenisAksesoris, $bahanAksesoris, $warnaAksesoris);
        $this->untukBaju = $untukBaju;
        $this->sizeBaju = $sizeBaju;
        $this->merkBaju = $merkBaju;
    }

    // setter untuk atribut untukBaju
    public function setUntukBaju($untukBaju){
        $this->untukBaju = $untukBaju;
    }

    // getter untuk atribut untukBaju
    public function getUntukBaju(){
        return $this->untukBaju;
    }

    // setter untuk atribut sizeBaju
    public function setSizeBaju($sizeBaju){
        $this->sizeBaju = $sizeBaju;
    }

    // getter untuk atribut sizeBaju
    public function getSizeBaju(){
        return $this->sizeBaju;
    }

    // setter untuk atribut merkBaju
    public function setMerkBaju($merkBaju){
        $this->merkBaju = $merkBaju;
    }

    // getter untuk atribut merkBaju
    public function getMerkBaju(){
        return $this->merkBaju;
    }

    public function __destruct(){
    }

}
?>