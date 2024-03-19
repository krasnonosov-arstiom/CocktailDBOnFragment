package com.example.cocktailsdatabase.di

import com.example.cocktailsdatabase.data.CocktailApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitInstance(): CocktailApi = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CocktailApi::class.java)
}