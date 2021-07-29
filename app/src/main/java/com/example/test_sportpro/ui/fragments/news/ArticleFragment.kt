package com.example.test_sportpro.ui.fragments.news

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test_sportpro.R
import com.example.test_sportpro.databinding.FragmentArticleBinding
import com.example.test_sportpro.ui.fragments.ArticleFragmentArgs
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


class ArticleFragment : Fragment(R.layout.fragment_article) {

    val args: ArticleFragmentArgs by navArgs()

    private var fragmentArticleBinding: FragmentArticleBinding? = null

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDateStr(strDate: String?): String? {
        return OffsetDateTime.parse(strDate)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArticleBinding = FragmentArticleBinding.bind(view)

        val article = args.article

        fragmentArticleBinding!!.newsTitle.text = article.title
        fragmentArticleBinding!!.newsDate.text = formatDateStr(article.dateofadd)
        fragmentArticleBinding!!.newsContent.text = article.article
        Glide.with(this).load(article.photo).into(fragmentArticleBinding!!.newsCover)

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