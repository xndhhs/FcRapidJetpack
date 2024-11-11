package ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ro.fcrapid.fcrapidjetpack.common.Constants.FORCE_LOGOUT_TIMER
import ro.fcrapid.fcrapidjetpack.common.Constants.INACTIVE_LOGOUT_MINUTES
import ro.fcrapid.fcrapidjetpack.common.Constants.INACTIVE_WARNING_TIMEOUT_MINUTES
import ro.fcrapid.fcrapidjetpack.common.Constants.MILLISECONDS_PER_SECOND
import ro.fcrapid.fcrapidjetpack.common.Constants.SECONDS_PER_MINUTE
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler.InactivityEvent
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler.InactivityEvent.*

object AppBackgroundEventHandlerImpl : AppBackgroundEventHandler {
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    private var isTimerStarted: Boolean = false

    private val inactiveEventFlow = MutableSharedFlow<InactivityEvent>()
    private val appInactiveFlow = inactiveEventFlow.asSharedFlow()

    private var timeoutJob: Job? = null
    private var currentTick: Long = 0

    private fun startTimer() {
        timeoutJob?.cancel()
        currentTick = 0
        isTimerStarted = false
        timeoutJob = CoroutineScope(dispatcher).launch {
            inactiveEventFlow.emit(TimeTrackingStarted)
            repeat((MILLISECONDS_PER_SECOND * SECONDS_PER_MINUTE).toInt()) {
                delay(MILLISECONDS_PER_SECOND * SECONDS_PER_MINUTE)
                currentTick += 1
                when (currentTick) {
                    INACTIVE_WARNING_TIMEOUT_MINUTES -> { inactiveEventFlow.emit(TimeoutShowWarning) }
                    INACTIVE_LOGOUT_MINUTES -> { inactiveEventFlow.emit(TimeoutLogout) }
                    else -> {
                        if (currentTick > FORCE_LOGOUT_TIMER) {
                            inactiveEventFlow.emit(TimeoutForceLogout)
                        }
                    }
                }
            }
        }
    }

    private fun cancelTimer() {
        timeoutJob?.cancel()
        timeoutJob = null
        currentTick = 0
        isTimerStarted = false
    }

    override fun listenForInactiveTimeout(): Flow<InactivityEvent> =
        appInactiveFlow

    override suspend fun startFeedbackDialogTimer() {
        inactiveEventFlow.emit(StartFeedbackDialogTimer)
    }

    override fun startAppActivityTimeoutTimer() {
        startTimer()
    }

    override fun stopTimeoutTimer() {
        cancelTimer()
    }

    override fun resetTimeoutTimer() {
        if (isTimerStarted) {
            cancelTimer()
            startTimer()
        }
    }
}