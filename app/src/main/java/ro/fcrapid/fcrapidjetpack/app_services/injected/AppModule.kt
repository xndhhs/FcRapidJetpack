package ro.fcrapid.fcrapidjetpack.app_services.injected

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ro.fcrapid.fcrapidjetpack.app_services.adapters.network.RetrofitClientFactory

val apiModule = module {
    single { RetrofitClientFactory.create(context = androidContext()) }


}
val appModules = listOf(
    apiModule,
    providersModule,
    viewModelsModule
)