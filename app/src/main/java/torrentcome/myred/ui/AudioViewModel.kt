package torrentcome.myred.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import torrentcome.myred.db.Audio
import torrentcome.myred.db.GetUseCase
import torrentcome.myred.db.SaveUseCase

class AudioViewModel(
        private val saveUseCase: SaveUseCase,
        private val getUseCase: GetUseCase
) : ViewModel() {
    private val playlist = MutableLiveData<List<Audio>>()

    fun saveData(audio: Audio) = saveUseCase.saveItem(audio)

    fun getData() {
        playlist.value = getUseCase.getItems()
    }
}