package torrentcome.myred.domain

import torrentcome.myred.data.db.AudioEntity

// domain
interface AudioRepo {
    suspend fun save(audio: List<AudioEntity>): List<Long>
    suspend fun get(): List<AudioEntity>?
    suspend fun delete(audio: AudioEntity)
}