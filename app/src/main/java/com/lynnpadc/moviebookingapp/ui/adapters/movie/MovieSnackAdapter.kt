package com.lynnpadc.moviebookingapp.ui.adapters.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.moviebookingapp.R
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackVO
import com.lynnpadc.moviebookingapp.ui.delgates.SnackViewHolderDelegate
import com.lynnpadc.moviebookingapp.ui.viewholders.movie.MovieSnackMovieHolder

class MovieSnackAdapter(
    private var delegate: SnackViewHolderDelegate
):RecyclerView.Adapter<MovieSnackMovieHolder>() {

    private var mSnackList:List<SnackVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSnackMovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie_snack,parent,false)
        return MovieSnackMovieHolder(view.rootView,delegate)
    }

    override fun getItemCount(): Int {
        return mSnackList.count()
    }

    override fun onBindViewHolder(holder: MovieSnackMovieHolder, position: Int) {
        holder.bindSnackData(mSnackList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun bindSnackListData(snackList: MutableList<SnackVO>) {
        mSnackList = snackList
        notifyDataSetChanged()
    }
}