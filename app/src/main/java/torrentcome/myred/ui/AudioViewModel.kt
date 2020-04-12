package torrentcome.myred.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import torrentcome.myred.db.Audio
import torrentcome.myred.db.GetUseCase
import torrentcome.myred.db.SaveUseCase

class AudioViewModel(
        private val saveUseCase: SaveUseCase,
        private val getUseCase: GetUseCase
) : ViewModel() {
    private val scope = CoroutineScope(Job() + Dispatchers.Main)
    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

    val playlist = MutableLiveData<List<Audio>>()
    fun saveData(audio: List<Audio>) = scope.launch(context = Dispatchers.Default, block = { saveUseCase.saveItem(audio) })
    fun getData() = scope.launch(context = Dispatchers.Default, block = { playlist.postValue(getUseCase.getItems()) })
}