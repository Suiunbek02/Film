package com.example.film.ui.fragments

import com.example.film.base.BaseViewModel
import com.example.film.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository
) : BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}