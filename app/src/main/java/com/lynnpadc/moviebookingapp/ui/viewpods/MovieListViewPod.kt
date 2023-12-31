package com.lynnpadc.moviebookingapp.ui.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.lynnpadc.moviebookingapp.data.vos.movie.MovieVO
import com.lynnpadc.moviebookingapp.databinding.ViewPodMovieListBinding
import com.lynnpadc.moviebookingapp.ui.adapters.movie.MovieAdapter
import com.lynnpadc.moviebookingapp.ui.delgates.MovieViewHolderDelegate

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var binding: ViewPodMovieListBinding
    private lateinit var mMovieAdapter: MovieAdapter

    private lateinit var mDelegate: MovieViewHolderDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodMovieListBinding.bind(this)
    }

    fun setUpNowShowingListPod(delegate: MovieViewHolderDelegate){
        setDelegate(delegate)
        setUpNowShowingRecyclerView()
    }

    fun setUpComingSoonListPod(delegate: MovieViewHolderDelegate){
        setDelegate(delegate)
        setUpComingSoonRecyclerView()
    }

    private fun setDelegate(delegate: MovieViewHolderDelegate){
        this.mDelegate = delegate
    }

    fun setData(movieList: List<MovieVO>) {
        mMovieAdapter.setNewData(movieList)
    }

    private fun setUpNowShowingRecyclerView() {
        mMovieAdapter = MovieAdapter(false,mDelegate)
        binding.rvMovieList.adapter = mMovieAdapter
        binding.rvMovieList.layoutManager = GridLayoutManager(context,2,
            GridLayoutManager.VERTICAL,false)
    }

    private fun setUpComingSoonRecyclerView() {
        mMovieAdapter = MovieAdapter(true,mDelegate)
        binding.rvMovieList.adapter = mMovieAdapter
        binding.rvMovieList.layoutManager = GridLayoutManager(context,2,
            GridLayoutManager.VERTICAL,false)
    }
}