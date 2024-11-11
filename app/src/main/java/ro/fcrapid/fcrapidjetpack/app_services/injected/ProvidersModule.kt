package ro.fcrapid.fcrapidjetpack.app_services.injected

import org.koin.dsl.module
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandlerImpl

val providersModule = module {
    factory<AppBackgroundEventHandler> { AppBackgroundEventHandlerImpl }
}