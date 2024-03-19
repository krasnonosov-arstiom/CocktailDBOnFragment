package com.example.cocktailsdatabase.data.repositories

import com.example.cocktailsdatabase.domain.models.CocktailModel

interface CocktailsRepository {

    suspend fun getCocktailsByName(name: String): List<CocktailModel>
}