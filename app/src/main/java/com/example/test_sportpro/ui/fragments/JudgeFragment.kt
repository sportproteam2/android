package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentJudgeBinding

class JudgeFragment : Fragment(R.layout.fragment_judge) {
    private var fragmentJudgeBinding : FragmentJudgeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeBinding = FragmentJudgeBinding.bind(view)
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