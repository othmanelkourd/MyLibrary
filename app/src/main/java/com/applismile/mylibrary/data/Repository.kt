package com.applismile.mylibrary.data

import android.content.Context
import com.applismile.mylibrary.api.BookInfoResponse
import com.applismile.mylibrary.api.NetWorkResult
import com.applismile.mylibrary.api.toResultFlow
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getBookById(
        code: String
    ): Flow<NetWorkResult<BookInfoResponse>> {
        return toResultFlow() {
            remoteDataSource.getBookById(code)
        }
    }
}