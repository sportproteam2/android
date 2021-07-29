package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentThirdInfoBinding

class ThirdInfoFragment : Fragment(R.layout.fragment_third_info) {

    val args: ThirdInfoFragmentArgs by navArgs()

    private var fragmentThirdInfoBinding : FragmentThirdInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentThirdInfoBinding = FragmentThirdInfoBinding.bind(view)

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

        if (sportsman != null) {
            fragmentThirdInfoBinding!!.ageCategory.setText(sportsman.playercategory.toString())
        }//name
        if (sportsman != null) {
            fragmentThirdInfoBinding!!.sportType.setText(sportsman.sport.toString())
        }//name
        if (sportsman != null) {
            fragmentThirdInfoBinding!!.experience.setText(sportsman.organization)
        }
    }
}