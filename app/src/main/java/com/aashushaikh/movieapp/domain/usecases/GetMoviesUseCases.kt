package com.aashushaikh.movieapp.domain.usecases

import com.aashushaikh.movieapp.data.model.Movie
import com.aashushaikh.movieapp.domain.repositories.MovieRepository

class GetMoviesUseCases(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}