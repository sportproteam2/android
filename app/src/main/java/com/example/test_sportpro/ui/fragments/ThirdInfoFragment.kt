package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentThirdBinding

class ThirdInfoFragment : Fragment(R.layout.fragment_third_info) {
    private var fragmentThirdInfoBinding : FragmentThirdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdInfoBinding = FragmentThirdBinding.bind(view)
    }
}