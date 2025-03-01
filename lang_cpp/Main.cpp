#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include "Baju.cpp"  // Pastikan path-nya benar

using namespace std;

int main() {
    // Menggunakan vector untuk menyimpan objek Baju
    vector<Baju> daftarProduk;
    string inputCommand;

    // 5 data wajib yang ada sebelum di input
    Baju produkBaru1("IKR110", "KaosLucu_Kucing", 27000, 8, "Pakaian", "Sutra", "Abu-Abu", "Kucing", 12, "Uniqlo");
    daftarProduk.push_back(produkBaru1);

    Baju produkBaru2("IKR120", "KemejaLucu_Kucing", 45000, 3, "Pakaian", "Katun", "Biru-Gelap", "Kucing", 14, "Uniqlo");
    daftarProduk.push_back(produkBaru2);

    Baju produkBaru3("IKR130", "KaosLucu_Anjing", 57000, 6, "Pakaian", "Sutra", "Hitam-Putih", "Anjing", 15, "Rucas");
    daftarProduk.push_back(produkBaru3);
    
    Baju produkBaru4("IKR140", "KemejaLucu_Anjing", 65000, 13, "Pakaian", "Katun", "Merah-Maroon", "Anjing", 17, "Supreme");
    daftarProduk.push_back(produkBaru4);

    Baju produkBaru5("IKR150", "KaosSantuy_Kadal", 38000, 3, "Pakaian", "Katun", "Hijau-Biru", "Kadal", 10, "Svmmer");
    daftarProduk.push_back(produkBaru5);

    cout << "===========================================================" << endl;
    cout << "===== WELCOME TO MIAW MIAW PETSHOP PRODUCT MANAGEMENT =====" << endl;
    cout << "===========================================================" << endl;
    cout << "Command Line: view, add, update, delete, search, Exit" << endl;
    
    do {
        cout << "\nMasukkan Command: ";
        cin >> inputCommand;
        
        if(inputCommand == "view") {

            cout << "\nMenampilkan daftar Produk:" << endl;
            // Memanggil method static untuk menampilkan tabel produk
            Baju::tampilkanTabel(daftarProduk);

        }else if(inputCommand == "add") {

            string id, nama, jenis, bahan, warna, untukBaju, merk;
            int harga, stok, size;
            
            cout << "ID produk: ";          cin >> id;
            cout << "Nama produk: ";        cin >> nama;
            cout << "Harga produk: ";       cin >> harga;
            cout << "Stok produk: ";        cin >> stok;
            cout << "Jenis Aksesoris: ";    cin >> jenis;
            cout << "Bahan Aksesoris: ";    cin >> bahan;
            cout << "Warna Aksesoris: ";    cin >> warna;
            cout << "Peruntukan Baju: ";    cin >> untukBaju;
            cout << "Ukuran Baju: ";        cin >> size;
            cout << "Merk Baju: ";          cin >> merk;
            
            // Membuat objek Baju dan menambahkannya ke vector
            Baju produkBaru(id, nama, harga, stok, jenis, bahan, warna, untukBaju, size, merk);
            daftarProduk.push_back(produkBaru);
            cout << "Produk berhasil ditambahkan!" << endl;

        }else if(inputCommand == "update") {

            string namaCari;
            cout << "Masukkan nama produk yang ingin diupdate: "; 
            cin >> namaCari;
            
            bool found = false;
            // Mencari produk berdasarkan nama
            for(auto &produk : daftarProduk) {
                if(produk.getNamaProduk() == namaCari) {
                    // Tampilkan data produk yang ditemukan
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
                    
                    // Input data baru untuk update
                    string id, nama, jenis, bahan, warna, untukBaju, merk;
                    int harga, stok, size;
                    
                    cout << "\nMasukkan data baru:" << endl;
                    cout << "Masukkan ID produk baru: ";        cin >> id;
                    cout << "Masukkan Nama produk baru: ";      cin >> nama;
                    cout << "Masukkan Harga produk baru: ";     cin >> harga;
                    cout << "Masukkan Stok produk baru: ";      cin >> stok;
                    cout << "Masukkan Jenis Aksesoris: ";       cin >> jenis;
                    cout << "Masukkan Bahan Aksesoris: ";       cin >> bahan;
                    cout << "Masukkan Warna Aksesoris: ";       cin >> warna;
                    cout << "Masukkan Untuk Baju: ";            cin >> untukBaju;
                    cout << "Masukkan Ukuran Baju: ";           cin >> size;
                    cout << "Masukkan Merk Baju: ";             cin >> merk;
                    
                    // Memperbarui data produk menggunakan method updateProduk()
                    produk.updateProduk(id, nama, harga, stok, jenis, bahan, warna, untukBaju, size, merk);
                    cout << "Produk berhasil diupdate!" << endl;
                    found = true;
                    break;
                }
            }

            if (!found) {
                cout << "Produk tidak ditemukan!" << endl;
            }

        }else if(inputCommand == "delete") {

            string namaCari;
            cout << "Masukkan nama produk yang ingin dihapus: "; 
            cin >> namaCari;
            
            Baju::hapusProduk(daftarProduk, namaCari);
            
        }else if(inputCommand == "search") {

            string namaCari;
            cout << "Masukkan nama produk yang ingin dicari: "; 
            cin >> namaCari;
            
            Baju::cariProduk(daftarProduk, namaCari);

        }else if(inputCommand == "Exit") {

            cout << "\nKeluar dari program." << endl;

        }else {

            cout << "Perintah tidak dikenali. Silakan coba lagi." << endl;

        }
        
    } while(inputCommand != "Exit");
    
    return 0;
}
