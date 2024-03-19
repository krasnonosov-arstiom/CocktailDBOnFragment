package com.example.cocktailsdatabase.domain

import com.example.cocktailsdatabase.data.CocktailApi
import com.example.cocktailsdatabase.data.repositories.CocktailsRepository
import com.example.cocktailsdatabase.domain.mapper.toCocktailModel
import com.example.cocktailsdatabase.domain.models.CocktailModel
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi,
) : CocktailsRepository {

    override suspend fun getCocktailsByName(name: String): List<CocktailModel> {
        return cocktailApi.getByName(name).cocktails.map { it.toCocktailModel() }
    }
}