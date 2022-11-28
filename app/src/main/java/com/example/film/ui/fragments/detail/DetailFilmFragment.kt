package com.example.film.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.film.R
import com.example.film.base.BaseFragment
import com.example.film.databinding.FragmentDetailFilmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmFragment :
    BaseFragment<FragmentDetailFilmBinding, DetailFilmViewModel>(R.layout.fragment_detail_film) {

    override val binding by viewBinding(FragmentDetailFilmBinding::bind)
    override val viewModel: DetailFilmViewModel by viewModels()
    private val safeArgs by navArgs<DetailFilmFragmentArgs>()

    override fun setupRequest() = with(binding) {
        viewModel.fetchDetailFilms(safeArgs.id).subscribe(
            onError = {},
            onSuccess = {
                itemDetailText.text = it.title
                textLastLocation.text = it.release_date
                itemDetailDescription.text = it.description
                itemDetailSpecies.text = it.original_title
                itemFirstSeenIn.text = it.director
                itemLastLocation.text = it.url
                Glide.with(itemDetailImage).load(it.image).into(itemDetailImage)
            }
        )
    }
}

