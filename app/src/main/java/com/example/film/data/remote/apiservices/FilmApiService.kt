package com.example.film.data.remote.apiservices

import com.example.film.models.model.FilmModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApiService {

    @GET("films")
    suspend fun fetchFilm():
            Response<ArrayList<FilmModel>>

    @GET("films/{id}")
    suspend fun fetchDetailFilm(
        @Path("id") id: String
    ): FilmModel
}