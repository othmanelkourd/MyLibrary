package com.applismile.mylibrary.data

data class Book(
    val id: String,
    val title: String,
    val dateOfReturn: Long,
)

fun Book.toEntity() = BookEntity(
    isbn = this.id,
    title = this.title,
    dateOfReturn = this.dateOfReturn
)
