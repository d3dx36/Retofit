package com.example.retrofit.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {
    @GET("/?apikey=a4774fe5")
    suspend fun getFilm(
        @Query("s") searchQuery: String,
        @Query("y") year: String,
        @Query("plot") plot: String
    ): Film

    suspend fun getFilm(): Film

}