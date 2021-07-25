package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.test_sportpro.R
import kotlinx.android.synthetic.main.fragment_com_my.view.*

class ComMyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_com_my, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.IBMyCom.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_categoriesFragment)

        }

        view.IBMyCom2.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_categoriesFragment)

        }

        view.IBMyCom3.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_competitionDetailFragment)

        }
        





    }


}