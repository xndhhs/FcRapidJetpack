package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.models.StaffModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class FirstTeamContract {
    sealed class Event : ViewEvent {
        data object OnPlayerDetails : Event()
        data object OnStaffDetails : Event()

        data class OnHeaderTabSelected(val tabHeader: TabHeaders) : Event()

    }

    data class State(
        val playersList: Map<PlayerRoles,List<PlayerModel>>,
        val staffList: Map<StaffRoles, List<StaffModel>>,
        val tabHeaders: List<TabHeaders>,
        val selectedTab: Int
    ) : ViewState

    enum class TabHeaders(val label: String) {
        JUCATORI("Jucatori"),
        STAFF("Staff")
    }

    enum class PlayerRoles{
        PORTARI,
        FUNDASI,
        MIJLOCASI,
        ATACANTI
    }

    enum class StaffRoles {
        ANTRENOR_PRINCIPAL,
        ANTRENORI_SECUNZI,
        STAFF_MEDICAL,
        STAFF_ADMINISTRATIV
    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data object ToPlayerDetails : Navigation()
            data object ToStaffDetails : Navigation()
        }
    }
}