package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.NewsAdapter
import com.example.test_sportpro.adapters.SportTypesAdapter
import com.example.test_sportpro.databinding.FragmentTypesSportBinding
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import okhttp3.internal.notifyAll


class SportTypesFragment : Fragment(R.layout.fragment_types_sport) {

    lateinit var viewModel: SportViewModel
    lateinit var typesAdapter : SportTypesAdapter

    private var fragmentTypesSportBinding: FragmentTypesSportBinding? = null

    private val TAG = "SportTypesFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTypesSportBinding = FragmentTypesSportBinding.bind(view)

        val title = arguments?.getString("title")
        (activity as AppCompatActivity).supportActionBar?.title = title

        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

//        when(arguments?.getInt("id")) {
//            1 -> viewModel.getSport(1)
//            2 -> viewModel.getSport(2)
//            3 -> viewModel.getSport(3)
//            else -> viewModel.getSport(4)
//        }

        MainScope().launch {
            when (arguments?.getInt("id")) {
                1 -> viewModel.getSport(1)
                2 -> viewModel.getSport(2)
                3 -> viewModel.getSport(3)
                else -> viewModel.getSport(4)
            }
        }

        typesAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putInt("sportId", it.id)
            }
            findNavController().navigate(
                    R.id.action_sportTypesFragment_to_newsFragment,
                    bundle
            )
        }

        viewModel.sport.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let { sport ->
                        typesAdapter.differ.submitList(sport)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                }
            }
        })
    }

    private fun setupRecyclerView() {
        typesAdapter = SportTypesAdapter()
        fragmentTypesSportBinding?.rvSportTypes?.apply {
            adapter = typesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        fragmentTypesSportBinding = null
        super.onDestroyView()
    }
}