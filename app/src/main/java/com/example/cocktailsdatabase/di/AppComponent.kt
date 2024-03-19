package com.example.cocktailsdatabase.di

import com.example.cocktailsdatabase.presentation.MainSearchFragment
import dagger.Component

@Component(
    modules = [NetworkModule::class, RepositoriesModule::class, ViewModelsModule::class]
)
interface AppComponent {

    fun inject(fragment: MainSearchFragment)

    companion object {

        fun create(): AppComponent = DaggerAppComponent.create()
    }
}