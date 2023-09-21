package com.aashushaikh.movieapp.data.datasource

import com.aashushaikh.movieapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}