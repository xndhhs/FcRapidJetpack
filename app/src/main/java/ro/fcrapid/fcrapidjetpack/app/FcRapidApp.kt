package ro.fcrapid.fcrapidjetpack.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ro.fcrapid.fcrapidjetpack.BuildConfig
import ro.fcrapid.fcrapidjetpack.app_services.injected.appModules
import timber.log.Timber

class FcRapidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Application created!")
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@FcRapidApp)
            modules(appModules)
        }
    }

    override fun onTerminate() {
        Timber.i("Application terminated!")
        super.onTerminate()
    }
}