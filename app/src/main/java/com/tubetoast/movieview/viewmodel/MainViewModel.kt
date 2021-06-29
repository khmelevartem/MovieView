package com.tubetoast.movieview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tubetoast.movieview.data.repositories.RepositoryImpl
import com.tubetoast.movieview.data.sources.nyt.NytDataSource
import com.tubetoast.movieview.entities.Movie
import com.tubetoast.movieview.viewmodel.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel : AbstractViewModel() {

    /**
     * TODO:
     * A bit of hard code, use injection instead
     */
    private val repository: Repository by lazy {
        RepositoryImpl(NytDataSource())
    }

    private val movies: MutableLiveData<MutableSet<Movie>> by lazy {
        MutableLiveData<MutableSet<Movie>>().also {
            it.value = LinkedHashSet()
            loadMovies()
        }
    }

    fun getMovies(): LiveData<MutableSet<Movie>> {
        if (movies.value.isNullOrEmpty()) loadMovies()
        return movies
    }

    fun getAdditionalMovies() {
        loadMovies()
    }

    private fun loadMovies() {
        disposable.add(
            repository
                .getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        movies.value?.addAll(it)
                        movies.value = movies.value
                    },
                    onError,
                    onSuccess,
                    onLoad
                )
        )
    }


}