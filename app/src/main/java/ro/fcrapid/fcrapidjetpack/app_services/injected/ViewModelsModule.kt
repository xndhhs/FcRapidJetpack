package ro.fcrapid.fcrapidjetpack.app_services.injected

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardViewModel

val viewModelsModule = module {
    viewModel {
        DashboardViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }
}