package com.aashushaikh.movieapp.data.datasource

import com.aashushaikh.movieapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}