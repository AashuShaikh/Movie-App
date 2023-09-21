package com.aashushaikh.movieapp

import com.aashushaikh.movieapp.data.datasource.MovieCacheDataSource
import com.aashushaikh.movieapp.data.datasource.MovieLocalDataSource
import com.aashushaikh.movieapp.data.datasource.MovieRemoteDataSource
import com.aashushaikh.movieapp.data.model.Movie
import com.aashushaikh.movieapp.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            body?.let {
                movieList = body.movies
            }
        }catch (exception: Exception){}
        return movieList
    }

    suspend fun getMoviesFromRoom(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception: Exception){}
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
            return movieList
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){}
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromRoom()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}