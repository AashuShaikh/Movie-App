package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.domain.usecases.GetMoviesUseCases
import com.aashushaikh.movieapp.domain.usecases.UpdateMovieUseCase
import com.aashushaikh.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMyViewModelFactory(
        getMoviesUseCases: GetMoviesUseCases,
        updateMovieUseCase: UpdateMovieUseCase
    ): ViewModelFactory{
        return ViewModelFactory(getMoviesUseCases, updateMovieUseCase)
    }
}