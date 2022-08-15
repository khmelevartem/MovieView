package com.tubetoast.movieview.data.sources.nyt

import com.tubetoast.movieview.data.repositories.DataSource
import com.tubetoast.movieview.entities.Movie
import io.reactivex.Observable

class NytDataSource : DataSource {

    private val api = NytService.api

    override fun getMovies(page: Int): Observable<List<Movie>> {
        return api.getMoviesAtPage(page * 20).map {
            it.results.map { dto ->
                Movie(
                    dto.display_title,
                    dto.summary_short,
                    dto.multimedia?.src
                )
            }
        }
    }
}