from Aksesoris import Aksesoris

class Baju(Aksesoris):
# membuat class baju sebagai anak dari class Aksesoris

    def __init__(self, idProduk, namaProduk, hargaProduk, stokProduk, jenisAksesoris, bahanAksesoris, warnaAksesoris, untukBaju, sizeBaju, merkBaju):
        # konstruktor
        super().__init__(idProduk, namaProduk, hargaProduk, stokProduk, jenisAksesoris, bahanAksesoris, warnaAksesoris)
        self.untukBaju = untukBaju
        self.sizeBaju = sizeBaju
        self.merkBaju = merkBaju

    def setUntukBaju(self, untukBaju):
        # mengeset nilai atribut untukBaju
        self.untukBaju = untukBaju

    def getUntukBaju(self):
        # mengembalikan nilai atribut untukBaju
        return self.untukBaju
    
    def setSizeBaju(self, sizeBaju):
        # mengeset nilai atribut sizeBaju
        self.sizeBaju = sizeBaju

    def getSizeBaju(self):
        # mengembalikan nilai atribut sizeBaju
        return self.sizeBaju
    
    def setMerkBaju(self, merkBaju):
        # mengeset nilai atribut merkBaju
        self.merkBaju = merkBaju

    def getMerkBaju(self):
        # mengembalikan nilai atribut merkBaju
        return self.merkBaju
    
    # method untuk menampilkan detail produk
    def tampilkanProduk(self, daftarProduk):
        headers = [
            "ID Produk", "Nama Produk", "Harga", "Stok", "Jenis Aksesoris", 
            "Bahan Aksesoris", "Warna Aksesoris", "Untuk Baju", "Size", "Merk"
        ]
        
        data_rows = [
            [
                str(baju.getIdProduk()), str(baju.getNamaProduk()), str(baju.getHargaProduk()), 
                str(baju.getStokProduk()), str(baju.getJenisAksesoris()), str(baju.getBahanAksesoris()), 
                str(baju.getWarnaAksesoris()), str(baju.getUntukBaju()), str(baju.getSizeBaju()), 
                str(baju.getMerkBaju())
            ] 
            for baju in daftarProduk
        ]
        
        column_widths = [max(len(header), max(len(row[i]) for row in data_rows)) for i, header in enumerate(headers)]
        
        def print_row(row):
            print(" | ".join(val.ljust(width) for val, width in zip(row, column_widths)))
        
        print("-" * (sum(column_widths) + len(column_widths) * 3 - 3))
        print_row(headers)
        print("-" * (sum(column_widths) + len(column_widths) * 3 - 3))
        
        for row in data_rows:
            print_row(row)
        
        print("-" * (sum(column_widths) + len(column_widths) * 3 - 3))

    # method untuk mengupdate produk
    def updateProduk(self, idProdukBaru, namaProdukBaru, hargaProdukBaru, stokProdukBaru, jenisAksesorisBaru, bahanAksesorisBaru, warnaAksesorisBaru, untukBajuBaru, sizeBajuBaru, merkBajuBaru):
        self.setIdProduk(idProdukBaru)
        self.setNamaProduk(namaProdukBaru)
        self.setHargaProduk(hargaProdukBaru)
        self.setStokProduk(stokProdukBaru)
        self.setJenisAksesoris(jenisAksesorisBaru)
        self.setBahanAksesoris(bahanAksesorisBaru)
        self.setWarnaAksesoris(warnaAksesorisBaru)
        self.setUntukBaju(untukBajuBaru)
        self.setSizeBaju(sizeBajuBaru)
        self.setMerkBaju(merkBajuBaru)
    
    # method untuk menghapus produk
    def hapusProduk(baju, daftarProduk):
        baju.setIdProduk(None)
        baju.setNamaProduk(None)
        baju.setHargaProduk(None)
        baju.setStokProduk(None)
        baju.setJenisAksesoris(None)
        baju.setBahanAksesoris(None)
        baju.setWarnaAksesoris(None)
        baju.setUntukBaju(None)
        baju.setSizeBaju(None)
        baju.setMerkBaju(None)

        daftarProduk.remove(baju)

    # method untuk mencari produk berdasarkan nama
    def cariProduk(self, namaProduk):
        if self.getNamaProduk() == namaProduk:
            print("Detail Produk:")
            print("| ID Produk: ", self.getIdProduk())
            print("| Nama Produk: ", self.getNamaProduk())
            print("| Harga: ", self.getHargaProduk())
            print("| Stok: ", self.getStokProduk())
            print("| Jenis Aksesoris: ", self.getJenisAksesoris())
            print("| Bahan Aksesoris: ", self.getBahanAksesoris())
            print("| Warna Aksesoris: ", self.getWarnaAksesoris())
            print("| Peruntukan Baju: ", self.getUntukBaju())
            print("| Size: ", self.getSizeBaju())
            print("| Merk: ", self.getMerkBaju())
        else:
            print("Produk", namaProduk, "tidak ditemukan.")