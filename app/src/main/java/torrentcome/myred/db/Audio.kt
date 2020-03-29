package torrentcome.myred.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Audio(
        @PrimaryKey var id: Long = -1L,
        var title: String = "",
        var path: String = "")