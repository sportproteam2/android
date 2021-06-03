package com.example.test_sportpro.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentArticleBinding
import com.example.test_sportpro.databinding.FragmentNewsBinding

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
    }
}