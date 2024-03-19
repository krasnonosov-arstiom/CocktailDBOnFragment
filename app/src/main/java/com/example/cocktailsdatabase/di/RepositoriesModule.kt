package com.example.cocktailsdatabase.di

import com.example.cocktailsdatabase.data.repositories.CocktailsRepository
import com.example.cocktailsdatabase.domain.CocktailsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindCocktailsRepository(repositoryImpl: CocktailsRepositoryImpl): CocktailsRepository
}