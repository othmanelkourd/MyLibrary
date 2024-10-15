package com.applismile.mylibrary.data

import com.applismile.mylibrary.api.BookApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: BookApiService) {
    suspend fun getBookById(code: String) = apiService.getBookByCode(code)
}