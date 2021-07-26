package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.ThirdAdapter
import com.example.test_sportpro.databinding.FragmentThirdBinding
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class ThirdFragment : Fragment(R.layout.fragment_third) {

    lateinit var viewModel: SportViewModel
    lateinit var thirdAdapter: ThirdAdapter

    private var fragmentThirdBinding : FragmentThirdBinding? = null

    private val TAG = "ThirdFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdBinding = FragmentThirdBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        MainScope().launch { viewModel.getPlayers() }

        thirdAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("sportsman", it)
            }
            findNavController().navigate(
                    R.id.action_mainProfileFragment_to_thirdInfoFragment,
                    bundle
            )
        }

        viewModel.players.observe(viewLifecycleOwner, Observer { response ->

            when (response) {
                is Resource.Success -> {
                    response.message?.let { Log.d("TAG_SUCCESS", it) }
                    response.data?.let { sportsman ->
                        thirdAdapter.differ.submitList(sportsman)
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
        thirdAdapter = ThirdAdapter()
        fragmentThirdBinding?.rvSportsmen?.apply {
            adapter = thirdAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}