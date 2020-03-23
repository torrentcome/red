package torrentcome.myred

import android.app.Application
import android.os.StrictMode
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import torrentcome.myred.di.appModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        strictMode()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }

    private fun strictMode() {
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build())

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyFlashScreen()
                .build())
    }
}