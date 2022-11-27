package com.example.film.base

import androidx.lifecycle.liveData
import com.example.film.common.Resource
import retrofit2.Response

abstract class BaseRepository {

    protected fun <T> doRequest(result: suspend () -> Response<T>) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(result().body()))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.localizedMessage ?: "Error"))
        }
    }
}