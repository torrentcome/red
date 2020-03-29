package torrentcome.myred.db

// domain
interface AudioRepo {
    fun save(audio: Audio): Long
    fun get(): List<Audio>?
    fun delete(audio: Audio)
}

// impl
class AudioRepoImpl(private val audioDao: AudioDao) : AudioRepo {
    override fun save(audio: Audio): Long = audioDao.insert(audio)
    override fun get(): List<Audio>? = audioDao.get()
    override fun delete(audio: Audio) = audioDao.delete(audio)
}