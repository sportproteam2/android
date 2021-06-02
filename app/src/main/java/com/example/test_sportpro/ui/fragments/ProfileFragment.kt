package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test_sportpro.R
import com.example.test_sportpro.ui.NewsViewModel
import com.example.test_sportpro.ui.activities.MainActivity

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}