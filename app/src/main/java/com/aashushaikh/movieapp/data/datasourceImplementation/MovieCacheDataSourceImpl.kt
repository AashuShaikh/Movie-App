package com.aashushaikh.movieapp.data.datasourceImplementation

import com.aashushaikh.movieapp.data.datasource.MovieCacheDataSource
import com.aashushaikh.movieapp.data.model.Movie

class MovieCacheDataSourceImpl(): MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}