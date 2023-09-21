package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.domain.repositories.MovieRepository
import com.aashushaikh.movieapp.domain.usecases.GetMoviesUseCases
import com.aashushaikh.movieapp.domain.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Singleton
    @Provides
    fun providesGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCases{
        return GetMoviesUseCases(movieRepository = movieRepository)
    }

    @Singleton
    @Provides
    fun providesUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }
}