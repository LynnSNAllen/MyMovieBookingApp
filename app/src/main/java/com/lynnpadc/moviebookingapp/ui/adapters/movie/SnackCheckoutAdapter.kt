package com.lynnpadc.moviebookingapp.ui.adapters.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.moviebookingapp.R
import com.lynnpadc.moviebookingapp.data.vos.movie.snack.SnackVO
import com.lynnpadc.moviebookingapp.ui.viewholders.movie.SnackCheckoutViewHolder

class SnackCheckoutAdapter:RecyclerView.Adapter<SnackCheckoutViewHolder>() {

    private var mSnackList: List<SnackVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackCheckoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_snack_checkout,parent,false)
        return SnackCheckoutViewHolder(view.rootView)
    }

    override fun getItemCount(): Int {
        return mSnackList.count()
    }

    override fun onBindViewHolder(holder: SnackCheckoutViewHolder, position: Int) {
        if (mSnackList.isNotEmpty()){
            holder.bindData(mSnackList[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(snackList: List<SnackVO>) {
        mSnackList = snackList
        notifyDataSetChanged()
    }
}