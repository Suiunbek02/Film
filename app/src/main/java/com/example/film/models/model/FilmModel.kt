package com.example.film.models.model

import com.example.film.base.BaseDiffUtil
import com.google.gson.annotations.SerializedName

data class FilmModel(
    @SerializedName("id")
     override val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("running_time")
    val running_time: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("image")
    val image: String
) : BaseDiffUtil
