package com.example.cocktailsdatabase.domain.mapper

import com.example.cocktailsdatabase.data.models.CocktailResponse
import com.example.cocktailsdatabase.domain.models.CocktailModel
import com.example.cocktailsdatabase.domain.models.IngredientModel

fun CocktailResponse.toCocktailModel(): CocktailModel {
    val ingredient1 = IngredientModel(strIngredient1, strMeasure1)
    val ingredient2 = IngredientModel(strIngredient2, strMeasure2)
    val ingredient3 = IngredientModel(strIngredient3, strMeasure3)
    val ingredient4 = IngredientModel(strIngredient4, strMeasure4)
    val ingredient5 = IngredientModel(strIngredient5, strMeasure5)
    val ingredients = mutableListOf<IngredientModel>().apply {
        add(ingredient1)
        add(ingredient2)
        add(ingredient3)
        add(ingredient4)
        add(ingredient5)
    }
    return CocktailModel(
        id = idDrink,
        name = strDrink,
        category = strCategory.orEmpty(),
        ingredients = ingredients,
        imgUrl = strDrinkThumb
    )
}
