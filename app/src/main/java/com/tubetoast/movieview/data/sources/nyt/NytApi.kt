package com.tubetoast.movieview.data.sources.nyt

import com.tubetoast.movieview.BuildConfig
import com.tubetoast.movieview.data.sources.nyt.entities.ResponseDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NytApi {

    @GET("reviews/picks.json")
    fun getMoviesAtPage(
        @Query("offset") offset: Int = 0,
        @Query("api-key") key: String = BuildConfig.NYT_KEY
    ): Observable<ResponseDTO>

}