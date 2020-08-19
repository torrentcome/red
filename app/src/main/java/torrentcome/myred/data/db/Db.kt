package torrentcome.myred.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AudioEntity::class], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {
    abstract val audioDao: AudioDao

    companion object {
        const val DB_NAME = "myred.db"
    }
}