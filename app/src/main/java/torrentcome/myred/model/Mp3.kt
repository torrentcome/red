package torrentcome.myred.model

class Mp3(
        var songId: Int = 0,
        var name: String? = "",
        var downloadPath: String? = "") {

    var isPlay = false
    var totalDuration: Long = 0
    var currentPosition: Long = 0
    var playingPercent = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Mp3
        if (songId != other.songId) return false
        if (name != other.name) return false
        if (downloadPath != other.downloadPath) return false

        return true
    }

    override fun hashCode(): Int {
        var result = songId
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (downloadPath?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Mp3(songId=$songId, name=$name, downloadPath=$downloadPath, isPlay=$isPlay, totalDuration=$totalDuration, currentPosition=$currentPosition, playingPercent=$playingPercent)"
    }

    private fun calculatePercentPlay(): Int {
        return if (currentPosition == 0L || totalDuration == 0L) 0 else (currentPosition * 100 / totalDuration).toInt()
    }
}