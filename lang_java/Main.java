import java.util.Scanner; // import lib untuk input
import java.util.List; // import lib untuk list
import java.util.ArrayList; // import lib untuk array list
import java.util.ListIterator; // import lib untuk list iterator

public class Main { // membuat main class 

    public static void main(String[] args) {  // main program methods

        String inputCommand; // string untuk input command

        List<Baju> daftarProduk = new ArrayList<Baju>();  // deklarasi list of objects

        // inisialisasi data awal
        daftarProduk.add(new Baju("IKR110", "KaosLucu_Kucing", 45000, 13, "Pakaian", "Sutra", "Merah-Maroon", "Kucing", 11, "Uniqlo"));
        daftarProduk.add(new Baju("IKR120", "KemejaLucu_Kucing", 65000, 6, "Pakaian", "Katun", "Hijau-Tua", "Kucing", 13, "Rucas"));
        daftarProduk.add(new Baju("IKR130", "KaosLucu_Anjing", 55000, 9, "Pakaian", "Sutra", "Biru-Donker", "Anjing", 15, "Uniqlo"));
        daftarProduk.add(new Baju("IKR140", "KemejaLucu_Anjing", 85000, 4, "Pakaian", "Katun", "Hijau-Emas", "Anjing", 17, "Rucas"));
        daftarProduk.add(new Baju("IKR150", "Sarung_Kadal", 35000, 3, "Pakaian", "Sutra", "Biru", "Kadal", 15, "Wadimor"));

        // terminal informations
        System.out.println("===========================================================");
        System.out.println("===== WELCOME TO MIAW MIAW PETSHOP PRODUCT MANAGEMENT =====");
        System.out.println("===========================================================");
        System.out.println("Command Line: view, add, update, delete, search, Exit");

        // loop utama
        do{

            Scanner sc = new Scanner(System.in); // deklarasi scanner input

            System.out.println();
            System.out.print("Masukkan Command: ");
            inputCommand = sc.next(); // meminta masukkan user untuk input command

            if(inputCommand.equals("view")){ // case input view

                System.out.println("Menampilkan daftar Produk"); 
                Baju.tampilkanProduk(daftarProduk);  // Memanggil metode statis

            }else if(inputCommand.equals("add")){ // case input add

                // var temp
                String id, nama, jenis, bahan, warna, untuk, merk; 
                int harga, stok, size;

                // meminta masukkan user untuk add data ke list
                System.out.print("ID Produk: ");
                id = sc.next();
                System.out.print("Nama Produk: ");
                nama = sc.next();
                System.out.print("Harga Produk: ");
                harga = sc.nextInt();
                System.out.print("Stok Produk: ");
                stok = sc.nextInt();
                System.out.print("Jenis Produk: ");
                jenis = sc.next();
                System.out.print("Bahan Produk: ");
                bahan = sc.next();
                System.out.print("Warna Produk: ");
                warna = sc.next();
                System.out.print("Peruntukan Baju: ");
                untuk = sc.next();
                System.out.print("Size Baju: ");
                size = sc.nextInt();
                System.out.print("Merk Baju: ");
                merk = sc.next();

                Baju baju = new Baju(id, nama, harga, stok, jenis, bahan, warna, untuk, size, merk); // instansiasi object

                daftarProduk.add(baju); // tambahkan ke dalam list

                System.out.println("Produk berhasil ditambahkan!");

            }else if(inputCommand.equals("update")){ // case input update

                String namaCari; // var cari nama produk
                System.out.print("Masukkan nama produk yang ingin diupdate: ");
                namaCari = sc.next(); // meminta masukkan user 

                Baju baju = Baju.cariProduk(daftarProduk, namaCari); // memanggil method mencari object dalam list berdasarkan nama
                
                if(baju!= null){ // jika tidak null

                    System.out.println("Produk ditemukan!");
                    System.out.println("| ID Produk : " + baju.getIdProduk());
                    System.out.println("| Nama Produk : " + baju.getNamaProduk());
                    System.out.println("| Harga Produk : " + baju.getHargaProduk());
                    System.out.println("| Stok Produk : " + baju.getStokProduk());
                    System.out.println("| Jenis Produk : " + baju.getJenisProduk());
                    System.out.println("| Bahan Produk : " + baju.getBahanProduk());
                    System.out.println("| Warna Produk : " + baju.getWarnaProduk());
                    System.out.println("| Peruntukan Baju : " + baju.getUntukBaju());
                    System.out.println("| Size Baju : " + baju.getSizeBaju());
                    System.out.println("| Merk Baju : " + baju.getMerkBaju());


                    // var temp untuk inputan update
                    String idBaru, namaBaru, jenisBaru, bahanBaru, warnaBaru, untukBaru, merkBaru; 
                    int hargaBaru, stokBaru, sizeBaru;

                    // meminta masukkan user untuk add data ke list
                    System.out.print("ID Baru Produk: ");
                    idBaru = sc.next();
                    System.out.print("Nama Baru Produk: ");
                    namaBaru = sc.next();
                    System.out.print("Harga Baru Produk: ");
                    hargaBaru = sc.nextInt();
                    System.out.print("Stok Baru Produk: ");
                    stokBaru = sc.nextInt();
                    System.out.print("Jenis Baru Produk: ");
                    jenisBaru = sc.next();
                    System.out.print("Bahan Baru Produk: ");
                    bahanBaru = sc.next();
                    System.out.print("Warna Baru Produk: ");
                    warnaBaru = sc.next();
                    System.out.print("Peruntukan Baru Baju: ");
                    untukBaru = sc.next();
                    System.out.print("Size Baru Baju: ");
                    sizeBaru = sc.nextInt();
                    System.out.print("Merk Baru Baju: ");
                    merkBaru = sc.next();
                    
                    baju.updateProduk(idBaru, namaBaru, hargaBaru, stokBaru, jenisBaru, bahanBaru, warnaBaru, untukBaru, sizeBaru, merkBaru); // panggil method update

                    System.out.println("Produk berhasil diupdate!");


                } else {

                    System.out.println("Produk tidak ditemukan!");

                }


            }else if(inputCommand.equals("delete")){ // case input delete

                System.out.print("Masukkan nama produk yang ingin dihapus: ");
                String namaCari = sc.next(); // meminta masukkan user untuk nama produk object yg dicari

                Baju baju = Baju.cariProduk(daftarProduk, namaCari); // panggil method cari object dengan nama

                if (baju != null) { // jika tidak null

                    System.out.println("Produk ditemukan!");
                    System.out.println("| ID Produk : " + baju.getIdProduk());
                    System.out.println("| Nama Produk : " + baju.getNamaProduk());
                    System.out.println("| Harga Produk : " + baju.getHargaProduk());
                    System.out.println("| Stok Produk : " + baju.getStokProduk());
                    System.out.println("| Jenis Produk : " + baju.getJenisProduk());
                    System.out.println("| Bahan Produk : " + baju.getBahanProduk());
                    System.out.println("| Warna Produk : " + baju.getWarnaProduk());
                    System.out.println("| Peruntukan Baju : " + baju.getUntukBaju());
                    System.out.println("| Size Baju : " + baju.getSizeBaju());
                    System.out.println("| Merk Baju : " + baju.getMerkBaju());

                    boolean found = false;
                    ListIterator<Baju> iterator = daftarProduk.listIterator(); // deklarasi iterator object dalam list
                    
                    while (iterator.hasNext() && !found) { // perulangan untuk mencari object

                        if (iterator.next().equals(baju)) { // Cek apakah elemen yang ditemukan sesuai

                            // Jika ditemukan, hapus object dan break perulangan
                            baju.hapusProduk(daftarProduk, iterator); // panggil method hapus produk
                            System.out.println("Produk berhasil dihapus!");
                            found = true;

                        }

                    }

                    if (!found) {
                        System.out.println("Produk tidak ditemukan dalam daftar!");
                    }

                } else {
                    System.out.println("Produk tidak ditemukan!");
                }

            }else if(inputCommand.equals("search")){ // case input search

                String namaCari; // var untuk nama yg dicari
                System.out.print("Masukkan nama produk yang ingin dicari: ");
                namaCari = sc.next(); // meminta masukkan user

                Baju baju = Baju.cariProduk(daftarProduk, namaCari); // panggil method untuk mencari object dgn nama
                
                if(baju!= null){ // jika tidak null

                    System.out.println("Produk ditemukan!");
                    System.out.println("| ID Produk : " + baju.getIdProduk());
                    System.out.println("| Nama Produk : " + baju.getNamaProduk());
                    System.out.println("| Harga Produk : " + baju.getHargaProduk());
                    System.out.println("| Stok Produk : " + baju.getStokProduk());
                    System.out.println("| Jenis Produk : " + baju.getJenisProduk());
                    System.out.println("| Bahan Produk : " + baju.getBahanProduk());
                    System.out.println("| Warna Produk : " + baju.getWarnaProduk());
                    System.out.println("| Peruntukan Baju : " + baju.getUntukBaju());
                    System.out.println("| Size Baju : " + baju.getSizeBaju());
                    System.out.println("| Merk Baju : " + baju.getMerkBaju());

                } else {

                    System.out.println("Produk tidak ditemukan!");

                }

            }

        }while(!inputCommand.equals("Exit")); 

    }

}