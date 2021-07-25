package com.example.test_sportpro.ui.fragments.judgeProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentJudgeBinding

class JudgeCompetitionFragment : Fragment(R.layout.fragment_judge_competition) {
    private var fragmentJudgeBinding : FragmentJudgeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeBinding = FragmentJudgeBinding.bind(view)
    }
}