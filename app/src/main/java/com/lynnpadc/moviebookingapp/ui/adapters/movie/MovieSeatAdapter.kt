package com.lynnpadc.moviebookingapp.ui.adapters.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.moviebookingapp.R
import com.lynnpadc.moviebookingapp.data.vos.movie.SeatVO
import com.lynnpadc.moviebookingapp.ui.delgates.SeatViewHolderDelegate
import com.lynnpadc.moviebookingapp.ui.viewholders.movie.MovieSeatViewHolder

class MovieSeatAdapter(
    private val delegate: SeatViewHolderDelegate
):RecyclerView.Adapter<MovieSeatViewHolder>() {

    private var mSeatList: MutableList<MutableList<SeatVO>> = mutableListOf()
    private val numberOfColumn = 18

    companion object{
        private val seatVO = SeatVO(null,"path",null,null,null,false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSeatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie_seat,parent,false)
        return MovieSeatViewHolder(view.rootView,delegate)
    }

    override fun getItemCount(): Int {
        return mSeatList.count() * numberOfColumn
    }

    override fun onBindViewHolder(holder: MovieSeatViewHolder, position: Int) {
        if (mSeatList.isNotEmpty()){
            holder.bindSeatData(mSeatList,holder.adapterPosition)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(seatList: MutableList<MutableList<SeatVO>>) {
        mSeatList = seatList
        notifyDataSetChanged()
    }

}