package com.example.test_sportpro.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.NewsAdapter
import com.example.test_sportpro.databinding.FragmentArticleBinding
import com.example.test_sportpro.ui.NewsViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource


class ArticleFragment : Fragment(R.layout.fragment_article) {

    val args: ArticleFragmentArgs by navArgs()

    private var fragmentArticleBinding: FragmentArticleBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArticleBinding = FragmentArticleBinding.bind(view)

        val article = args.article
        fragmentArticleBinding!!.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fragmentArticleBinding!!.backButton.setOnClickListener { activity?.onBackPressed() }
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