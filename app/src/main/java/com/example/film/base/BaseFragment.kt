package com.example.film.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.film.common.Resource

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {
    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequest()
        setupSubscribes()
    }

    protected open fun initialize() {
    }

    protected open fun setupListener() {
    }

    protected open fun setupRequest() {
    }

    protected open fun setupSubscribes() {
    }

    protected open fun <T> LiveData<Resource<T>>.subscribe(
        state: ((state: Resource<T>) -> Unit)? = null,
        onError: (error: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
        observe(viewLifecycleOwner) {
            state?.invoke(it)
            when (it) {
                is Resource.Error -> onError(it.message.toString())
                is Resource.Loading -> {}
                is Resource.Success -> if (it.data != null) {
                    onSuccess(it.data)
                }
            }
        }
    }
}