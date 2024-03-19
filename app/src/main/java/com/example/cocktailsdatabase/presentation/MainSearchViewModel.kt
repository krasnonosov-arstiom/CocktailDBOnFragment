package com.example.cocktailsdatabase.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailsdatabase.di.AssistedViewModelFactory
import com.example.cocktailsdatabase.domain.models.CocktailModel
import com.example.cocktailsdatabase.domain.usecases.GetCocktailByNameUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainSearchViewModel @AssistedInject constructor(
    @Assisted arguments: Bundle,
    private val getCocktailByNameUseCase: GetCocktailByNameUseCase,
) : ViewModel() {

    private val _cocktailsListStateFlow = MutableStateFlow<List<CocktailModel>>(emptyList())
    val cocktailsListStateFlow: Flow<List<CocktailModel>> = _cocktailsListStateFlow

    fun onSearchQueryChanged(searchQuery: String) {
        viewModelScope.launch {
            _cocktailsListStateFlow.value = getCocktailByNameUseCase.get(searchQuery)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainSearchViewModel> {

        override fun create(arguments: Bundle): MainSearchViewModel
    }
}