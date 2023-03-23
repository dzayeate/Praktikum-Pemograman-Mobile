package id.ac.unpas.jumlahkekayaan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class JumlahKekayaan(
    @PrimaryKey val id: String,
    val tanggal: String,
    val nama: String,
    val nama_barang: String,
    val harga: String
)
