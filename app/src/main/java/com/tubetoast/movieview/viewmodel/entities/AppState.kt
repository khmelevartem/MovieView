package com.tubetoast.movieview.viewmodel.entities

sealed class AppState {
    object Loading : AppState()
    object Success : AppState()
    data class Error(val throwable: Throwable) : AppState()
}
