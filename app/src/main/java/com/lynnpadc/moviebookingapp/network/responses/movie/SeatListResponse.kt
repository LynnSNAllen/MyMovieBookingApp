package com.lynnpadc.moviebookingapp.network.responses.movie

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.movie.SeatVO

data class SeatListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: MutableList<MutableList<SeatVO>>?
)
