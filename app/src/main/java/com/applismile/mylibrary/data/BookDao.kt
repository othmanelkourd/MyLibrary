package com.applismile.mylibrary.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

const val SELECT = "SELECT * FROM books"
const val GET_BY_ISBN = "SELECT * FROM books WHERE isbn LIKE :code"


@Dao
interface BookDao {

    @Query(GET_BY_ISBN)
    fun findBookByCode(code: String): BookEntity

    @Query(SELECT)
    fun getAll(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: BookEntity)

    @Delete
    fun delete(book: BookEntity)
}
