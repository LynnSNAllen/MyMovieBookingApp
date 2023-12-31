package com.lynnpadc.moviebookingapp.network.responses.movie

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.movie.MovieVO

data class MovieDetailResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: MovieVO?,
)
