package com.example.test_sportpro.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_sportpro.models.Article
import com.example.test_sportpro.repository.NewsRepository
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

    val news: MutableLiveData<Resource<Article>> = MutableLiveData()

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = newsRepository.getNews()
        news.postValue(handleNewsResponse(response))
    }

    private fun handleNewsResponse(response: Response<Article>) : Resource<Article> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}