package com.tubetoast.movieview.data.repositories

import com.tubetoast.movieview.entities.Movie
import io.reactivex.Observable

interface DataSource {
    fun getMovies(page: Int = 0): Observable<List<Movie>>
}