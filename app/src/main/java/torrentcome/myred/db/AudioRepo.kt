package torrentcome.myred.db

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// domain
interface AudioRepo {
    suspend fun save(audio: List<AudioEntity>): List<Long>
    suspend fun get(): List<AudioEntity>?
    suspend fun delete(audio: AudioEntity)
}

// impl
class AudioRepoImpl(private val audioDao: AudioDao) : AudioRepo, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override suspend fun save(audio: List<AudioEntity>): List<Long> = withContext(Dispatchers.IO) { audioDao.insert(audio) }
    override suspend fun get(): List<AudioEntity>? = withContext(Dispatchers.IO) { audioDao.get() }
    override suspend fun delete(audio: AudioEntity) = withContext(Dispatchers.IO) { audioDao.delete(audio) }
}