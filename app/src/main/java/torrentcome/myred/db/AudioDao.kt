package torrentcome.myred.db

import androidx.room.*

@Dao
interface AudioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(audio: List<Audio>): List<Long>

    @Query("SELECT * FROM Audio")
    fun get(): MutableList<Audio>

    @Update
    fun update(audio: Audio)

    @Delete
    fun delete(audio: Audio)

    @Query("DELETE FROM Audio")
    fun deleteAll()
}