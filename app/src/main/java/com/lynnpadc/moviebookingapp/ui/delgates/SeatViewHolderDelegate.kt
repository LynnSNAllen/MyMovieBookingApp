package com.lynnpadc.moviebookingapp.ui.delgates

interface SeatViewHolderDelegate {
    fun onTapSeat(seatName: String,seatPrice: Int ,isAvailable:Boolean?)
}