package com.lynnpadc.moviebookingapp.ui.viewholders.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lynnpadc.moviebookingapp.data.vos.movie.MovieVO
import com.lynnpadc.moviebookingapp.databinding.ViewHolderMovieBinding
import com.lynnpadc.moviebookingapp.network.utiles.IMAGE_BASE_URL
import com.lynnpadc.moviebookingapp.ui.delgates.MovieViewHolderDelegate

class MovieViewHolder(itemView: View, delegate: MovieViewHolderDelegate) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderMovieBinding
    private var mMovieVO: MovieVO? = null

    init {
        binding = ViewHolderMovieBinding.bind(itemView)
        itemView.setOnClickListener {
            mMovieVO?.let {movie ->
                movie.id?.let { it -> delegate.onTapMovie(it) }
            }
        }
    }

    fun bindData(movie: MovieVO) {
        mMovieVO = movie
        Glide.with(itemView.context)
            .load("${IMAGE_BASE_URL}${movie.posterPath}")
            .into(binding.ivBlackWindow)

        binding.tvMovieName.text = movie.originalTitle
    }
}