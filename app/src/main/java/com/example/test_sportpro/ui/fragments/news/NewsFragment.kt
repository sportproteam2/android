package com.example.test_sportpro.ui.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.NewsAdapter
import com.example.test_sportpro.databinding.FragmentNewsBinding
import com.example.test_sportpro.repository.SportRepository
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.SportViewModelProviderFactory
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import com.example.test_sportpro.utils.SessionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var viewModel: SportViewModel
    lateinit var newsAdapter: NewsAdapter

    private var fragmentNewsBinding: FragmentNewsBinding? = null

    private val TAG = "NewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        fragmentNewsBinding = FragmentNewsBinding.bind(view)

//        val sessionManager = SessionManager(requireContext())
//        if (sessionManager.fetchAuthToken() != null) {
//            findNavController().navigate(R.id.action_NewsFragment_to_judgeFragment)
//        }

        val newsRepository = SportRepository()
        val viewModelProviderFactory = SportViewModelProviderFactory(newsRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(SportViewModel::class.java)

        setupRecyclerView()

        val sportId = arguments?.getInt("sportId")

        if (sportId != null) {
            when(sportId) {
                1 -> viewModel.getNewsSportOne()
                2 -> viewModel.getNewsSportSecond()
                3 -> viewModel.getNewsSportThird()
                4 -> viewModel.getNewsSportFourth()
                5 -> viewModel.getNewsSportFifth()
            }

            viewModel.filteredNews.observe(viewLifecycleOwner, Observer { response ->

                when (response) {
                    is Resource.Success -> {
                        hideProgressBar()
                        response.message?.let { Log.d("TAG_SUCCESS", it) }
                        response.data?.let { article ->
                            newsAdapter.differ.submitList(article)
                        }
                    }
                    is Resource.Error -> {
                        hideProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                    is Resource.Loading -> {
                        showProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                }
            })

        } else {
            viewModel.getNews()

            viewModel.news.observe(viewLifecycleOwner, Observer { response ->

                when (response) {
                    is Resource.Success -> {
                        hideProgressBar()
                        response.message?.let { Log.d("TAG_SUCCESS", it) }
                        response.data?.let { article ->
                            newsAdapter.differ.submitList(article.results)
                        }
                    }
                    is Resource.Error -> {
                        hideProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                    is Resource.Loading -> {
                        showProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                }
            })
        }

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                    R.id.action_NewsFragment_to_articleFragment,
                    bundle
            )
        }

        fragmentNewsBinding!!.filterButton.setOnClickListener {
            findNavController().navigate(R.id.action_NewsFragment_to_filterFragment)
        }

        fragmentNewsBinding!!.judge.setOnClickListener {
            findNavController().navigate(R.id.action_NewsFragment_to_judgeFragment)
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        fragmentNewsBinding?.rvBreakingNews?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentNewsBinding = null
    }
}