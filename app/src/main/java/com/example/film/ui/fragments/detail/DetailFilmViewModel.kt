package com.example.film.ui.fragments.detail

import com.example.film.base.BaseViewModel
import com.example.film.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmViewModel @Inject constructor(
    private val repository: FilmRepository
) : BaseViewModel() {

    fun fetchDetailFilms(id: String) = repository.fetchDetailFragment(id)
}