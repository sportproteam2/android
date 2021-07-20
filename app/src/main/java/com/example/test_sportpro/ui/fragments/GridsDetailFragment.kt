package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentGridsDetailBinding

class GridsDetailFragment : Fragment(R.layout.fragment_grids_detail) {
    private var fragmentGridsDetailBinding : FragmentGridsDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentGridsDetailBinding = FragmentGridsDetailBinding.bind(view)
    }
}