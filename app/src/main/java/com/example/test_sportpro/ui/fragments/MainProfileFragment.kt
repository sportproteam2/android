package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator



class MainProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout=view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=view.findViewById<ViewPager2>(R.id.view_pager_2)





        val adapter= activity?.let { ViewPagerAdapter(it.supportFragmentManager, lifecycle) }


        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout, viewPager2){ tab, position->
            when(position){
                0 -> {
                    tab.text = "Данные"
                }
                1 -> {
                    tab.text = "Соревнования"
                }
                2 -> {
                    tab.text = "Спортсмены"
                }
            }
        }.attach()

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