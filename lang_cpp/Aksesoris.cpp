#include <iostream> // import library input/output
#include <string> // import library string
#include "Petshop.cpp" // import class Petshop

using namespace std; // menggunakan standard namespace

class Aksesoris : public Petshop{
// membuat class Aksesoris sebagai anak dari class Pershop

    // deklarasi atribut private
    private:
        string jenisAksesoris;
        string bahanAksesoris;
        string warnaAksesoris;


    // deklarasi method public
    public:

        // konstruktor tanpa parameter
        Aksesoris() : Petshop() {
            // Konstruktor default child memanggil konstruktor default parent
        }
        
        // Konstruktor dengan parameter
        Aksesoris(string idProduk, string namaProduk, int hargaProduk, int stokProduk, string jenisAksesoris, string bahanAksesoris, string warnaAksesoris) 
        : Petshop(idProduk, namaProduk, hargaProduk, stokProduk) { // Memanggil konstruktor parent di Initializer List

            // Inisialisasi atribut milik Aksesoris
            this->jenisAksesoris = jenisAksesoris;
            this->bahanAksesoris = bahanAksesoris;
            this->warnaAksesoris = warnaAksesoris;
        }


        // setter untuk atribut jenisAksesoris
        void setJenisAksesoris(string jenisAksesoris){
            this->jenisAksesoris = jenisAksesoris;
        }

        // getter untuk atribut jenisAksesoris
        string getJenisAksesoris(){
            return jenisAksesoris;
        }

        // setter untuk atribut bahanAksesoris
        void setBahanAksesoris(string bahanAksesoris){
            this->bahanAksesoris = bahanAksesoris;
        }

        // getter untuk atribut bahanAksesoris
        string getBahanAksesoris(){
            return bahanAksesoris;
        }

        // setter untuk atribut warnaAksesoris
        void setWarnaAksesoris(string warnaAksesoris){
            this->warnaAksesoris = warnaAksesoris;
        }

        // getter untuk atribut warnaAksesoris
        string getWarnaAksesoris(){
            return warnaAksesoris;
        }

        ~Aksesoris(){
        }

};