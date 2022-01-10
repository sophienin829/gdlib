package com.vetalitet.mainlib

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

internal class TestViewModel: ViewModel() {

    private val _testFlow = MutableSharedFlow<String>(replay = 0)
    val testFlow: SharedFlow<String> = _testFlow

    init {
        viewModelScope.launch {
            delay(5000)
            _testFlow.emit("Hello world (ViewModel)")
        }
    }

}
