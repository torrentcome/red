package torrentcome.myred.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Audio::class], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {

    abstract val audioDao: AudioDao

    companion object {
        const val DB_NAME = "myred.db"
    }
}