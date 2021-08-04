package com.example.test_sportpro.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_sportpro.models.*
import com.example.test_sportpro.repository.SportRepository
import com.example.test_sportpro.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class SportViewModel(
    val sportRepository: SportRepository
) : ViewModel() {

    val news: MutableLiveData<Resource<Article>> = MutableLiveData()
    var newsPage = 1
    var newsResponse: Article? = null

    val sport: MutableLiveData<Resource<SportType>> = MutableLiveData()
    val judges: MutableLiveData<Resource<User>> = MutableLiveData()
    val trainers: MutableLiveData<Resource<TrainersList>> = MutableLiveData()
    val events: MutableLiveData<Resource<Events>> = MutableLiveData()
    val players: MutableLiveData<Resource<Player>> = MutableLiveData()

    fun getNews() = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = sportRepository.getNews()
        news.postValue(handleNewsResponse(response))
    }

    fun getEvents() = viewModelScope.launch {
        events.postValue(Resource.Loading())
        val response = sportRepository.getEvents()
        events.postValue(handleEventsResponse(response))
    }

    fun getFilteredNews(sport: Int) = viewModelScope.launch {
        news.postValue(Resource.Loading())
        val response = sportRepository.getFilteredNews(sport)
        news.postValue(handleNewsResponse(response))
    }

    fun getAllSport() = viewModelScope.launch {
        sport.postValue(Resource.Loading())
        val response = sportRepository.getAllSport()
        sport.postValue(handleSportResponse(response))
    }

    fun getSport(category: Int) = viewModelScope.launch {
        sport.postValue(Resource.Loading())
        val response = sportRepository.getSport(category)
        sport.postValue(handleSportResponse(response))
    }

    fun getJudges() = viewModelScope.launch {
        judges.postValue(Resource.Loading())
        val response = sportRepository.getJudges()
        judges.postValue(handleUsersResponse(response))
    }

    fun getTrainers() = viewModelScope.launch {
        trainers.postValue(Resource.Loading())
        val response = sportRepository.getTrainers()
        trainers.postValue(handleTrainersResponse(response))
    }

    fun getPlayers() = viewModelScope.launch {
        players.postValue(Resource.Loading())
        val response = sportRepository.getPlayers()
        players.postValue(handlePlayersResponse(response))
    }

    private fun handleNewsResponse(response: Response<Article>) : Resource<Article> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                newsPage++
                if(newsResponse == null) {
                    newsResponse = resultResponse
                } else {
                    val oldArticles = newsResponse?.results
                    val newArticles = resultResponse.results
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleEventsResponse(response: Response<Events>) : Resource<Events> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSportResponse(response: Response<SportType>) : Resource<SportType> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleUsersResponse(response: Response<User>) : Resource<User> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleTrainersResponse(response: Response<TrainersList>) : Resource<TrainersList> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handlePlayersResponse(response: Response<Player>) : Resource<Player> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}