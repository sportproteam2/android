package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentThirdBinding
import com.example.test_sportpro.databinding.FragmentThirdInfoBinding

class ThirdInfoFragment : Fragment(R.layout.fragment_third_info) {

    val args: ThirdInfoFragmentArgs by navArgs()

    private var fragmentThirdInfoBinding : FragmentThirdInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdInfoBinding = FragmentThirdInfoBinding.bind(view)

        val sportsman = args.sportsman

        Glide.with(this)
                .load(sportsman.photo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(fragmentThirdInfoBinding!!.image)

        fragmentThirdInfoBinding!!.surname.setText(sportsman.surname)
        fragmentThirdInfoBinding!!.name.setText(sportsman.name)

        fragmentThirdInfoBinding!!.gender.setText(sportsman.sex)
        fragmentThirdInfoBinding!!.name.setText(sportsman.name)

        fragmentThirdInfoBinding!!.weight.setText(sportsman.weight.toString())

        fragmentThirdInfoBinding!!.ageCategory.setText(sportsman.playercategory.name)
        fragmentThirdInfoBinding!!.sportType.setText(sportsman.sport.name)
        fragmentThirdInfoBinding!!.experience.setText(sportsman.organization)
    }
}