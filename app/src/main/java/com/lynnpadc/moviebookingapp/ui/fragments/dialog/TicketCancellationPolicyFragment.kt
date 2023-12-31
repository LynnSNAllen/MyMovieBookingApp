package com.lynnpadc.moviebookingapp.ui.fragments.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.lynnpadc.moviebookingapp.databinding.FragmentTicketCancellationPolicyBinding

class TicketCancellationPolicyFragment : DialogFragment() {

    private lateinit var binding: FragmentTicketCancellationPolicyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_ticket_cancellation_policy, container, false)

        binding = FragmentTicketCancellationPolicyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

}