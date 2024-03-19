package com.example.cocktailsdatabase.domain.usecases

import com.example.cocktailsdatabase.data.repositories.CocktailsRepository
import com.example.cocktailsdatabase.domain.models.CocktailModel
import javax.inject.Inject

class GetCocktailByNameUseCase @Inject constructor(
    private val repository: CocktailsRepository
) {

    suspend fun get(name: String): List<CocktailModel> = repository.getCocktailsByName(name)
}