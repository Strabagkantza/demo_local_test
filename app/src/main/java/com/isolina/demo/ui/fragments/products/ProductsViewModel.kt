package com.isolina.demo.ui.fragments.products

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Product
import com.isolina.demo.usecases.LocalUseCase
import com.isolina.demo.usecases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val useCase: UseCase,
    private val localUseCase: LocalUseCase
): ViewModel() {

    private val _items = MutableLiveData<List<Product>>()
    val items: LiveData<List<Product>> = _items

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun instance(context: Context) {
        viewModelScope.launch {
            _progress.value = true
            val data = localUseCase.executeInstance(context)
            if (data.isEmpty()) {
                products()
            } else {
                _progress.value = false
                _items.value = data
            }
        }
    }

    fun products() {
        viewModelScope.launch {
            val res = useCase.executeProducts()
            if (res.status == Output.Status.SUCCESS) {
                _progress.value = false
                res.data?.let {
                    _items.value = it
                }
            } else {
                _progress.value = false
                _error.value = res.message ?: "Error"
            }
        }
    }
}