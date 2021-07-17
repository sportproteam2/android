package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentChooseCompetitionBinding
import com.example.test_sportpro.databinding.FragmentJudgeBinding

class ChooseCompetitionFragment : Fragment(R.layout.fragment_choose_competition) {
    private var fragmentChooseCompetitionBinding : FragmentChooseCompetitionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentChooseCompetitionBinding = FragmentChooseCompetitionBinding.bind(view)
    }
}