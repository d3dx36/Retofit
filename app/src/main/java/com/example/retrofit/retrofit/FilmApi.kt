package com.example.retrofit.retrofit
import retrofit2.http.GET


interface FilmApi {
    @GET("http://www.omdbapi.com/?apikey=a4774fe5&s&")
suspend    fun getFilm(): FilmApi

}