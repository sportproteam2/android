package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.AgeCategoriesAdapter
import com.example.test_sportpro.adapters.ThirdAdapter
import com.example.test_sportpro.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    lateinit var categoriesAdapter: AgeCategoriesAdapter
    private var fragmentCategoriesBinding : FragmentCategoriesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCategoriesBinding = FragmentCategoriesBinding.bind(view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val categories : ArrayList<String> = ArrayList()
        categories.add("Взрослые 1976-2002")
        categories.add("Юниоры 2003-2005")
        categories.add("Кадеты 2006-2008")
        categories.add("Дети 2009-2010")
        categories.add("Дети 8-9 лет 2011-2012")
        categories.add("Дети 6-7 лет 2013-2014")


        categoriesAdapter = AgeCategoriesAdapter(categories)
        fragmentCategoriesBinding?.rv?.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}