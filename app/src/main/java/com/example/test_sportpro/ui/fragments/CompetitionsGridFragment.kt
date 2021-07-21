package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.AgeCategoriesAdapter
import com.example.test_sportpro.adapters.GridsStageAdapter
import com.example.test_sportpro.databinding.FragmentCompetitionsGridBinding

class CompetitionsGridFragment : Fragment(R.layout.fragment_competitions_grid) {

    lateinit var gridsStageAdapter: GridsStageAdapter
    private var fragmentCompetitionsGridBinding : FragmentCompetitionsGridBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCompetitionsGridBinding = FragmentCompetitionsGridBinding.bind(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val stages : ArrayList<String> = ArrayList()
        stages.add("1/32")
        stages.add("1/16")
        stages.add("1/8")
        stages.add("1/4")
        stages.add("1/2")


        gridsStageAdapter = GridsStageAdapter(stages)
        fragmentCompetitionsGridBinding?.rvGrid?.apply {
            adapter = gridsStageAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}