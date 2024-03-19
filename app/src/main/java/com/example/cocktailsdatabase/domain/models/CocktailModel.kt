package com.example.cocktailsdatabase.domain.models

class CocktailModel(
    val id: String,
    val name: String,
    val category: String,
    val ingredients: List<IngredientModel>,
    val imgUrl: String
)