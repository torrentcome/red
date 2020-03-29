package torrentcome.myred.db

import androidx.room.Entity

@Entity
class Audio(
        var id: Long = -1L,
        var title: String = "",
        var path: String = "")