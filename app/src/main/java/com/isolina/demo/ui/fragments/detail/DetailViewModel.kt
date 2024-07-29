package com.isolina.demo.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.isolina.demo.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {

    lateinit var product: Product
    val listMenu: List<String> = listOf("","","")

}