package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.ThirdAdapter
import com.example.test_sportpro.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {

    lateinit var thirdAdapter: ThirdAdapter

    private var fragmentThirdBinding : FragmentThirdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdBinding = FragmentThirdBinding.bind(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val sportsmen : ArrayList<String> = ArrayList()
        sportsmen.add("Акматов Азамат Акматович")
        sportsmen.add("Акматов Азамат Акматович")
        sportsmen.add("Акматов Азамат Акматович")
        sportsmen.add("Акматов Азамат Акматович")
        sportsmen.add("Акматов Азамат Акматович")
        sportsmen.add("Акматов Азамат Акматович")


        thirdAdapter = ThirdAdapter(sportsmen)
        fragmentThirdBinding?.rvSportsmen?.apply {
            adapter = thirdAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}