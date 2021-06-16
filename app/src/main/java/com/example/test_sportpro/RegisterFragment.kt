package com.example.test_sportpro

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class RegisterFragment : Fragment(),View.OnClickListener {
    lateinit var navController: NavController




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.bt_register).setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.bt_register -> navController.navigate(R.id.action_registerFragment_to_confirmationFragment)

        }
    }
}