package com.example.test_sportpro.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.test_sportpro.R
import com.example.test_sportpro.fragments.NewsFragment
import com.example.test_sportpro.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val newsNavHostFragment = findViewById<FragmentContainerView>(R.id.newsNavHostFragment)

        bottomNavigation.setupWithNavController(newsNavHostFragment.findNavController())
    }
}