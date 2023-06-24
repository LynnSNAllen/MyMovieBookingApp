package com.lynnpadc.moviebookingapp.network.responses.movie.snack

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackVO

data class SnackListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<SnackVO>?
)
