package com.lynnpadc.moviebookingapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lynnpadc.moviebookingapp.data.models.MovieBookingModel
import com.lynnpadc.moviebookingapp.data.models.MovieBookingModelImpl
import com.lynnpadc.moviebookingapp.databinding.FragmentTicketBinding
import com.lynnpadc.moviebookingapp.ui.activities.ticket.TicketDetailActivity
import com.lynnpadc.moviebookingapp.ui.adapters.ticket.TicketAdapter
import com.lynnpadc.moviebookingapp.ui.delgates.TicketViewHolderDelegate

class TicketFragment : Fragment(), TicketViewHolderDelegate {

    private lateinit var binding: FragmentTicketBinding
    private lateinit var mTicketAdapter: TicketAdapter

    // Model
    private val mMovieBookingModel: MovieBookingModel = MovieBookingModelImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_ticket, container, false)

        binding = FragmentTicketBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTicketRecyclerView()
        requestTicketData()
    }

    private fun requestTicketData() {
        mTicketAdapter.setNewData(mMovieBookingModel.getAllTicket() ?: listOf())
        Log.d("TicketActivity","${mMovieBookingModel.getAllTicket() ?: listOf()}")
    }

    private fun setUpTicketRecyclerView() {
        mTicketAdapter = TicketAdapter(this)
        binding.rvTicketList.adapter = mTicketAdapter
        binding.rvTicketList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun onTapTicket(ticketId: Int) {
        startActivity(TicketDetailActivity.newIntent(requireActivity(),ticketId))
    }
}