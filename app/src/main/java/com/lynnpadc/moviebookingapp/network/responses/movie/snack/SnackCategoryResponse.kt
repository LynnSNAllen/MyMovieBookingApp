package com.lynnpadc.moviebookingapp.network.responses.movie.snack

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackCategoryVO

data class SnackCategoryResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<SnackCategoryVO>?
)
