package com.aashushaikh.movieapp.domain.repositories

import com.aashushaikh.movieapp.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}