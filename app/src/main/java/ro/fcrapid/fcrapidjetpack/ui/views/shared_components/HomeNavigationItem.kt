package ro.fcrapid.fcrapidjetpack.ui.views.shared_components

open class HomeNavigationItem(
    @Transient open val route: String,
    @Transient open var icon: String = "",
    @Transient open var title: String = ""
) {
    data class News(
        override val route: String,
        override var icon: String = "",
        override var title: String = ""
    ) : HomeNavigationItem(route, icon, title)

    data class Fixtures(
        override val route: String,
        override var icon: String = "",
        override var title: String = ""
    ) : HomeNavigationItem(route, icon, title)

    data class FirstTeam(
        override val route: String,
        override var icon: String = "",
        override var title: String = ""
    ) : HomeNavigationItem(route, icon, title)

    data class Profile(
        override val route: String,
        override var icon: String = "",
        override var title: String = ""
    ) : HomeNavigationItem(route, icon, title)
}