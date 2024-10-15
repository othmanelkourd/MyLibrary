package com.applismile.mylibrary.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {

    @GET("/books/v1/volumes")
    suspend fun getBookByCode(
        @Query("q") code: String,
        @Query("key") key: String = ApiConfiguration.apiKey
    ) : Response<BookInfoResponse>

}