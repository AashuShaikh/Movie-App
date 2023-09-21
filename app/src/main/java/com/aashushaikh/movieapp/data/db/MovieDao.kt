package com.aashushaikh.movieapp.data.db

import androidx.room.*
import com.aashushaikh.movieapp.data.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getAllMovies(): List<Movie>
}