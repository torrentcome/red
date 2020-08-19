package torrentcome.myred.domain

import torrentcome.myred.data.db.AudioEntity

class SaveUseCase(private val audioRepo: AudioRepo) {
    suspend fun saveItem(audio: List<AudioEntity>): List<Long> = audioRepo.save(audio)
}

class GetUseCase(private val audioRepo: AudioRepo) {
    suspend fun getItems(): List<AudioEntity>? = audioRepo.get()
}
