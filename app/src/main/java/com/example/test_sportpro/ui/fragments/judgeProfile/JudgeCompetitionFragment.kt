package com.example.test_sportpro.ui.fragments.judgeProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentJudgeBinding
import com.example.test_sportpro.databinding.FragmentJudgeCompetitionBinding

class JudgeCompetitionFragment : Fragment(R.layout.fragment_judge_competition) {

    val args : JudgeCompetitionFragmentArgs by navArgs()

    private var fragmentJudgeCompetitionBinding : FragmentJudgeCompetitionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeCompetitionBinding = FragmentJudgeCompetitionBinding.bind(view)

        val category = args.category

        fragmentJudgeCompetitionBinding!!.ageCategory.text = category
    }
}