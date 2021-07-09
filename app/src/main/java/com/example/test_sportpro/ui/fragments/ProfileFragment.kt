package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentProfileBinding
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity


class ProfileFragment : Fragment(R.layout.fragment_profile),View.OnClickListener {

    lateinit var navController: NavController
    lateinit var viewModel: SportViewModel
    var num = 19
    private var fragmentProfileBinding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.imageButtonJudge).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.imageButtonTrainer).setOnClickListener(this)
        view.findViewById<Button>(R.id.testButton).setOnClickListener(this)

        fragmentProfileBinding = FragmentProfileBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

//        var navc: NavController? = null
//        navc = Navigation.findNavController(view)


    }



    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.imageButtonJudge -> navController.navigate(R.id.action_profileFragment_to_numberFragment3)
            R.id.imageButtonTrainer -> navController.navigate(R.id.action_profileFragment_to_mainProfileFragment)
            R.id.testButton -> navController.navigate((R.id.action_profileFragment_to_registerFragment))


        }
    }
}