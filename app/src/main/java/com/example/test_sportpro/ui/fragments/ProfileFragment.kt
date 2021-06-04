package com.example.test_sportpro.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentProfileBinding
import com.example.test_sportpro.ui.NewsViewModel
import com.example.test_sportpro.ui.activities.MainActivity


class ProfileFragment : Fragment(R.layout.fragment_profile){

    lateinit var viewModel: NewsViewModel
    private var fragmentProfileBinding: FragmentProfileBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProfileBinding = FragmentProfileBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel


        var navc: NavController? = null
        navc = Navigation.findNavController(view)
        fragmentProfileBinding!!.imageButtonJudge.setOnClickListener(){
//            navc?.navigate.(R.id.action_ProfileFragment)
        }

//        fragmentProfileBinding!!.dogBlurImageView.setBlur(20)

        fragmentProfileBinding!!.imageButtonJudge.setOnClickListener() {
            hideFirst()
            showNumber()


        }

        fragmentProfileBinding!!.imageButtonTrainer.setOnClickListener() {
            hideFirst()
            showNumber()
        }

        fragmentProfileBinding!!.buttonNum.setOnClickListener() {
//            activity?.let {
//                val intent = Intent(it, Home::class.java)
//                it.startActivity(intent)
//            }
            hideFirst()
            hideNumber()
            showCode()

        }


        fragmentProfileBinding!!.buttonCode.setOnClickListener() {
            hideFirst()
            hideNumber()
            hideCode()
            showLast()
        }
    }

    private fun hideFirst() {
        fragmentProfileBinding?.linearLayoutFirst?.visibility = View.INVISIBLE
    }

    private fun hideNumber() {
        fragmentProfileBinding?.linearLayoutNumber?.visibility = View.INVISIBLE
    }

    private fun hideCode() {
        fragmentProfileBinding?.linearLayoutCode?.visibility = View.INVISIBLE
    }


    private fun showFirst() {
        fragmentProfileBinding?.linearLayoutFirst?.visibility = View.VISIBLE
    }

    private fun showNumber() {
        fragmentProfileBinding?.linearLayoutNumber?.visibility = View.VISIBLE
    }

    private fun showCode() {
        fragmentProfileBinding?.linearLayoutCode?.visibility = View.VISIBLE
    }

    private fun showLast() {
        fragmentProfileBinding?.linearLayoutLast?.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}