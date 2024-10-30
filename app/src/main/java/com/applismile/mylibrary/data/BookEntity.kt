package com.applismile.mylibrary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey val isbn: String,
    @ColumnInfo(name = "book_title") val title: String,
    @ColumnInfo(name = "date_of_return") val dateOfReturn: Long,
)

fun BookEntity.toBook() = Book(isbn, title, dateOfReturn)