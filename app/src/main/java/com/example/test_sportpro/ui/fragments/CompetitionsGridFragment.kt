package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentCompetitionsGridBinding

class CompetitionsGridFragment : Fragment(R.layout.fragment_competitions_grid) {

    private var fragmentCompetitionsGridBinding : FragmentCompetitionsGridBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCompetitionsGridBinding = FragmentCompetitionsGridBinding.bind(view)
    }
}