package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.MovieRepositoryImpl
import com.aashushaikh.movieapp.data.datasource.MovieCacheDataSource
import com.aashushaikh.movieapp.data.datasource.MovieLocalDataSource
import com.aashushaikh.movieapp.data.datasource.MovieRemoteDataSource
import com.aashushaikh.movieapp.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieRepositoryModule {
    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }
}