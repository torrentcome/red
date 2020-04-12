package torrentcome.myred.db

import androidx.room.*

@Dao
interface AudioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(audio: List<AudioEntity>): List<Long>

    @Query("SELECT * FROM AudioEntity")
    fun get(): MutableList<AudioEntity>

    @Update
    fun update(audio: AudioEntity)

    @Delete
    fun delete(audio: AudioEntity)

    @Query("DELETE FROM AudioEntity")
    fun deleteAll()
}