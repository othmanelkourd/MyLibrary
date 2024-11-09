package com.applismile.mylibrary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applismile.mylibrary.api.BookInfoResponse
import com.applismile.mylibrary.api.NetWorkResult
import com.applismile.mylibrary.data.Book
import com.applismile.mylibrary.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class BookViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        getBookById("isbn:9780722532935")
    }

    private val _response: MutableStateFlow<NetWorkResult<BookInfoResponse>> =
        MutableStateFlow(NetWorkResult.Loading(true))
    val response: StateFlow<NetWorkResult<BookInfoResponse>> = _response

    private val _allBooks: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val allBooks: StateFlow<List<Book>> = _allBooks


    fun getBookById(code: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.getBookById(code).collect { values ->
            _response.value = values
        }
    }

    fun saveBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.save(book)
    }

    fun getAllBooks() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllBooks().collect {
            _allBooks.value = it
        }
    }

    fun deleteBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteBook(book)
    }
}