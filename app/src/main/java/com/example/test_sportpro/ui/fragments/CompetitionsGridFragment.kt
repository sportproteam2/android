package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.AgeCategoriesAdapter
import com.example.test_sportpro.adapters.GridsSportsmenAdapter
import com.example.test_sportpro.adapters.GridsStageAdapter
import com.example.test_sportpro.databinding.FragmentCompetitionsGridBinding

class CompetitionsGridFragment : Fragment(R.layout.fragment_competitions_grid) {

    lateinit var gridsStageAdapter: GridsStageAdapter
    lateinit var gridsSportsmenAdapter: GridsSportsmenAdapter

    private var fragmentCompetitionsGridBinding : FragmentCompetitionsGridBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCompetitionsGridBinding = FragmentCompetitionsGridBinding.bind(view)

        setupRvGrid()
        setupRvSportsmen()
    }

    private fun setupRvGrid() {
        val stages : ArrayList<String> = ArrayList()
        stages.add("1/32")
        stages.add("1/16")
        stages.add("1/8")
        stages.add("1/4")
        stages.add("1/2")


        gridsStageAdapter = GridsStageAdapter(stages)
        fragmentCompetitionsGridBinding?.rvGrid?.apply {
            adapter = gridsStageAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupRvSportsmen() {
        val stages : ArrayList<String> = ArrayList()
        stages.add("Айбеков Айбек \nАйбекович")
        stages.add("Айбеков Айбек \nАйбекович")
        stages.add("Айбеков Айбек \nАйбекович")
        stages.add("Айбеков Айбек \nАйбекович")
        stages.add("Айбеков Айбек \nАйбекович")
        stages.add("Айбеков Айбек \nАйбекович")


        gridsSportsmenAdapter = GridsSportsmenAdapter(stages)
        fragmentCompetitionsGridBinding?.rvSportsmen?.apply {
            adapter = gridsSportsmenAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}