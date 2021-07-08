package com.example.test_sportpro.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test_sportpro.ComAllFragment
import com.example.test_sportpro.ComMyFragment
import com.example.test_sportpro.ui.fragments.FirstFragment
import com.example.test_sportpro.ui.fragments.SecondFragment
import com.example.test_sportpro.ui.fragments.ThirdFragment

class ViewPageAdapterCompetitions (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                ComAllFragment()
            }
            1->{
                ComMyFragment()
            }
            else->{
                Fragment()
            }

        }
    }
}