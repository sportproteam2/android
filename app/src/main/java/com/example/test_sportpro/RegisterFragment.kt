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
import com.example.test_sportpro.utils.snackbar
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import java.io.File


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

        view.firstImageContener.setOnClickListener(){
            uploadImage()

        }


    }

    private fun uploadImage(){
//        if (selectedImage == null){
//            layout_register.snackbar("Select an image first")
//            return
//        }
//
//        val parcelFileDescriptor = contentResolver.openFileDescriptor(selectImage!!, "r", null)?: return
//        val file = File(cachDir, "")
    }



    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.bt_register -> navController.navigate(R.id.action_registerFragment_to_confirmationFragment)

        }
    }
}