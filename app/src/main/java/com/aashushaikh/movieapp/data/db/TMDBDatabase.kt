package com.aashushaikh.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aashushaikh.movieapp.data.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

}