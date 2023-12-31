package com.lynnpadc.moviebookingapp.data.models

import com.lynnpadc.moviebookingapp.data.vos.cinema.CinemaInfoVO
import com.lynnpadc.moviebookingapp.data.vos.login.CitiesVO
import com.lynnpadc.moviebookingapp.data.vos.movie.BannerVO
import com.lynnpadc.moviebookingapp.data.vos.movie.MovieVO
import com.lynnpadc.moviebookingapp.data.vos.movie.PaymentVO
import com.lynnpadc.moviebookingapp.data.vos.movie.SeatVO
import com.lynnpadc.moviebookingapp.data.vos.movie.checkout.CheckoutBody
import com.lynnpadc.moviebookingapp.data.vos.movie.checkout.CheckoutVO
import com.lynnpadc.moviebookingapp.data.vos.movie.cinema_showtime.CinemaConfigVO
import com.lynnpadc.moviebookingapp.data.vos.movie.cinema_showtime.CinemaVO
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackCategoryVO
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackVO
import com.lynnpadc.moviebookingapp.data.vos.ticket.TicketInformation
import com.lynnpadc.moviebookingapp.network.responses.login.OtpResponse
import com.lynnpadc.moviebookingapp.network.responses.profile.LogoutResponse

interface MovieBookingModel {

    // Cities
    fun insertCities(
        onSuccess:(List<CitiesVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getCities():List<CitiesVO>?

    // Login
    fun getOTP(
        phone: String,
        onSuccess: (OtpResponse) -> Unit,
        onFailure: (String) -> Unit
    )

    fun checkOTP(
        phone: String,
        otp: String,
        onSuccess: (OtpResponse) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getToken(code: Int): OtpResponse?

    // Banner
    fun getBanner(
        onSuccess: (List<BannerVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // Movie
    fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getComingSoonMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // Movie Detail
    fun getMovieDetailById(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieByIdForTicket(
        movieId:String
    ):MovieVO?

    // Cinema DateTime
    fun getCinemaAndTimeslot(
        authorization: String,
        date: String,
        onSuccess: (List<CinemaVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun insertCinemaConfig(
        onSuccess:(List<CinemaConfigVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getCinemaConfig(key:String):CinemaConfigVO?

    // Cinema Info
    fun insertCinemaInfo(
        onSuccess:(List<CinemaInfoVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getCinemaInfo(cinemaId:Int):CinemaInfoVO?

    // Seat
    fun getSeatingPlan(
        authorization: String,
        timeslotId: Int,
        bookingDate: String,
        onSuccess: (MutableList<MutableList<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    )

    // Snack
    fun getSnackCategory(
        authorization: String,
        onSuccess: (List<SnackCategoryVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSnackByCategoryId(
        authorization: String,
        categoryId: String,
        onSuccess: (List<SnackVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // Payment
    fun getPaymentType(
        authorization: String,
        onSuccess: (List<PaymentVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // Checkout
    fun getCheckoutTicket(
        authorization: String,
        checkoutTicket: CheckoutBody,
        onSuccess: (CheckoutVO) -> Unit,
        onFailure: (String) -> Unit
    )

    // log out
    fun logout(
        authorization: String,
        onSuccess: (LogoutResponse) -> Unit,
        onFailure: (String) -> Unit
    )

    fun deleteAll()

    // Ticket
    fun insertTicket(ticket: TicketInformation)

    fun getAllTicket(): List<TicketInformation>?

    fun deleteTicket(ticketId: Int)
}