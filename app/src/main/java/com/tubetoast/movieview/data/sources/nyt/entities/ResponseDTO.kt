package com.tubetoast.movieview.data.sources.nyt.entities

data class ResponseDTO(
    val status: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<MovieDTO>,
)
