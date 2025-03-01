<?php
include "Baju.php";
session_start();

// Inisialisasi session jika belum ada
if (!isset($_SESSION['daftarProduk'])) {
    $_SESSION['daftarProduk'] = [];

    // instansiasi beberapa data yang tersedia
    $_SESSION['daftarProduk'][] = new Baju("IKR110", "KaosLucu_Kucing", 45000, 13, "uploads/bajuKucing1.jpeg" ,"Pakaian", "Sutra", "Merah-Maroon", "Kucing", 11, "Uniqlo");
    $_SESSION['daftarProduk'][] = new Baju("IKR120", "KemejaLucu_Kucing", 65000, 6, "uploads/bajuKucing2.jpeg", "Pakaian", "Katun", "Hijau-Tua", "Kucing", 13, "Rucas");
    $_SESSION['daftarProduk'][] = new Baju("IKR130", "KaosLucu_Anjing", 55000, 9, "uploads/bajuAnjing1.jpeg", "Pakaian", "Sutra", "Biru-Donker", "Anjing", 15, "Uniqlo");
    $_SESSION['daftarProduk'][] = new Baju("IKR140", "KemejaLucu_Anjing", 85000, 4, "uploads/bajuAnjing2.jpeg", "Pakaian", "Katun", "Hijau-Emas", "Anjing", 17, "Rucas");
    $_SESSION['daftarProduk'][] = new Baju("IKR150", "Sarung_Kadal", 35000, 3, "uploads/bajuKadal1.jpeg", "Pakaian", "Sutra", "Biru", "Kadal", 15, "Wadimor");

}

// Handle form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $action = $_POST['action'] ?? '';

    switch ($action) {
        case 'add':
            $idProduk = htmlspecialchars($_POST['idProduk']);
            $namaProduk = htmlspecialchars($_POST['namaProduk']);
            $hargaProduk = (int)$_POST['hargaProduk'];
            $stokProduk = (int)$_POST['stokProduk'];
            $gambarProduk = '';
            $jenisAksesoris = htmlspecialchars($_POST['jenisAksesoris']);
            $bahanAksesoris = htmlspecialchars($_POST['bahanAksesoris']);
            $warnaAksesoris = htmlspecialchars($_POST['warnaAksesoris']);
            $untukBaju = htmlspecialchars($_POST['untukBaju']);
            $sizeBaju = (int)$_POST['sizeBaju'];
            $merkBaju = htmlspecialchars($_POST['merkBaju']);

            // Cek ID duplikat
            $idExists = false;
            foreach ($_SESSION['daftarProduk'] as $produk) {
                if ($produk->getIdProduk() === $idProduk) {
                    $idExists = true;
                    break;
                }
            }

            if (!$idExists) {
                // Handle file upload
                if (!empty($_FILES['gambar']['name'])) {
                    $targetDir = "uploads/";
                    if (!file_exists($targetDir)) {
                        mkdir($targetDir, 0777, true);
                    }
                    $gambarProduk = $targetDir . uniqid() . "_" . basename($_FILES['gambar']['name']);
                    move_uploaded_file($_FILES['gambar']['tmp_name'], $gambarProduk);
                }

                // Tambahkan produk baru
                $_SESSION['daftarProduk'][] = new Baju(
                    $idProduk,
                    $namaProduk,
                    $hargaProduk,
                    $stokProduk,
                    $gambarProduk,
                    $jenisAksesoris,
                    $bahanAksesoris,
                    $warnaAksesoris,
                    $untukBaju,
                    $sizeBaju,
                    $merkBaju
                );
            }
            break;

        case 'update':
            $idProduk = $_POST['idProduk'];
            foreach ($_SESSION['daftarProduk'] as &$produk) {
                if ($produk->getIdProduk() === $idProduk) {
                    // Update data
                    $produk->setNamaProduk($_POST['namaProduk']);
                    $produk->setHargaProduk($_POST['hargaProduk']);
                    $produk->setStokProduk($_POST['stokProduk']);
                    $produk->setJenisAksesoris($_POST['jenisAksesoris']);
                    $produk->setBahanAksesoris($_POST['bahanAksesoris']);
                    $produk->setWarnaAksesoris($_POST['warnaAksesoris']);
                    $produk->setUntukBaju($_POST['untukBaju']);
                    $produk->setSizeBaju($_POST['sizeBaju']);
                    $produk->setMerkBaju($_POST['merkBaju']);

                    // Handle file upload baru
                    if (!empty($_FILES['gambar']['name'])) {
                        // Hapus gambar lama jika ada
                        if ($produk->getGambarProduk() && file_exists($produk->getGambarProduk())) {
                            unlink($produk->getGambarProduk());
                        }
                        
                        // Upload gambar baru
                        $targetDir = "uploads/";
                        $gambarProduk = $targetDir . uniqid() . "_" . basename($_FILES['gambar']['name']);
                        move_uploaded_file($_FILES['gambar']['tmp_name'], $gambarProduk);
                        $produk->setGambarProduk($gambarProduk);
                    }
                    break;
                }
            }
            break;

        case 'delete':
            $idProduk = $_POST['idProduk'];
            foreach ($_SESSION['daftarProduk'] as $key => $produk) {
                if ($produk->getIdProduk() === $idProduk) {
                    // Hapus gambar jika ada
                    if ($produk->getGambarProduk() && file_exists($produk->getGambarProduk())) {
                        unlink($produk->getGambarProduk());
                    }
                    // Hapus dari array dan re-index
                    unset($_SESSION['daftarProduk'][$key]);
                    $_SESSION['daftarProduk'] = array_values($_SESSION['daftarProduk']);
                    break;
                }
            }
            break;
    }

    header("Location: Main.php");
    exit;
}

// Handle edit request
$editProduk = null;
if (isset($_GET['edit'])) {
    $editId = $_GET['edit'];
    foreach ($_SESSION['daftarProduk'] as $produk) {
        if ($produk->getIdProduk() === $editId) {
            $editProduk = $produk;
            break;
        }
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Petshop Data Manager</title>
    <style>
        /* Styling tabel */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 2px solid black; /* Garis pembatas tebal */
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        img {
            border-radius: 5px;
            max-width: 100px;
        }
        form {
            margin: 0;
        }
        button {
            background-color: red;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: darkred;
        }
        a {
            text-decoration: none;
            color: blue;
            margin-right: 10px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Petshop Data Manager</h1>

    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <input type="hidden" name="action" value="<?= $editProduk ? 'update' : 'add' ?>">
            <?php if ($editProduk): ?>
                <input type="hidden" name="idProduk" value="<?= htmlspecialchars($editProduk->getIdProduk()) ?>">
            <?php else: ?>
                <label>ID Produk:</label>
                <input type="text" name="idProduk" value="<?= htmlspecialchars($editProduk ? $editProduk->getIdProduk() : '') ?>" required>
            <?php endif; ?>

            <label>Name Produk:</label>
            <input type="text" name="namaProduk" value="<?= htmlspecialchars($editProduk ? $editProduk->getNamaProduk() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Harga Produk:</label>
            <input type="number" name="hargaProduk" min="0" step="1000" value="<?= htmlspecialchars($editProduk ? $editProduk->getHargaProduk() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Stok Produk:</label>
            <input type="number" name="stokProduk" min="0" step="1" value="<?= htmlspecialchars($editProduk ? $editProduk->getStokProduk() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Upload Image:</label>
            <input type="file" name="gambar" accept="image/*">
            <?php if ($editProduk && $editProduk->getGambarProduk()): ?>
                <p>Current Image:</p>
                <img src="<?= htmlspecialchars($editProduk->getGambarProduk()) ?>" width="100">
            <?php endif; ?>
        </div>

        <div class="form-group">
            <label>Jenis Aksesoris:</label>
            <input type="text" name="jenisAksesoris" value="<?= htmlspecialchars($editProduk ? $editProduk->getJenisAksesoris() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Bahan Aksesoris:</label>
            <input type="text" name="bahanAksesoris" value="<?= htmlspecialchars($editProduk ? $editProduk->getBahanAksesoris() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Warna Aksesoris:</label>
            <input type="text" name="warnaAksesoris" value="<?= htmlspecialchars($editProduk ? $editProduk->getWarnaAksesoris() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Peruntukan Baju:</label>
            <input type="text" name="untukBaju" value="<?= htmlspecialchars($editProduk ? $editProduk->getUntukBaju() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Size Baju:</label>
            <input type="number" name="sizeBaju" min="0" step="1" value="<?= htmlspecialchars($editProduk ? $editProduk->getSizeBaju() : '') ?>" required>
        </div>

        <div class="form-group">
            <label>Merk Baju:</label>
            <input type="text" name="merkBaju" value="<?= htmlspecialchars($editProduk ? $editProduk->getMerkBaju() : '') ?>" required>
        </div>

        <button type="submit"><?= $editProduk ? 'Update' : 'Add' ?></button>
        <?php if ($editProduk): ?>
            <a href="Main.php">Cancel</a>
        <?php endif; ?>
    </form>

    <!-- Tabel Data -->
    <?php if (!empty($_SESSION['daftarProduk'])): ?>
        <table>
            <tr>
                <th>No</th>
                <th>ID</th>
                <th>Image</th>
                <th>Name</th>
                <th>Stok</th>
                <th>Harga</th>
                <th>Jenis Aksesoris</th>
                <th>Bahan Aksesoris</th>
                <th>Warna Aksesoris</th>
                <th>Peruntukan Baju</th>
                <th>Size Baju</th>
                <th>Merk Baju</th>
                <th>Actions</th>
            </tr>
            <?php $counter = 1; ?>
            <?php foreach ($_SESSION['daftarProduk'] as $produk): ?>
                <tr>
                    <td><?= $counter++ ?></td>
                    <td><?= htmlspecialchars($produk->getIdProduk()) ?></td>
                    <td>
                        <?php if ($produk->getGambarProduk()): ?>
                            <img src="<?= htmlspecialchars($produk->getGambarProduk()) ?>" width="100">
                        <?php else: ?>
                            No Image
                        <?php endif; ?>
                    </td>
                    <td><?= htmlspecialchars($produk->getNamaProduk()) ?></td>
                    <td><?= number_format($produk->getStokProduk()) ?></td>
                    <td><?= number_format($produk->getHargaProduk(), 0, ',', '.') ?></td>
                    <td><?= htmlspecialchars($produk->getJenisAksesoris()) ?></td>
                    <td><?= htmlspecialchars($produk->getBahanAksesoris()) ?></td>
                    <td><?= htmlspecialchars($produk->getWarnaAksesoris()) ?></td>
                    <td><?= htmlspecialchars($produk->getUntukBaju()) ?></td>
                    <td><?= number_format($produk->getSizeBaju()) ?></td>
                    <td><?= htmlspecialchars($produk->getMerkBaju()) ?></td>
                    <td>
                        <a href="Main.php?edit=<?= htmlspecialchars($produk->getIdProduk()) ?>">Edit</a>
                        <form method="post" style="display: inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="idProduk" value="<?= htmlspecialchars($produk->getIdProduk()) ?>">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </table>
    <?php else: ?>
        <p>No records found.</p>
    <?php endif; ?>
</body>
</html>