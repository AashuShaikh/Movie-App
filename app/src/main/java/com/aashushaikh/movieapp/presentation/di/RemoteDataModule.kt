package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.data.api.TMDBService
import com.aashushaikh.movieapp.data.datasource.MovieRemoteDataSource
import com.aashushaikh.movieapp.data.datasourceImplementation.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }
}