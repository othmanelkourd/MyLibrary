package com.applismile.mylibrary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applismile.mylibrary.api.BookInfoResponse
import com.applismile.mylibrary.api.NetWorkResult
import com.applismile.mylibrary.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        getProductsList("isbn:9780722532935")
    }

    private val _response: MutableStateFlow<NetWorkResult<BookInfoResponse>> =
        MutableStateFlow(NetWorkResult.Loading(true))
    val response: StateFlow<NetWorkResult<BookInfoResponse>> = _response


    fun getProductsList(code: String) = viewModelScope.launch {
        repository.getBookById(code).collect { values ->
            _response.value = values
        }
    }
}