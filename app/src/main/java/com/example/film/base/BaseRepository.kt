package com.example.film.base

import androidx.lifecycle.liveData
import com.example.film.common.Resource

abstract class BaseRepository {

    protected fun <T> doRequest(result: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(result()))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.localizedMessage ?: "Error"))
        }
    }
}