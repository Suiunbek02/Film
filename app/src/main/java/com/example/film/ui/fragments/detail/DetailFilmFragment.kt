package com.example.film.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
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


    override fun setupRequest(): = with(binding) {
        viewModel.fetchDetailFilms(safeArgs.id).subscribe(
            onError = {},
            onSuccess = {
                itemCharacterText.text = it.title
                itemLastLocation.id = id
                itemCharacterName.text = it?.description
                itemDetailDescription.text = it?.running_time
                Glide.with(itemDetailImage).load(it?.image).into(itemDetailImage)

            }
        )
    }
}

