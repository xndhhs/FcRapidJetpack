package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class FirstTeamContract {
    sealed class Event : ViewEvent {
        data object OnPlayerDetails : Event()
        data object OnStaffDetails : Event()

    }

    data class State(
        val playersList: Map<PlayerRoles,List<PlayerModel>>,
        val staffList: List<String>,
        val selectedTab: Int
    ) : ViewState


    enum class PlayerRoles{
        PORTARI,
        FUNDASI,
        MIJLOCASI,
        ATACANTI
    }
    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data object ToPlayerDetails : Navigation()
            data object ToStaffDetails : Navigation()
        }
    }
}