package com.aashushaikh.movieapp.presentation.di

import com.aashushaikh.movieapp.data.datasource.MovieCacheDataSource
import com.aashushaikh.movieapp.data.datasourceImplementation.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
}