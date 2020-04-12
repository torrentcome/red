package torrentcome.myred.db

class SaveUseCase(private val audioRepo: AudioRepo) {
    suspend fun saveItem(audio: List<Audio>): List<Long> = audioRepo.save(audio)
}

class GetUseCase(private val audioRepo: AudioRepo) {
    suspend fun getItems(): List<Audio>? = audioRepo.get()
}