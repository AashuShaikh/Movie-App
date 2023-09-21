package com.aashushaikh.movieapp.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    MovieRepositoryModule::class,
    UseCasesModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
}