package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.EventsAllAdapter
import com.example.test_sportpro.adapters.NewsAdapter
import com.example.test_sportpro.databinding.FragmentComAllBinding
import kotlinx.coroutines.MainScope

import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.launch
import org.json.JSONObject

class ComAllFragment : Fragment(R.layout.fragment_com_all) {

    lateinit var viewModel: SportViewModel
    lateinit var eventsAdapter: EventsAllAdapter
    private var fragmentComAllBinding: FragmentComAllBinding? = null
    private val TAG = "AllEventsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentComAllBinding = FragmentComAllBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
        viewModel.getEvents()

        eventsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("event", it)
            }

            findNavController().navigate(

                R.id.action_mainProfileFragment_to_detailCompititionFragment, bundle
            )
        }

        viewModel.events.observe(viewLifecycleOwner, Observer { response ->

            when (response) {
                is Resource.Success -> {
                    response.message?.let { Log.d("TAG_SUCCESS", it) }
                    response.data?.let { event ->
                        eventsAdapter.differ.submitList(event)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.d(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    response.message?.let { message ->
                        Log.d(TAG, "An error occured: $message")
                    }
                }
            }
        })


    }

    private fun setupRecyclerView() {
        eventsAdapter = EventsAllAdapter()
        fragmentComAllBinding?.rvAllEvents?.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(activity)
        }


    }




}