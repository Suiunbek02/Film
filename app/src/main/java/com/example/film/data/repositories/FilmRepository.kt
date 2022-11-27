package com.example.film.data.repositories

import com.example.film.base.BaseRepository
import com.example.film.common.Resource
import com.example.film.data.remote.apiservices.FilmApiService
import com.example.film.models.model.FilmModel
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val service: FilmApiService
) : BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilm()
    }

    fun fetchDetailFragment(id: String) = doRequest {
        service.fetchDetailFilm(id = )
    }
}