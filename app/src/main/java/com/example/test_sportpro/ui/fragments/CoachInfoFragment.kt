package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentInfoCoachBinding


class CoachInfoFragment : Fragment(R.layout.fragment_info_coach) {

    private var fragmentInfoCoachBinding : FragmentInfoCoachBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoCoachBinding = FragmentInfoCoachBinding.bind(view)

        val sportCategory = arrayOf(
            "Национальные виды спорта",
            "Олимпийские виды спорта",
            "Неолимпийские виды спорта",
            "Виды спортов Пара и Сурдо"
        )
        val sportType = arrayOf("Айкидо", "Борьба", "Дзюдо", "Көк-бөрү")

        val adapterCategory = ArrayAdapter(requireActivity(), R.layout.support_simple_spinner_dropdown_item, sportCategory)
        fragmentInfoCoachBinding!!.sportCategory.setAdapter(adapterCategory)

        fragmentInfoCoachBinding!!.sportCategory.threshold = 1

        val adapterType = ArrayAdapter(requireActivity(), R.layout.support_simple_spinner_dropdown_item, sportType)
        fragmentInfoCoachBinding!!.sportType.setAdapter(adapterType)

        fragmentInfoCoachBinding!!.sportType.threshold = 1
    }




}