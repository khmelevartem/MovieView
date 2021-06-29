package com.tubetoast.movieview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tubetoast.movieview.viewmodel.entities.AppState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

abstract class AbstractViewModel: ViewModel(){

    val disposable = CompositeDisposable()

    private val appState = MutableLiveData<AppState>()

    val onLoad = Consumer<Any?>{ appState.postValue(AppState.Loading) }
    val onSuccess = Action{ appState.postValue(AppState.Success) }
    val onError = Consumer<Throwable>{ appState.postValue(AppState.Error(it)) }

    fun getAppState() : LiveData<AppState> {
        return appState
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
    
}
