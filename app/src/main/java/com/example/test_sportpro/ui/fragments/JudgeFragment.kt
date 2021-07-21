package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.CompetitionsAdapter
import com.example.test_sportpro.databinding.FragmentJudgeBinding

class JudgeFragment : Fragment(R.layout.fragment_judge) {

    lateinit var competitionAdapter: CompetitionsAdapter

    private var fragmentJudgeBinding : FragmentJudgeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeBinding = FragmentJudgeBinding.bind(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val competitions : ArrayList<String> = ArrayList()
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")

        competitionAdapter = CompetitionsAdapter(competitions)
        fragmentJudgeBinding?.rv?.apply {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}