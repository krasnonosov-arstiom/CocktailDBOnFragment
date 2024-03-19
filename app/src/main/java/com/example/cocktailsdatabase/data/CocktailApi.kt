package com.example.cocktailsdatabase.data

import com.example.cocktailsdatabase.data.models.CocktailsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CocktailApi {

    @Headers(CONTENT_TYPE)
    @GET("search.php")
    suspend fun getByName(@Query("s") name: String): CocktailsResponse

    @Headers(CONTENT_TYPE)
    @GET("filter.php")
    suspend fun getByIngredient(@Query("i") ingredient: String): CocktailsResponse

    @Headers(CONTENT_TYPE)
    @GET("lookup.php")
    suspend fun getById(@Query("i") id: String): CocktailsResponse

    private companion object {

        const val CONTENT_TYPE = "Content-Type: application/json"
    }
}