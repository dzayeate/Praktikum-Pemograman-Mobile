package id.ac.unpas.jumlahkekayaan.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.jumlahkekayaan.model.JumlahKekayaan

@Dao
interface JumlahKekayaanDao {
    @Query("SELECT * FROM JumlahKekayaan")
    fun loadAll(): LiveData<List<JumlahKekayaan>>
    @Query("SELECT * FROM JumlahKekayaan WHERE id = :id")
    fun find(id: String): JumlahKekayaan?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: JumlahKekayaan)
    @Delete
    fun delete(item: JumlahKekayaan)
}