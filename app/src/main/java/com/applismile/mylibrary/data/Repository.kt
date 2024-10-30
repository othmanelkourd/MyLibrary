package com.applismile.mylibrary.data

import com.applismile.mylibrary.api.BookInfoResponse
import com.applismile.mylibrary.api.NetWorkResult
import com.applismile.mylibrary.api.toResultFlow
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getBookById(
        code: String
    ): Flow<NetWorkResult<BookInfoResponse>> {
        return toResultFlow() {
            remoteDataSource.getBookById(code)
        }
    }

    suspend fun save(book: Book) {
        localDataSource.saveBook(book)
    }

    suspend fun getAllBooks(): Flow<List<Book>> {
        return flowOf(localDataSource.getAllBooks())
    }
}