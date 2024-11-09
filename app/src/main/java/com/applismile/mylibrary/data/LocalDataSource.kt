package com.applismile.mylibrary.data

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val db: BookDataBase
) {
    fun saveBook(book: Book) {
        db.bookDao().insertBook(book.toEntity())
    }

    fun getAllBooks(): List<Book> {
        return db.bookDao().getAll().map {
            it.toBook()
        }
    }

    fun deleteBook(book: Book) {
        db.bookDao().delete(book.toEntity())
    }
}