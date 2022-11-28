package com.example.film.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.film.base.BaseDiffUtilItemCallback
import com.example.film.databinding.ItemFilmBinding
import com.example.film.models.model.FilmModel

class FilmAdapter(private val onClick: OnClick) :
    ListAdapter<FilmModel, FilmAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: FilmModel?, onClick: OnClick) {
            binding.itemFilmText.text = item?.title
            binding.itemDisStatus.text = item?.description
            binding.itemCharacterStatus.text = item?.release_date
            binding.itemFilmImage.load(item?.image)
            itemView.setOnClickListener {
                onClick.onClick(item?.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), onClick)
    }

    interface OnClick {
        fun onClick(id: String)
    }
}