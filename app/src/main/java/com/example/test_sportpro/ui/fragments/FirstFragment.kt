package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var fragmentFirstBinding : FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFirstBinding = FragmentFirstBinding.bind(view)

        val sportType = arrayOf("Айкидо", "Борьба", "Дзюдо", "Көк-бөрү")

        val adapterType = ArrayAdapter(requireActivity(), R.layout.support_simple_spinner_dropdown_item, sportType)
        fragmentFirstBinding!!.sportType.setAdapter(adapterType)

        fragmentFirstBinding!!.sportType.threshold = 1
    }

}