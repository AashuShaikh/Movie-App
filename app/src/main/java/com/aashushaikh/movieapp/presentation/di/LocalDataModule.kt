package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.data.api.TMDBService
import com.aashushaikh.movieapp.data.datasource.MovieLocalDataSource
import com.aashushaikh.movieapp.data.datasourceImplementation.MovieLocalDataSourceImpl
import com.aashushaikh.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }
}