package com.example.test_sportpro.ui.fragments.trainerProfile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.test_sportpro.R
import com.example.test_sportpro.ui.fragments.ArticleFragmentArgs


class DetailCompititionFragment : Fragment(R.layout.fragment_detail_compitition) {

    val args: DetailCompititionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Args", args.event.toString())
    }





}