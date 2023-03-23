package id.ac.unpas.jumlahkekayaan.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.jumlahkekayaan.model.JumlahKekayaan

@Database(entities = [JumlahKekayaan::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jumlahKekayaanDao(): JumlahKekayaanDao
}