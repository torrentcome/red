package torrentcome.myred.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import torrentcome.myred.db.AudioEntity
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

    val playlist = MutableLiveData<List<AudioEntity>>()
    fun saveData(audio: List<AudioEntity>) = scope.launch(context = Dispatchers.Default, block = { saveUseCase.saveItem(audio) })
    fun getData() = scope.launch(context = Dispatchers.Default, block = { playlist.postValue(getUseCase.getItems()) })
}