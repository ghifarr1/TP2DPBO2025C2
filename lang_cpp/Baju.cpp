#include <iostream> // import library input/output
#include <string> // import library string
#include <vector> // import library vector
#include <iomanip> // import library input output manipulation
#include <algorithm> // import library algorithm
#include "Aksesoris.cpp" // import class Aksesoris

using namespace std; // menggunakan standard namespace

class Baju : public Aksesoris {
// membuat class Baju sebagai anak dari class Aksesoris

    // deklarasi atribut private
    private:
        string untukBaju;
        int sizeBaju;
        string merkBaju;

    public:

        // konstruktor tanpa parameter
        Baju() : Aksesoris() {
        }

        // konstruktor dengan parameter
        Baju(string idProduk, string namaProduk, int hargaProduk, int stokProduk, string jenisAksesoris, string bahanAksesoris, string warnaAksesoris, string untukBaju, int sizeBaju, string merkBaju) 
        : Aksesoris(idProduk, namaProduk, hargaProduk, stokProduk, jenisAksesoris, bahanAksesoris, warnaAksesoris) {
            
            this->untukBaju = untukBaju;
            this->sizeBaju = sizeBaju;
            this->merkBaju = merkBaju;
        }

        // setter untuk atribut untukBaju
        void setUntukBaju(string untukBaju){
            this->untukBaju = untukBaju;
        }

        // getter untuk atribut untukBaju
        string getUntukBaju(){
            return untukBaju;
        }

        // setter untuk atribut sizeBaju
        void setSizeBaju(int sizeBaju){
            this->sizeBaju = sizeBaju;
        }

        // getter untuk atribut sizeBaju
        int getSizeBaju(){
            return sizeBaju;
        }

        // setter untuk atribut merkBaju
        void setMerkBaju(string merkBaju){
            this->merkBaju = merkBaju;
        }

        // getter untuk atribut merkBaju
        string getMerkBaju(){
            return merkBaju;
        }

        static void tampilkanTabel(vector<Baju>& daftarProduk) {
            // Header tabel
            vector<string> headers = {
                "ID", "Nama Produk", "Harga", "Stok", 
                "Jenis Aksesoris", "Bahan", "Warna", "Untuk", "Size", "Merk"
            };
        
            // Menentukan lebar minimum tiap kolom berdasarkan header
            vector<size_t> colWidths(headers.size());
            for (size_t i = 0; i < headers.size(); i++) {
                colWidths[i] = headers[i].length();
            }
        
            // Update lebar kolom berdasarkan data tiap produk
            for (auto& produk : daftarProduk) {
                colWidths[0] = max(colWidths[0], produk.getIdProduk().length());
                colWidths[1] = max(colWidths[1], produk.getNamaProduk().length());
                colWidths[2] = max(colWidths[2], to_string(produk.getHargaProduk()).length());
                colWidths[3] = max(colWidths[3], to_string(produk.getStokProduk()).length());
                colWidths[4] = max(colWidths[4], produk.getJenisAksesoris().length());
                colWidths[5] = max(colWidths[5], produk.getBahanAksesoris().length());
                colWidths[6] = max(colWidths[6], produk.getWarnaAksesoris().length());
                colWidths[7] = max(colWidths[7], produk.getUntukBaju().length());
                colWidths[8] = max(colWidths[8], to_string(produk.getSizeBaju()).length());
                colWidths[9] = max(colWidths[9], produk.getMerkBaju().length());
            }
        
            // Tambahkan padding agar tidak terlalu mepet (misal 2 spasi)
            const int padding = 2;
            for (auto& width : colWidths) {
                width += padding;
            }
        
            // Mencetak header tabel
            for (size_t i = 0; i < headers.size(); i++) {
                cout << left << setw(colWidths[i]) << headers[i];
            }
            cout << "\n";
        
            // Mencetak garis pemisah
            for (size_t i = 0; i < headers.size(); i++) {
                cout << string(colWidths[i], '-');
            }
            cout << "\n";
        
            // Mencetak tiap baris data
            for (auto& produk : daftarProduk) {
                cout << left << setw(colWidths[0]) << produk.getIdProduk();
                cout << left << setw(colWidths[1]) << produk.getNamaProduk();
                cout << left << setw(colWidths[2]) << to_string(produk.getHargaProduk());
                cout << left << setw(colWidths[3]) << to_string(produk.getStokProduk());
                cout << left << setw(colWidths[4]) << produk.getJenisAksesoris();
                cout << left << setw(colWidths[5]) << produk.getBahanAksesoris();
                cout << left << setw(colWidths[6]) << produk.getWarnaAksesoris();
                cout << left << setw(colWidths[7]) << produk.getUntukBaju();
                cout << left << setw(colWidths[8]) << to_string(produk.getSizeBaju());
                cout << left << setw(colWidths[9]) << produk.getMerkBaju();
                cout << "\n";
            }
        
            // Mencetak garis pemisah di bagian akhir tabel
            for (size_t i = 0; i < headers.size(); i++) {
                cout << string(colWidths[i], '-');
            }
            cout << "\n";
        }

        // Method untuk mengupdate produk
        void updateProduk(string idProdukBaru, string namaProdukBaru, int hargaProdukBaru, int stokProdukBaru, string jenisAksesorisBaru, string bahanAksesorisBaru, string warnaAksesorisBaru, string untukBajuBaru, int sizeBajuBaru, string merkBajuBaru) {
            // Memperbarui data parent
            setIdProduk(idProdukBaru);
            setNamaProduk(namaProdukBaru);
            setHargaProduk(hargaProdukBaru);
            setStokProduk(stokProdukBaru);

            // Memperbarui data child
            setJenisAksesoris(jenisAksesorisBaru);
            setBahanAksesoris(bahanAksesorisBaru);
            setWarnaAksesoris(warnaAksesorisBaru);
            setUntukBaju(untukBajuBaru);
            setSizeBaju(sizeBajuBaru);
            setMerkBaju(merkBajuBaru);
        }

        // Method untuk menghapus produk dari daftar
        static void hapusProduk(vector<Baju>& daftarProduk, string namaProdukDicari) {
            // Menggunakan remove_if untuk menghapus produk yang sesuai
            auto it = remove_if(daftarProduk.begin(), daftarProduk.end(), [&](Baju& produk) {
                return produk.getNamaProduk() == namaProdukDicari;
            });
            
            if(it != daftarProduk.end()) {
                daftarProduk.erase(it, daftarProduk.end());
                cout << "Produk dengan nama " << namaProdukDicari << " berhasil dihapus!" << endl;
            } else {
                cout << "Produk tidak ditemukan!" << endl;
            }
        }

        // Method untuk mencari produk berdasarkan nama
        static void cariProduk(vector<Baju>& daftarProduk, string namaProdukDicari) {
            bool found = false;
            // Mencari dan menampilkan produk yang sesuai
            for(auto &produk : daftarProduk) {
                if(produk.getNamaProduk() == namaProdukDicari) {
                    cout << "\nProduk ditemukan:" << endl;
                    cout << "ID: " << produk.getIdProduk()  << endl;
                    cout << " | Nama: " << produk.getNamaProduk() << endl;
                    cout << " | Harga: " << produk.getHargaProduk() << endl;
                    cout << " | Stok: " << produk.getStokProduk() << endl;
                    cout << " | Jenis: " << produk.getJenisAksesoris() << endl;
                    cout << " | Bahan: " << produk.getBahanAksesoris() << endl;
                    cout << " | Warna: " << produk.getWarnaAksesoris() << endl;
                    cout << " | Untuk: " << produk.getUntukBaju() << endl;
                    cout << " | Size: " << produk.getSizeBaju() << endl;
                    cout << " | Merk: " << produk.getMerkBaju() << endl;
                    found = true;
                    break;
                }
            }
            if(!found) {
                cout << "Produk tidak ditemukan!" << endl;
            }
        }

        ~Baju() {
        }
};
