package ro.fcrapid.fcrapidjetpack.app_services.injected

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileViewModel

val viewModelsModule = module {
    viewModel {
        DashboardViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }

    viewModel {
        NewsViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }

    viewModel {
        FixturesViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }

    viewModel {
        ProfileViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }

    viewModel {
        FirstTeamViewModel(
            savedStateHandle =get(),
            appBackgroundEventHandler = get ()
        )
    }
}