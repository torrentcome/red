package torrentcome.myred.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AudioEntity(
        @PrimaryKey var id: Long = -1L,
        var title: String = "",
        var path: String = "") {
    var isPlay = false
    var totalDuration: Long = 0
    var currentPosition: Long = 0
    var playingPercent = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AudioEntity
        if (id != other.id) return false
        if (title != other.title) return false
        if (path != other.path) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (title.hashCode())
        result = 31 * result + (path.hashCode())
        return result.toInt()
    }

    override fun toString(): String {
        return "Mp3(id=$id, title=$title, path=$path, isPlay=$isPlay, totalDuration=$totalDuration, currentPosition=$currentPosition, playingPercent=$playingPercent)"
    }
}