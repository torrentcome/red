package torrentcome.myred.ui

import androidx.lifecycle.ViewModel
import torrentcome.myred.db.GetUseCase
import torrentcome.myred.db.SaveUseCase

class AudioViewModel(
        private val saveUseCase: SaveUseCase,
        private val getUseCase: GetUseCase
) : ViewModel()