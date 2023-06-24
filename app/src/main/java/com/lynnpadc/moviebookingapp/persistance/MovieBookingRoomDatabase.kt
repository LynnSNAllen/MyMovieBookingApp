package com.lynnpadc.moviebookingapp.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lynnpadc.moviebookingapp.data.vos.cinema.CinemaInfoVO
import com.lynnpadc.moviebookingapp.data.vos.login.CitiesVO
import com.lynnpadc.moviebookingapp.data.vos.movie.BannerVO
import com.lynnpadc.moviebookingapp.data.vos.movie.MovieVO
import com.lynnpadc.moviebookingapp.data.vos.movie.cinema_showtime.CinemaConfigVO
import com.lynnpadc.moviebookingapp.data.vos.ticket.TicketInformation
import com.lynnpadc.moviebookingapp.network.responses.login.OtpResponse
import com.lynnpadc.moviebookingapp.persistance.dao.MovieBookingDao

@Database(entities = [CitiesVO::class,OtpResponse::class,BannerVO::class,
MovieVO::class,CinemaConfigVO::class,CinemaInfoVO::class,TicketInformation::class],
version = 1, exportSchema = false)
abstract class MovieBookingRoomDatabase: RoomDatabase() {

    abstract fun getDao(): MovieBookingDao

    companion object {
        private var roomDB: MovieBookingRoomDatabase? = null
        private const val dbName = "MovieBookingDB"

        fun getDBInstance(context: Context): MovieBookingRoomDatabase? {
            when(roomDB){
                null -> {
                    roomDB = Room.databaseBuilder(context,MovieBookingRoomDatabase::class.java, dbName)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return roomDB
        }
    }
}