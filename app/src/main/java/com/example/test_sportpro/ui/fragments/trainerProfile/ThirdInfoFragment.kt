package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentThirdBinding
import com.example.test_sportpro.databinding.FragmentThirdInfoBinding
import kotlinx.android.synthetic.main.fragment_register.view.*

class ThirdInfoFragment : Fragment(R.layout.fragment_third_info) {

    val args: ThirdInfoFragmentArgs by navArgs()

    private var fragmentThirdInfoBinding : FragmentThirdInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdInfoBinding = FragmentThirdInfoBinding.bind(view)

        val genderArray = resources.getStringArray(R.array.arrayOfGender)
        val genderAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, genderArray)
        fragmentThirdInfoBinding!!.gender.setAdapter(genderAdapter)

        fragmentThirdInfoBinding!!.showGender.setOnClickListener { fragmentThirdInfoBinding!!.gender.showDropDown() }

        val regionArray = resources.getStringArray(R.array.arrayOfRegion)
        val regionAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, regionArray)
        fragmentThirdInfoBinding!!.region.setAdapter(regionAdapter)

        fragmentThirdInfoBinding!!.showRegion.setOnClickListener { fragmentThirdInfoBinding!!.region.showDropDown() }

        val ageCategoryArray = resources.getStringArray(R.array.arrayOfAgeCategory)
        val ageCategoryAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, ageCategoryArray)
        fragmentThirdInfoBinding!!.ageCategory.setAdapter(ageCategoryAdapter)

        fragmentThirdInfoBinding!!.showAgeCategory.setOnClickListener { fragmentThirdInfoBinding!!.ageCategory.showDropDown() }

        val sportTypeArray = resources.getStringArray(R.array.arrayOfSportType)
        val sportTypeAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, sportTypeArray)
        fragmentThirdInfoBinding!!.sportType.setAdapter(sportTypeAdapter)

        fragmentThirdInfoBinding!!.showSportType.setOnClickListener { fragmentThirdInfoBinding!!.sportType.showDropDown() }

        if (arguments != null) {
            val sportsman = args.sportsman

            if (sportsman != null) {
                Glide.with(this)
                        .load(sportsman.photo)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(fragmentThirdInfoBinding!!.image)
            }

            if (sportsman != null) {
                fragmentThirdInfoBinding!!.surname.setText(sportsman.surname)
            }
            if (sportsman != null) {
                fragmentThirdInfoBinding!!.name.setText(sportsman.name)
            }

            if (sportsman != null) {
                fragmentThirdInfoBinding!!.gender.setText(sportsman.sex)
            }
            if (sportsman != null) {
                fragmentThirdInfoBinding!!.name.setText(sportsman.name)
            }

            if (sportsman != null) {
                fragmentThirdInfoBinding!!.weight.setText(sportsman.weight.toString())
            }

//            if (sportsman != null) {
//                fragmentThirdInfoBinding!!.ageCategory.setText(sportsman.playercategory.name)
//            }
//            if (sportsman != null) {
//                fragmentThirdInfoBinding!!.sportType.setText(sportsman.sport.name)
//            }

            if (sportsman != null) {
                fragmentThirdInfoBinding!!.experience.setText(sportsman.organization)
            }
        }

        fragmentThirdInfoBinding!!.save.setOnClickListener {  }
    }
}