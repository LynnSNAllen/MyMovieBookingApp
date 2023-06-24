package com.lynnpadc.moviebookingapp.ui.viewholders.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lynnpadc.moviebookingapp.data.vos.movie.PaymentVO
import com.lynnpadc.moviebookingapp.databinding.ViewHolderMoviePaymentBinding
import com.lynnpadc.moviebookingapp.ui.delgates.PaymentViewHolderDelegate

class MoviePaymentViewHolder(itemView: View, delegate: PaymentViewHolderDelegate) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderMoviePaymentBinding
    private var mPayment: PaymentVO? = null

    init {
        binding = ViewHolderMoviePaymentBinding.bind(itemView)
        itemView.setOnClickListener {
            delegate.onTapPayment(mPayment?.id ?: 0)
        }
    }


    fun bindData(payment: PaymentVO) {
        mPayment = payment
        Glide.with(itemView.context)
            .load(payment.icon)
            .into(binding.ivPaylogo)

        binding.tvPayment.text = payment.title
    }
}