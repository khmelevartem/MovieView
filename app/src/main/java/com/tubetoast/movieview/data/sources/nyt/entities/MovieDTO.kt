package com.tubetoast.movieview.data.sources.nyt.entities

data class MovieDTO(
    val display_title: String,
    val summary_short: String,
    val multimedia: Multimedia? = null,

    ) {
    data class Multimedia(
        val src: String,
        val height: Int,
        val width: Int,
    )
}
