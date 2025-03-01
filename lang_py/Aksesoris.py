from Petshop import Petshop

class Aksesoris(Petshop):
# membuat class Aksesoris sebagai anak dari class Petshop

    def __init__(self, idProduk, namaProduk, hargaProduk, stokProduk, jenisAksesoris, bahanAksesoris, warnaAksesoris):
        # konstruktor
        super().__init__(idProduk, namaProduk, hargaProduk, stokProduk)
        self.jenisAksesoris = jenisAksesoris
        self.bahanAksesoris = bahanAksesoris
        self.warnaAksesoris = warnaAksesoris

    def setJenisAksesoris(self, jenisAksesoris):
        # mengeset jenisAksesoris
        self.jenisAksesoris = jenisAksesoris

    def getJenisAksesoris(self):
        # mengembalikan jenisAksesoris
        return self.jenisAksesoris

    def setBahanAksesoris(self, bahanAksesoris):
        # mengeset bahanAksesoris
        self.bahanAksesoris = bahanAksesoris

    def getBahanAksesoris(self):
        # mengembalikan bahanAksesoris
        return self.bahanAksesoris
    
    def setWarnaAksesoris(self, warnaAksesoris):
        # mengeset warnaAksesoris
        self.warnaAksesoris = warnaAksesoris

    def getWarnaAksesoris(self):
        # mengembalikan warnaAksesoris
        return self.warnaAksesoris