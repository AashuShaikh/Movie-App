package com.aashushaikh.movieapp.presentation

import androidx.lifecycle.liveData
import com.aashushaikh.movieapp.domain.usecases.GetMoviesUseCases
import com.aashushaikh.movieapp.domain.usecases.UpdateMovieUseCase

class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCases,
    private val updateMoviesUseCases: UpdateMovieUseCase
): androidx.lifecycle.ViewModel() {
        fun getMovies() = liveData {
            val movieList = getMoviesUseCase.execute()
            emit(movieList)
        }

        fun updateMovies() = liveData {
            val movieList = updateMoviesUseCases.execute()
            emit(movieList)
        }
}