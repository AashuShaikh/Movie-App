package com.aashushaikh.movieapp.data.datasourceImplementation

import com.aashushaikh.movieapp.data.api.TMDBService
import com.aashushaikh.movieapp.data.datasource.MovieRemoteDataSource
import com.aashushaikh.movieapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey = apiKey)
}