package com.aashushaikh.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aashushaikh.movieapp.domain.usecases.GetMoviesUseCases
import com.aashushaikh.movieapp.domain.usecases.UpdateMovieUseCase
import com.aashushaikh.movieapp.presentation.MyViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMoviesUseCases, updateMovieUseCase) as T
    }
}