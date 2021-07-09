package com.example.test_sportpro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test_sportpro.repository.SportRepository

class SportViewModelProviderFactory(
    val sportRepository: SportRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SportViewModel(sportRepository) as T
    }
}