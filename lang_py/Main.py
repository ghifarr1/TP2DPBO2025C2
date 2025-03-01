from Baju import Baju # import class dari module

def main(): # deklarasi main function

    inputCommand = "" # var input command

    daftarProduk = [] # list of objects daftarProduk

    # membuat object dan menambahkannya ke list
    produk1 = Baju("IKR110", "KaosLucu_Kucing", 45000, 13, "Pakaian", "Sutra", "Merah-Maroon", "Kucing", 11, "Uniqlo")
    daftarProduk.append(produk1)

    produk2 = Baju("IKR120", "KemejaLucu_Kucing", 65000, 6, "Pakaian", "Katun", "Hijau-Tua", "Kucing", 13, "Rucas")
    daftarProduk.append(produk2)

    produk3 = Baju("IKR130", "KaosLucu_Anjing", 55000, 9, "Pakaian", "Sutra", "Biru-Donker", "Anjing", 15, "Uniqlo")
    daftarProduk.append(produk3)

    produk4 = Baju("IKR140", "KemejaLucu_Anjing", 85000, 4, "Pakaian", "Katun", "Hijau-Emas", "Anjing", 17, "Rucas")
    daftarProduk.append(produk4)

    produk5 = Baju("IKR150", "Sarung_Kadal", 35000, 3, "Pakaian", "Sutra", "Biru", "Kadal", 15, "Wadimor")
    daftarProduk.append(produk5)

    # information dan command line
    print("===========================================================\n")
    print("===== WELCOME TO MIAW MIAW PETSHOP PRODUCT MANAGEMENT =====\n")
    print("===========================================================\n")
    print("Command Line: view, add, update, delete, search, Exit\n")

    running = True # mark running

    # loop utama
    while running: 

        inputCommand = input("Enter your command: ") # meminta masukkan user

        if inputCommand == "view": # case input view
            
            print("Menampilkan daftar Produk\n")

            # tampilkan object dalam list
            if daftarProduk:  # Pastikan list tidak kosong
                daftarProduk[0].tampilkanProduk(daftarProduk)
            else:
                print("Daftar produk kosong.")
        
        elif inputCommand == "add": # case input add
            
            # meminta masukkan user
            idProduk = input("ID Produk: ")
            namaProduk = input("Nama produk: ")
            hargaProduk = int(input("Harga Produk: "))
            stokProduk = int(input("Stok Produk: "))
            jenisAksesoris = input("Jenis Aksesoris: ")
            bahanAksesoris = input("Bahan Aksesoris: ")
            warnaAksesoris = input("Warna Aksesoris: ")
            untukBaju = input("Peruntukan Baju: ")
            sizeBaju = int(input("Size Baju: "))
            merkBaju = input("Merk Baju: ")

            # tambahkan ke dalam list
            baju = Baju(idProduk, namaProduk, hargaProduk, stokProduk, jenisAksesoris, bahanAksesoris, warnaAksesoris, untukBaju, sizeBaju, merkBaju)
            daftarProduk.append(baju)

            print("Produk berhasil ditambahkan\n")

        elif inputCommand == "update": # case input update
            
            # meminta masukkan user
            namaProduk = input("Masukkan nama produk yang ingin diupdate: ")
            
            found = False
            i = 0

            # cari object dalam list
            while i < len(daftarProduk) and not found:
                baju = daftarProduk[i]
                
                # case object ditemukan
                if baju.getNamaProduk() == namaProduk:

                    print("Produk ditemukan!\n")
                    print("Detail Produk:")
                    print("| ID Produk: ", baju.getIdProduk())
                    print("| Nama Produk: ", baju.getNamaProduk())
                    print("| Harga: ", baju.getHargaProduk())
                    print("| Stok: ", baju.getStokProduk())
                    print("| Jenis Aksesoris: ", baju.getJenisAksesoris())
                    print("| Bahan Aksesoris: ", baju.getBahanAksesoris())
                    print("| Warna Aksesoris: ", baju.getWarnaAksesoris())
                    print("| Peruntukan Baju: ", baju.getUntukBaju())
                    print("| Size: ", baju.getSizeBaju())
                    print("| Merk: ", baju.getMerkBaju())

                    # minta masukkan ke user
                    idProdukBaru = input("ID produk baru: ")
                    namaProdukBaru = input("Nama produk baru: ")
                    hargaProdukBaru = int(input("Harga produk baru: "))
                    stokProdukBaru = int(input("Stok produk baru: "))
                    jenisAksesorisBaru = input("Jenis Aksesoris baru: ")
                    bahanAksesorisBaru = input("Bahan Aksesoris baru: ")
                    warnaAksesorisBaru = input("Warna Aksesoris baru: ")
                    untukBajuBaru = input("Peruntukan Baju baru: ")
                    sizeBajuBaru = int(input("Size Baju baru: "))
                    merkBajuBaru = input("Merk Baju baru: ")

                    # update object
                    baju.updateProduk(idProdukBaru, namaProdukBaru, hargaProdukBaru, stokProdukBaru, jenisAksesorisBaru, bahanAksesorisBaru, warnaAksesorisBaru, untukBajuBaru, sizeBajuBaru, merkBajuBaru)
                    print("Produk berhasil diupdate\n")
                    
                    found = True  # Tandai bahwa produk telah ditemukan dan diupdate

                i += 1
            
            if not found:
                print("Produk tidak ditemukan\n")

        elif inputCommand == "delete": # case input delete
            
            # meminta masukkan user
            namaProduk = input("Masukkan nama produk yang ingin dihapus: ")
            
            found = False
            i = 0

            # cari object dalam list
            while i < len(daftarProduk) and not found:
                baju = daftarProduk[i]
                
                # case object ditemukan
                if baju.getNamaProduk() == namaProduk:

                    print("Produk ditemukan!\n")
                    print("Detail Produk:")
                    print("| ID Produk: ", baju.getIdProduk())
                    print("| Nama Produk: ", baju.getNamaProduk())
                    print("| Harga: ", baju.getHargaProduk())
                    print("| Stok: ", baju.getStokProduk())
                    print("| Jenis Aksesoris: ", baju.getJenisAksesoris())
                    print("| Bahan Aksesoris: ", baju.getBahanAksesoris())
                    print("| Warna Aksesoris: ", baju.getWarnaAksesoris())
                    print("| Peruntukan Baju: ", baju.getUntukBaju())
                    print("| Size: ", baju.getSizeBaju())
                    print("| Merk: ", baju.getMerkBaju())

                    # hapus object
                    baju.hapusProduk(daftarProduk)
                    print("Produk berhasil di delete!\n")

                    found = True  # Tandai bahwa produk telah ditemukan dan dihapus

                i += 1

            if not found:
                print("Produk tidak ditemukan\n")

        elif inputCommand == "search": # case input search
            
            # meminta masukkan user
            namaProduk = input("Masukkan nama produk yang ingin dicari: ")
            
            found = False
            i = 0

            # cari object dalam list 
            while i < len(daftarProduk) and not found:
                baju = daftarProduk[i]
                
                # case object ditemukan
                if baju.getNamaProduk() == namaProduk:
                    
                    baju.cariProduk(namaProduk)

                    found = True  # Tandai bahwa produk telah ditemukan dan dihapus

                i += 1

            if not found:
                print("Produk tidak ditemukan\n")

        # exit loop
        elif inputCommand == "Exit":
            
            running = False # running false/off

# panggil main func
if __name__ == "__main__":
    main()
