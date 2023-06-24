package com.lynnpadc.moviebookingapp.ui

import android.app.Application
import com.lynnpadc.moviebookingapp.data.models.MovieBookingModelImpl

class MovieBookingApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MovieBookingModelImpl.initMovieBookingDatabase(applicationContext)
    }
}