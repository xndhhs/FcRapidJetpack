package ro.fcrapid.fcrapidjetpack.ui.views.base

import android.os.Bundle
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import timber.log.Timber

interface ViewEvent

interface ViewState

interface ViewSideEffect

const val SIDE_EFFECTS_KEY = "side-effects-key"
const val EXTRA_UI_STATE = "uiState"
const val EXTRA_UI_STATE_BUNDLE = "uiStateBundle"

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect>(
    private val savedStateHandle: SavedStateHandle,
    private val appBackgroundEventHandler: AppBackgroundEventHandler
) : ViewModel() {
    abstract fun setInitialState(): UiState
    abstract fun handleEvents(event: Event)

    private val initialState: UiState by lazy { setInitialState() }

    private val _viewState: MutableState<UiState> by lazy { mutableStateOf(initialState) }
    val viewState: State<UiState> by lazy { _viewState }

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        restoreUiState()
        subscribeToEvents()
    }

    private fun restoreUiState() {
        val bundle = savedStateHandle.get<Bundle>(EXTRA_UI_STATE_BUNDLE)
        bundle?.let {
            val viewState = Gson().fromJson(bundle.getString(EXTRA_UI_STATE, ""), viewState.value.javaClass)
            viewState?.let { setState {it} }
            Timber.i("onRestoreViewState = $viewState")
        }

        savedStateHandle.setSavedStateProvider(EXTRA_UI_STATE_BUNDLE) {
            Timber.i("onSaveViewState = ${viewState.value}")
            Bundle().apply{ putString(EXTRA_UI_STATE, Gson().toJson(viewState.value)) }
        }
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            _event.collect {
                appBackgroundEventHandler.resetTimeoutTimer()
                handleEvents(it)
            }
        }
    }

    fun setEvent(event: Event) { viewModelScope.launch { _event.emit(event) } }

    fun setState(reducer: UiState.() -> UiState) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    protected fun setSwitchState(reducer: UiState.() -> UiState) { setState(reducer) }

    protected fun setEffect(builder: () -> Effect) { viewModelScope.launch { _effect.send(builder()) } }
}