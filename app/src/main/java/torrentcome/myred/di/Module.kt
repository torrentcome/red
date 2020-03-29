package torrentcome.myred.di

import android.content.Context
import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import torrentcome.myred.db.*
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
fun createRepo(audioDao: AudioDao): AudioRepoImpl = AudioRepoImpl(audioDao)

/**
 *
 * view model & use case
 */
val vmModule = module {
    single { createSaveUseCase(get()) }
    single { createGetUseCase(get()) }

    viewModel {
        AudioViewModel()
    }
}

fun createSaveUseCase(audioRepo: AudioRepo): SaveUseCase = SaveUseCase(audioRepo)
fun createGetUseCase(audioRepo: AudioRepo): GetUseCase = GetUseCase(audioRepo)
