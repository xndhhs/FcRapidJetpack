package ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout

import kotlinx.coroutines.flow.Flow

interface AppBackgroundEventHandler {
    fun startAppActivityTimeoutTimer()
    fun resetTimeoutTimer()
    fun stopTimeoutTimer()
    fun listenForInactiveTimeout(): Flow<InactivityEvent>
    suspend fun startFeedbackDialogTimer()

    sealed class InactivityEvent {
        data object TimeTrackingStarted: InactivityEvent()
        data object TimeoutShowWarning: InactivityEvent()
        data object TimeoutLogout: InactivityEvent()
        data object TimeoutForceLogout: InactivityEvent()
        data object StartFeedbackDialogTimer: InactivityEvent()
    }
}