package com.lynnpadc.moviebookingapp.ui.adapters.ticket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynnpadc.moviebookingapp.R
import com.lynnpadc.moviebookingapp.data.vos.ticket.TicketInformation
import com.lynnpadc.moviebookingapp.ui.delgates.TicketViewHolderDelegate
import com.lynnpadc.moviebookingapp.ui.viewholders.ticket.TicketViewHolder

class TicketAdapter(private var delegate: TicketViewHolderDelegate):RecyclerView.Adapter<TicketViewHolder>() {

    private var mTicketList: List<TicketInformation>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_ticket,parent,false)
        return TicketViewHolder(view.rootView,delegate)
    }

    override fun getItemCount(): Int {
        return mTicketList?.count()!!
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        if (mTicketList?.isNotEmpty() == true){
            holder.bindData(mTicketList!![position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(ticketList: List<TicketInformation>?) {
        mTicketList = ticketList
        notifyDataSetChanged()
    }
}