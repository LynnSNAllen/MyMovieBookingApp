package com.lynnpadc.moviebookingapp.network.responses.movie

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.movie.checkout.CheckoutVO

data class CheckoutResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: CheckoutVO?
)
