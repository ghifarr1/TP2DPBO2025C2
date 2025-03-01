#include <iostream> // import library input/output
#include <string> // import library string

using namespace std; // menggunakan standard namespace

class Petshop{
// membuat class petshop

    // deklarasi atribut private
    private:
        string idProduk;
        string namaProduk;
        int hargaProduk;
        int stokProduk;

    // deklarasi method public
    public:

        // konstruktor tanpa parameter
        Petshop(){
        };

        // konstruktor dengan parameter
        Petshop(string idProduk, string namaProduk, int hargaProduk, int stokProduk){
            this->idProduk = idProduk;
            this->namaProduk = namaProduk;
            this->hargaProduk = hargaProduk;
            this->stokProduk = stokProduk;
        }

        // setter untuk id petshop
        void setIdProduk(string idProduk){
            this->idProduk = idProduk;
        }

        // getter untuk id petshop
        string getIdProduk(){
            return idProduk;
        }

        // setter untuk nama produk
        void setNamaProduk(string namaProduk){
            this->namaProduk = namaProduk;
        }

        // getter untuk nama produk
        string getNamaProduk(){
            return namaProduk;
        }

        // setter untuk harga produk
        void setHargaProduk(int hargaProduk){
            this->hargaProduk = hargaProduk;
        }

        // getter untuk harga produk
        int getHargaProduk(){
            return hargaProduk;
        }

        // setter untuk stok produk
        void setStokProduk(int stokProduk){
            this->stokProduk = stokProduk;
        }

        // getter untuk stok produk
        int getStokProduk(){
            return stokProduk;
        }

        ~Petshop(){
            // destruktor
        }
  
};