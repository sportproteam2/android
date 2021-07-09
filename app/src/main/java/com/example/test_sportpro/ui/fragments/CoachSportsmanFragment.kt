package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentSportsmanCoachBinding

class CoachSportsmanFragment : Fragment(R.layout.fragment_sportsman_coach) {
    private var fragmentSportsmanCoachBinding : FragmentSportsmanCoachBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSportsmanCoachBinding = FragmentSportsmanCoachBinding.bind(view)

    }
}