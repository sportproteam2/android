package com.example.test_sportpro.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_sportpro.models.Article
import com.example.test_sportpro.models.Sport
import com.example.test_sportpro.models.SportType
import com.example.test_sportpro.repository.SportRepository
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class SportViewModel(
    val sportRepository: SportRepository
) : ViewModel() {

    val news: MutableLiveData<Resource<Article>> = MutableLiveData()
    val sport: MutableLiveData<Resource<SportType>> = MutableLiveData()

    fun getNews() = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = sportRepository.getNews()
        news.postValue(handleNewsResponse(response))
    }

    fun getFilteredNews(sport: Int) = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = sportRepository.getFilteredNews(sport)
        news.postValue(handleNewsResponse(response))
    }

    fun getSport(category: Int) = viewModelScope.launch {
        sport.postValue(Resource.Loading())
        val response =sportRepository.getSport(category)
        sport.postValue(handleSportResponse(response))
    }

    private fun handleNewsResponse(response: Response<Article>) : Resource<Article> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSportResponse(response: Response<SportType>) : Resource<SportType>? {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}