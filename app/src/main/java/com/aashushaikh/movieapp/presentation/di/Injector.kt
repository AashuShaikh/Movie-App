package com.aashushaikh.movieapp.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}