package com.aashushaikh.movieapp.data.datasource

import com.aashushaikh.movieapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}