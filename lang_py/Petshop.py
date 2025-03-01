class Petshop:
# membuat kelas petshop

    def __init__(self, idProduk, namaProduk, hargaProduk, stokProduk):
        # konstruktor
        self.idProduk = idProduk
        self.namaProduk = namaProduk
        self.hargaProduk = hargaProduk
        self.stokProduk = stokProduk

    def setIdProduk(self, idProduk):
        # mengeset id produk
        self.idProduk = idProduk

    def getIdProduk(self):
        # mengembalikan id produk
        return self.idProduk
    
    def setNamaProduk(self, namaProduk):
        # mengeset nama produk
        self.namaProduk = namaProduk

    def getNamaProduk(self):
        # mengembalikan nama produk
        return self.namaProduk
        
    def setHargaProduk(self, hargaProduk):
        # mengeset harga produk
        self.hargaProduk = hargaProduk

    def getHargaProduk(self):
        # mengembalikan harga produk
        return self.hargaProduk
    
    def setStokProduk(self, stokProduk):
        # mengeset stok produk
        self.stokProduk = stokProduk

    def getStokProduk(self):
        # mengembalikan stok produk
        return self.stokProduk