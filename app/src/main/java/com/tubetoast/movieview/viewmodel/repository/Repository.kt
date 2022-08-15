package com.tubetoast.movieview.viewmodel.repository

import com.tubetoast.movieview.entities.Movie
import io.reactivex.Observable


interface Repository {
    fun getMovies(): Observable<List<Movie>>
}