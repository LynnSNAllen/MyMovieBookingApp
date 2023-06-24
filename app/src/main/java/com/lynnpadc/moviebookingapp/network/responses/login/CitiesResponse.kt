package com.lynnpadc.moviebookingapp.network.responses.login

import com.google.gson.annotations.SerializedName
import com.lynnpadc.moviebookingapp.data.vos.login.CitiesVO

data class CitiesResponse(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<CitiesVO>?
)
