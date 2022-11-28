package com.example.film.ui.fragments

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.film.R
import com.example.film.base.BaseFragment
import com.example.film.databinding.FragmentFilmBinding
import com.example.film.ui.adapter.FilmAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment :
    BaseFragment<FragmentFilmBinding, FilmViewModel>(R.layout.fragment_film), FilmAdapter.OnClick {

    override val binding by viewBinding(FragmentFilmBinding::bind)
    override val viewModel: FilmViewModel by viewModels()
    private val filmAdapter = FilmAdapter(this)

    override fun setupSubscribes() {
        subscribeToFilms()
    }

    override fun initialize() {
        binding.filmRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmAdapter
        }
    }

    override fun setupListener() {
        binding.btnFilm.setOnClickListener {
            binding.btnFilm.visibility = View.GONE
            binding.filmRecView.visibility = View.VISIBLE
            viewModel.fetchFilms()
        }
    }

    private fun subscribeToFilms() {
        viewModel.fetchFilms().subscribe(
            onError = { message ->
                Log.e("no connect", message)
            },
            onSuccess = {
                filmAdapter.submitList(it.body())
                Log.e("yes connect", it.toString())
            }
        )
    }

    override fun onClick(id: String) {
        findNavController().navigate(
            FilmFragmentDirections.actionFilmFragmentToDetailFilmFragment(id)
        )
    }
}
