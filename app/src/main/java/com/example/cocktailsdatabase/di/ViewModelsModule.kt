package com.example.cocktailsdatabase.di

import androidx.lifecycle.ViewModel
import com.example.cocktailsdatabase.presentation.MainSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainSearchViewModel::class)
    fun bindMainSearchViewModel(factory: MainSearchViewModel.Factory): AssistedViewModelFactory<out ViewModel>
}