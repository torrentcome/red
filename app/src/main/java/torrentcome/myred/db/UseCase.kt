package torrentcome.myred.db

class SaveUseCase(private val audioRepo: AudioRepo) {
    fun saveItem(audio : Audio) : Long = audioRepo.save(audio)
}

class GetUseCase(private val audioRepo: AudioRepo) {
    fun getItem() : List<Audio>? = audioRepo.get()
}