package torrentcome.myred.di

import android.content.Context
import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import torrentcome.myred.data.AudioRepoImpl
import torrentcome.myred.data.db.*
import torrentcome.myred.domain.AudioRepo
import torrentcome.myred.domain.GetUseCase
import torrentcome.myred.domain.SaveUseCase
import torrentcome.myred.ui.AudioViewModel

/**
 *
 * db & dao & repo
 */
val dbModule = module {
    single { createDb(get()) }
    single { createDao(get()) }
    single { createRepo(get()) }
}

fun createDb(context: Context): Db =
        Room.databaseBuilder(context, Db::class.java, Db.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()

fun createDao(db: Db) = db.audioDao
fun createRepo(audioDao: AudioDao): AudioRepo = AudioRepoImpl(audioDao)

/**
 *
 * view model
 */
val vmModule = module {
    viewModel { AudioViewModel(get(), get()) }

    single { createSaveUseCase(get()) }
    single { createGetUseCase(get()) }
}

/**
 *
 * use case
 */
fun createSaveUseCase(audioRepo: AudioRepo): SaveUseCase = SaveUseCase(audioRepo)
fun createGetUseCase(audioRepo: AudioRepo): GetUseCase = GetUseCase(audioRepo)