package com.tubetoast.movieview.data.repositories

import com.tubetoast.movieview.entities.Movie
import com.tubetoast.movieview.viewmodel.repository.Repository
import io.reactivex.Observable

class RepositoryImpl (
    private val source: DataSource
): Repository {

    private var page = 0

    override fun getMovies() : Observable<List<Movie>>{
        return source.getMovies(page).doAfterNext { page++ }
    }
}