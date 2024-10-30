package com.applismile.mylibrary.di

import android.content.Context
import androidx.room.Room
import com.applismile.mylibrary.data.BookDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): BookDataBase {
        return Room.databaseBuilder(
            applicationContext,
            BookDataBase::class.java, "books"
        ).build()
    }

}