package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var fragmentFirstBinding : FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFirstBinding = FragmentFirstBinding.bind(view)

        val regionArray = resources.getStringArray(R.array.arrayOfRegion)
        val regionAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, regionArray)
        fragmentFirstBinding!!.region.setAdapter(regionAdapter)

        fragmentFirstBinding!!.showRegion.setOnClickListener { fragmentFirstBinding!!.region.showDropDown() }

        val sportTypeArray = resources.getStringArray(R.array.arrayOfSportType)
        val sportTypeAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, sportTypeArray)
        fragmentFirstBinding!!.sportType.setAdapter(sportTypeAdapter)

        fragmentFirstBinding!!.showSportType.setOnClickListener { fragmentFirstBinding!!.sportType.showDropDown() }
    }

}